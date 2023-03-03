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
public class Oyente extends Usuario{
    private ArrayList<Cancion> canciones = new ArrayList();
    private ArrayList<ListaDeReproduccion> listasCreadas  = new ArrayList();
    private ArrayList<ListaDeReproduccion> listasConLike = new ArrayList();

    public Oyente() {
        super();
    }

    public Oyente(String username, String password, int edad) throws Exception {
        super(username, password);
        setEdad(edad);
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<ListaDeReproduccion> getListasCreadas() {
        return listasCreadas;
    }

    public void setListasCreadas(ArrayList<ListaDeReproduccion> listasCreadas) {
        this.listasCreadas = listasCreadas;
    }

    public ArrayList<ListaDeReproduccion> getListasConLike() {
        return listasConLike;
    }

    public void setListasConLike(ArrayList<ListaDeReproduccion> listasConLike) {
        this.listasConLike = listasConLike;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) throws Exception {
        if(edad >= 12){
            this.edad = edad;
        }else{
            throw new Exception("Edad debe ser mayor a 12");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - Oyente";
    }
    
    
    
}
