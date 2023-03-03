/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6p2_darielsevilla;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Album extends Lanzamiento {

    private ArrayList<Cancion> canciones = new ArrayList();
    private int cantidadCanciones = 0;

    public Album() {
        super();
    }

    public Album(String titulo, Date fechaLanzamiento, int conteoLikes) {
        super(titulo, fechaLanzamiento, conteoLikes);
    }

    public void addCancion(Cancion c) {
        canciones.add(c);
        cantidadCanciones++;
    }

    public void removeCanciones(Cancion c) {
        if (canciones.contains(c)) {
            canciones.remove(c);
            cantidadCanciones--;
        }
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
        cantidadCanciones = canciones.size();
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    @Override
    public String toString() {
        return super.toString() + ":" +cantidadCanciones + " canciones";
    }

    
    
}
