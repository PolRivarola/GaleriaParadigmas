package entidades;

import dao.PinturasDAO;

public class Pintura extends Obras {

    private int Cantcolores;

    public Pintura(String nombre, int colores, String autor, int ID) {
        super();
        this.nombre = nombre;
        this.Cantcolores = colores;
        this.autor = autor;
        setValor(colores);
        setID(ID);

    }

    public Pintura(String nombre, int colores, String autor) {
        super();
        this.nombre = nombre;
        this.Cantcolores = colores;
        this.autor = autor;
        setValor(colores);
    }

    public int getCantcolores() {
        return Cantcolores;
    }

    public void setCantcolores(int Cantcolores) {
        this.Cantcolores = Cantcolores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Tipo:Pintura, Nombre:" + nombre + ", Autor:" + autor + ", ID:" + getID() + ", Valor:" + getValor() + "\n";
    }

}
