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
public class Lanzamiento {
    protected String titulo;
    protected Date fechaLanzamiento;
    protected int conteoLikes;

    public Lanzamiento() {
    }

    public Lanzamiento(String titulo, Date fechaLanzamiento, int conteoLikes) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.conteoLikes = conteoLikes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getConteoLikes() {
        return conteoLikes;
    }

    public void setConteoLikes(int conteoLikes) {
        this.conteoLikes = conteoLikes;
    }

    @Override
    public String toString() {
        return titulo + ":" + conteoLikes + ":" + fechaLanzamiento;
    }
    
    
}
