package dao;

import entidades.Pintura;
import factory.ObrasFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.AccesoJDBC;
import static jdbc.AccesoJDBC.createConnection;

/**
 *
 * @author rivar
 */
public class PinturasDAO implements ObrasDAO<Pintura> {

    @Override
    public Pintura buscarObra(int IDBus) {
        Pintura pintura = null;

        Connection conexion = AccesoJDBC.createConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            //Crear objeto PreparedStatement para realizar queries a la base de datos
            preparedStatement = conexion.prepareStatement("SELECT ID,Nombre,Autor,Colores FROM Pinturas WHERE ID = ?");
            preparedStatement.setInt(1, IDBus);

            //Un objeto ResultSet, almacena los datos de resultados de una consulta
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String autor = rs.getString("Autor");
                int colores = rs.getInt("Colores");
                int ID = rs.getInt("ID");
                ObrasFactory factory = ObrasFactory.getObrasFactory(1);
                pintura = (Pintura) factory.getObraDAO(nombre, colores, autor, ID);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return pintura;
    }

    @Override
    public List<Pintura> listarObras() {
        Pintura pintura;

        List<Pintura> listadoUsuarios = new ArrayList<Pintura>();

        Connection conexion = AccesoJDBC.createConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            //Crear objeto PreparedStatement para realizar queries a la base de datos
            preparedStatement = conexion.prepareStatement("SELECT ID,Nombre,Colores,Autor FROM Pinturas");

            //Un objeto ResultSet, almacena los datos de resultados de una consulta
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String autor = rs.getString("Autor");
                int colores = rs.getInt("Colores");
                int ID = rs.getInt("ID");

                ObrasFactory factory = ObrasFactory.getObrasFactory(1);
                pintura = (Pintura) factory.getObraDAO(nombre, colores, autor, ID);

                listadoUsuarios.add(pintura);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return listadoUsuarios;
    }

    @Override
    public void registrar(Pintura t) {
        Connection conexion = createConnection();
        Statement statement = null;
        try {
            statement = conexion.createStatement();

            int valor = t.getValor();
            String nombre = t.getNombre();
            String autor = t.getAutor();
            int colores = t.getCantcolores();

            String insertQuery = "INSERT INTO Pinturas(Nombre,Autor,Valor,Colores)  VALUES "
                    + "('" + nombre + "','" + autor + "'," + valor + "," + colores + ")";
            int result = statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                statement.close();
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void eliminar(int ID) {
        Connection conexion = AccesoJDBC.createConnection();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement("DELETE FROM Pinturas WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @Override
    public void crearTabla() {
        Connection conexion = null;
        Statement statement = null;

        try {
            conexion = AccesoJDBC.createConnection();

            //Crear objeto Statement para realizar queries a la base de datos
            statement = conexion.createStatement();

            int result = statement.executeUpdate("CREATE TABLE Pinturas "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "Nombre VARCHAR, "
                    + "Autor VARCHAR(45),"
                    + "Valor INTEGER,"
                    + "Colores INTEGER);");

            System.out.println("Tabla Pinturas creada satisfactoriamente!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

}
