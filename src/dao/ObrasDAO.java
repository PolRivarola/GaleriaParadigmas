/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author rivar
 * @param <T>
 */
public interface ObrasDAO<T> {
    
    public T buscarObra(int numCompra);
    
    public List<T> listarObras();
    
    public void registrar(T t);
    
    public void eliminar(int ID);
    
    
    public void crearTabla();
}
