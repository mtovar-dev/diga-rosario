/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.System;

import Tools.Protector;
import Tools.Tools;
import java.sql.ResultSet;

/**
 *
 * @author ARMGARCES
 */
public class Usuario {
    private int id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String username;
    private String pswd_old;
    private String pswd_new;
    private int status;
    private Rol rol;
    private String email;
    private String email_pswd;
    
    /**
     * 
     */
    public Usuario() {
        
    }
    /**
     * 
     * @param rs 
     */
    public Usuario(ResultSet rs){
        try{            
        //Datos del Usuario
        id                  = rs.getInt(1);
        username            = rs.getString(2);
        nombre1             = rs.getString(3);
        nombre2             = rs.getString(4);
        apellido1           = rs.getString(5);
        apellido2           = rs.getString(6);

        //Desencriptacion de la Contraseña del usuario
        String salt = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");
        pswd_old            = Protector.decrypt(rs.getString(7), salt);
        status              = rs.getInt(8);        

        //Datos del Rol del Usuario
        Rol obj = new Rol();
        obj.setIdRol( rs.getInt(9));
        obj.setNombre(rs.getString(10));
        obj.setAbrev( rs.getString(11));
        rol = obj;

        email               = rs.getString(12);
        email_pswd          = rs.getString(13);
        
        }catch(Exception e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());           
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre1
     */
    public String getNombre1() {
        return nombre1;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @return the nombre2
     */
    public String getNombre2() {
        return nombre2;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the pswd_old
     */
    public String getPswd_old() {
        return pswd_old;
    }

    /**
     * @param pswd_old the pswd_old to set
     */
    public void setPswd_old(String pswd_old) {
        this.pswd_old = pswd_old;
    }

    /**
     * @return the pswd_new
     */
    public String getPswd_new() {
        return pswd_new;
    }

    /**
     * @param pswd_new the pswd_new to set
     */
    public void setPswd_new(String pswd_new) {
        this.pswd_new = pswd_new;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString(){
        return getUsername() +" / "+getNombre1();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the email_pswd
     */
    public String getEmail_pswd() {
        return email_pswd;
    }

    /**
     * @param email_pswd the email_pswd to set
     */
    public void setEmail_pswd(String email_pswd) {
        this.email_pswd = email_pswd;
    }
}

