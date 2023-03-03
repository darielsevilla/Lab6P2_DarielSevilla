/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6p2_darielsevilla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Administrador {

    private File fUsuarios;
    private File fLanzamientos;
    private File fCanciones;
    private File fListaReproduccion;

    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Lanzamiento> lanzamientos = new ArrayList();
    private ArrayList<Cancion> canciones = new ArrayList();
    private ArrayList<ListaDeReproduccion> listas = new ArrayList();

    public Administrador() {
    }

    public Administrador(String d, String d2, String d3, String d4) {
        fUsuarios = new File(d);
        fLanzamientos = new File(d2);
        fCanciones = new File(d3);
        fListaReproduccion = new File(d4);
    }

    public File getfUsuarios() {
        return fUsuarios;
    }

    public void setfUsuarios(File fUsuarios) {
        this.fUsuarios = fUsuarios;
    }

    public File getfLanzamientos() {
        return fLanzamientos;
    }

    public void setfLanzamientos(File fLanzamientos) {
        this.fLanzamientos = fLanzamientos;
    }

    public File getfCanciones() {
        return fCanciones;
    }

    public void setfCanciones(File fCanciones) {
        this.fCanciones = fCanciones;
    }

    public File getfListaReproduccion() {
        return fListaReproduccion;
    }

    public void setfListaReproduccion(File fListaReproduccion) {
        this.fListaReproduccion = fListaReproduccion;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Lanzamiento> getLanzamientos() {
        return lanzamientos;
    }

    public void setLanzamientos(ArrayList<Lanzamiento> lanzamientos) {
        this.lanzamientos = lanzamientos;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<ListaDeReproduccion> getListas() {
        return listas;
    }

    public void setListas(ArrayList<ListaDeReproduccion> listas) {
        this.listas = listas;
    }

    public void cargarArchivos() {

        try {
            Scanner lea1 = new Scanner(fUsuarios);
            Scanner lea2 = new Scanner(fLanzamientos);
            Scanner lea3 = new Scanner(fCanciones);
            Scanner lea4 = new Scanner(fListaReproduccion);

            //username-password-edad-
            while (lea1.hasNextLine()) {

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void writeUsuarios() {
        try {
            FileWriter escriba = new FileWriter(fUsuarios, false);
            BufferedWriter bw = new BufferedWriter(escriba);
            for (Usuario u : usuarios) {
                
                bw.write(u.getUsername() + "-" + u.getPassword() + "-" + u.getEdad());

                if (u instanceof Artista) {
                    bw.write("-" + ((Artista) u).getNombreArtistico());
                    
                }
                bw.write("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeCanciones() {
       
        try {
            FileWriter escriba = new FileWriter(fCanciones, false);
            BufferedWriter bw = new BufferedWriter(escriba);
            
            for (Cancion c : canciones) {
                bw.write(c.getTitulo() + "-" + c.getTiempo() + "-" + c.getAlbumPerteneciente());
            }
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public void writeAlbums(BufferedWriter bw, ArrayList<Album> albumes) {
        for (Album c : albumes) {
            try {
                bw.write(c.getTitulo() + ",");
                writeSongs(bw, c.getCanciones());
                bw.write(c.getCantidadCanciones() + ",");
                bw.write(c.getConteoLikes());
            } catch (IOException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
