/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import dao.EsculturasDAO;

public class Escultura extends Obras {

    public int materiales;

    public Escultura(String nombre,int materiales,String autor,int ID) {
        super();
        this.nombre = nombre;
        this.autor = autor;
        this.materiales = materiales;
        setValor(materiales);
        setID(ID);
        
    }
    
    public Escultura(String nombre,int materiales,String autor){
        super();
        this.nombre = nombre;
        this.materiales = materiales;
        this.autor= autor;
        setValor(materiales);
    }

    public int getMateriales() {
        return materiales;
    }

    public void setMateriales(int materiales) {
        this.materiales = materiales;
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
        return  "Tipo:Escultura, Nombre:" + nombre + ", Autor:" + autor + ", ID:" + getID() + ", Valor:" + getValor() + "\n" ;
    }
}
