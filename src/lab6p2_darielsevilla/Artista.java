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
public class Artista extends Usuario{
    protected String nombreArtistico;

    protected ArrayList<Lanzamiento> albumes = new ArrayList();

    public Artista() {
        super();
    }

    public Artista(String username, String password, int edad, String nombreArtistico) throws Exception {
        super(username, password);
        this.nombreArtistico = nombreArtistico;
        setEdad(edad);
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

 

    
    public ArrayList<Lanzamiento> getLanzamiento() {
        return albumes;
    }

    public void setLanzamiento(ArrayList<Lanzamiento> albumes) {
        this.albumes = albumes;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) throws Exception {
        if(edad >= 18){
            this.edad = edad;
        }else{
            throw new Exception("Ingrese edad valida");
        }
    }

    @Override
    public String toString() {
        return super.toString()+" - Artista";
    }
    
    
    
    
    
}
