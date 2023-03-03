/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6p2_darielsevilla;

/**
 *
 * @author HP
 */
public abstract class Usuario {
    protected String username;
    protected float password;
    protected int edad;

    public Usuario() {
    }

    public Usuario(String username, float password, int edad) {
        this.username = username;
        this.password = password;
        this.edad = edad;
    }

    public Usuario(String username, float password) {
        this.username = username;
        this.password = password;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getPassword() {
        return password;
    }

    public void setPassword(float password) {
        this.password = password;
    }

    

    @Override
    public String toString() {
        return username + " - "+edad;
    }

    public abstract int getEdad();
        

    public abstract void setEdad(int edad) throws Exception;
        
    
    
}
