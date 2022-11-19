/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import entidades.Obras;

/**
 *
 * @author rivar
 * @param <T>
 */
public abstract class ObrasFactory <T> {
    public static final int PINTURA = 1;
    public static final int ESCULTURA = 2;
    
    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract T getObraDAO(String nombre, int det, String autor,int ID);
    
    public static ObrasFactory getObrasFactory(int factory) {
        switch (factory) {
            case PINTURA:
                return new PinturasFactory();
            case ESCULTURA:
                return new EsculturaFactory();
            default:
                return null;
        }
    }
}
