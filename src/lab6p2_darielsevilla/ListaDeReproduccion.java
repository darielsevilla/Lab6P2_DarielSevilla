/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6p2_darielsevilla;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ListaDeReproduccion {
    private String nombre;
    private int conteoLikes;
    private ArrayList<Cancion> canciones = new ArrayList();

    public ListaDeReproduccion() {
    }

    public ListaDeReproduccion(String nombre, int conteoLikes) {
        this.nombre = nombre;
        this.conteoLikes = conteoLikes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getConteoLikes() {
        return conteoLikes;
    }

    public void setConteoLikes(int conteoLikes) {
        this.conteoLikes = conteoLikes;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return nombre + " - " + canciones.size() + " canciones - " + conteoLikes + " likes";
    }
    
   
    
    
}
