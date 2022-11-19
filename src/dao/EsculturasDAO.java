package dao;

import entidades.Escultura;
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


public class EsculturasDAO implements ObrasDAO<Escultura> {

    @Override
    public Escultura buscarObra(int IDBus) {
        Escultura escultura = null;

        Connection conexion = AccesoJDBC.createConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = conexion.prepareStatement("SELECT ID,Nombre,Autor,Materiales FROM Esculturas WHERE ID = ?");
            preparedStatement.setInt(1, IDBus);

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String autor = rs.getString("Autor");
                int materiales = rs.getInt("Materiales");
                int ID = rs.getInt("ID");

                ObrasFactory factory = ObrasFactory.getObrasFactory(2);
                escultura = (Escultura) factory.getObraDAO(nombre, materiales, autor,ID);

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

        return (Escultura) escultura;
    }

    @Override
    public List<Escultura> listarObras() {
        Escultura escultura;

        List<Escultura> listadoUsuarios = new ArrayList<>();

        Connection conexion = AccesoJDBC.createConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = conexion.prepareStatement("SELECT ID,Nombre,Autor,Materiales FROM Esculturas");

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String autor = rs.getString("Autor");
                int materiales = rs.getInt("Materiales");
                int ID = rs.getInt("ID");

                ObrasFactory factory = ObrasFactory.getObrasFactory(2);
                
                escultura = (Escultura) factory.getObraDAO(nombre, materiales, autor,ID);

                listadoUsuarios.add(escultura);
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
    public void registrar(Escultura t) {
        Connection conexion = createConnection();
        Statement statement = null;
        try {
            statement = conexion.createStatement();

            int valor = t.getValor();
            String nombre = t.getNombre();
            String autor = t.getAutor();
            int materiales = t.getMateriales();


            String insertQuery = "INSERT INTO Esculturas(Nombre,Autor,Valor,Materiales) VALUES "
                    + "('" + nombre + "','" + autor + "'," + valor + "," + materiales + ")";
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
            preparedStatement = conexion.prepareStatement("DELETE FROM Esculturas WHERE ID = ?");
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
            } catch (SQLException e) {
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

            int result = statement.executeUpdate("CREATE TABLE Esculturas "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "Nombre VARCHAR,"
                    + "Autor VARCHAR(45),"
                    + "Valor INTEGER,"
                    + "Materiales INTEGER);");

            System.out.println("Tabla Escultura creada satisfactoriamente!");
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
