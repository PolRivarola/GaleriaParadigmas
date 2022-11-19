/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import entidades.Pintura;

/**
 *
 * @author rivar
 */
public class PinturasFactory extends ObrasFactory<Pintura> {

    @Override
    public Pintura getObraDAO(String nombre, int det, String autor,int ID) {
        return new Pintura(nombre,det,autor,ID);
    }
    
    public Pintura getNewObraDAO(String nombre, int det, String autor) {
        return new Pintura(nombre,det,autor);
    }
    
    
    
    

   
    
    
}
