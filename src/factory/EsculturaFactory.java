package factory;

import entidades.Escultura;
import entidades.Obras;


public class EsculturaFactory extends ObrasFactory {
    
    @Override
    public Escultura getObraDAO(String nombre, int det, String autor,int ID) {
        return new Escultura(nombre,det, autor,ID);    
    }
    
    public Escultura getNewObraDAO(String nombre, int det, String autor) {
        return new Escultura(nombre,det, autor);    
    }
    
    
    
}
