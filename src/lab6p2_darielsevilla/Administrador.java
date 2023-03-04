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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private File bitacora;

    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Lanzamiento> lanzamientos = new ArrayList();
    private ArrayList<Cancion> canciones = new ArrayList();
    private ArrayList<ListaDeReproduccion> listas = new ArrayList();

    public Administrador() {
    }

    public Administrador(String d, String d2, String d3, String d4, String d5) {
        fUsuarios = new File(d);
        fLanzamientos = new File(d2);
        fCanciones = new File(d3);
        fListaReproduccion = new File(d4);
        bitacora = new File(d5);
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

            //usuarios
            while (lea1.hasNextLine()) {
                String temp = lea1.nextLine();
                String[] array = temp.split("-");

                if (array.length == 3) {

                    Oyente e = new Oyente(array[0], array[1], Integer.parseInt(array[2]));

                    usuarios.add(e);
                } else {
                    Artista e = new Artista(array[0], array[1], Integer.parseInt(array[2]), array[3]);
                    usuarios.add(e);
                }
            }

            //Listas
            while (lea4.hasNextLine()) {
                String temp = lea4.nextLine();
                String[] array = temp.split("-");

                listas.add(new ListaDeReproduccion(array[0], Integer.parseInt(array[1])));
            }

            //Lanzamiento
            while (lea2.hasNextLine()) {

                String temp = lea2.nextLine();
                String[] array = temp.split("-");

                if (array.length == 6) {
                    Album a = new Album(array[0], new Date(array[3]), Integer.parseInt(array[2]), Integer.parseInt(array[1]), array[4]);
                   
                    a.setConteoLikes(Integer.parseInt(array[5]));
                    for (Usuario u : usuarios) {
                        if (u.getUsername().equals(a.getCreador())) {
                            ((Artista) u).getLanzamiento().add(a);
                        }
                    }
                    lanzamientos.add(a);

                } else {

                    Single a = new Single(array[0], new Date(array[3]), Integer.parseInt(array[2]), Integer.parseInt(array[1]), array[4]);
                   
                    lanzamientos.add(a);
                    for (Usuario u : usuarios) {
                        if (u.getUsername().equals(a.getCreador())) {
                            ((Artista) u).getLanzamiento().add(a);

                        }
                    }

                }

            }

            //canciones
            while (lea3.hasNextLine()) {
                String temp = lea3.nextLine();
                String[] array = temp.split("-");

                Cancion c = new Cancion(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]));

                if (array.length == 4) {
                    String[] arr2 = array[3].split(",");

                    for (String string : arr2) {
                        c.getPlaylists().add(Integer.parseInt(string));
                        for (ListaDeReproduccion l : listas) {
                            if (l.getId() == Integer.parseInt(string)) {
                                l.getCanciones().add(c);

                            }
                        }
                    }
                }
              
                for (Lanzamiento l : lanzamientos) {
                
                        
                    if (l.getId() == c.getAlbumPerteneciente()) {
                        
                        if (l instanceof Album) {
                            ((Album) l).addCancion(c);
                        } else {
                            ((Single) l).setCancion(c);

                        }
                    }
                }
                canciones.add(c);
            }

            lea1.close();
            lea2.close();
            lea3.close();
            lea4.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

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
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeCanciones() {

        try {
            FileWriter escriba = new FileWriter(fCanciones, false);
            BufferedWriter bw = new BufferedWriter(escriba);

            for (Cancion c : canciones) {
                bw.write(c.getTitulo() + "-" + c.getTiempo() + "-" + c.getAlbumPerteneciente() + "-");
                for (int a : c.getPlaylists()) {
                    bw.write(Integer.toString(a));
                    if (c.getPlaylists().indexOf(a) != c.getPlaylists().size() - 1) {
                        bw.write(",");
                    }
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void writeLanzamientos() {
        try {
            FileWriter escriba = new FileWriter(fLanzamientos);
            BufferedWriter bw = new BufferedWriter(escriba);

            for (Lanzamiento l : lanzamientos) {

                bw.write(l.getTitulo() + "-" + l.getId() + "-" + l.getConteoLikes() + "-" + l.getFechaLanzamiento() + "-" + l.getCreador());

                if (l instanceof Album) {
                    bw.write(((Album) l).getCantidadCanciones());
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeListas() {
        try {
            FileWriter escriba = new FileWriter(fListaReproduccion);
            BufferedWriter bw = new BufferedWriter(escriba);
            for (ListaDeReproduccion r : listas) {
                bw.write(r.getNombre() + "-" + r.getConteoLikes() + "-" + r.getUsuario() + "-" + r.getId());
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeBitacora(Usuario user) {
        try {
            FileWriter escriba = new FileWriter(bitacora, true);
            BufferedWriter bw = new BufferedWriter(escriba);
            bw.write(user.getUsername() + "-");
            if (user instanceof Oyente) {
                bw.write("Oyente-");
            } else {
                bw.write("Artista-");
            }
            Date d = new Date();
            bw.write(d.toString());
            bw.write("\n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
