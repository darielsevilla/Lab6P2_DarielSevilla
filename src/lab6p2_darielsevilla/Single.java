/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6p2_darielsevilla;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Single extends Lanzamiento{
    private Cancion cancion;

    public Single() {
        super();
    }

    public Single(String titulo, Date fechaLanzamiento, int conteoLikes, int id, String creador) {
        super(titulo, fechaLanzamiento, conteoLikes, id, creador);
    }

    
    public Single(Cancion cancion, String titulo, Date fechaLanzamiento, int conteoLikes, int id, String creador) {
        super(titulo, fechaLanzamiento, conteoLikes, id, creador);
        this.cancion = cancion;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return super.toString()+":Single";
    }
    
    
}
