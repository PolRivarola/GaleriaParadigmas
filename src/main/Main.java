package main;

import dao.*;
import entidades.Escultura;
import entidades.Pintura;
import factory.EsculturaFactory;
import factory.ObrasFactory;
import factory.PinturasFactory;
import gui.App;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ObrasDAO pinturas = new PinturasDAO();
        ObrasDAO esculturas = new EsculturasDAO();
        
        esculturas.crearTabla();
        pinturas.crearTabla();
        
        App app = new App();
        
        
    }
}
