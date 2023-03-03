/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6p2_darielsevilla;

/**
 *
 * @author HP
 */
public class Cancion {
    private String titulo;
    private int tiempo;
    private int albumPerteneciente;

    public Cancion() {
    }

    public Cancion(String titulo, int tiempo,  int albumPerteneciente) {
        this.titulo = titulo;
        this.tiempo = tiempo;
        this.albumPerteneciente = albumPerteneciente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getAlbumPerteneciente() {
        return albumPerteneciente;
    }

    public void setAlbumPerteneciente(int albumPerteneciente) {
        this.albumPerteneciente = albumPerteneciente;
    }

    @Override
    public String toString() {
        return titulo + " - " + tiempo + " : " + albumPerteneciente;
    }
    
    
}
