package entidades;

import dao.EsculturasDAO;
import dao.PinturasDAO;

public class Obras {
    
    public String nombre;
    public String autor;
    private int ID;
    private int valor = 0;

    


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int determinantes ) {
        valor = determinantes * 750; 
    }

    

    /*public int getNumCompra() {
        return setNumCompra();
    }*/
    

    
    
    
}
