/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.System;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ARMGARCES
 */
public class Sesion {
    
    private String username;    
    private String fullName;
    private int id_rol;
    private String rolName;
    private int status;
    private String[] localInfo;
    private String email;
    private String email_pswd;

    /**
     * 
     * @param data 
     * @throws java.lang.Exception 
     */
    public Sesion(ResultSet data) throws Exception{
        try{
            username        = data.getString(1);
            id_rol          = data.getInt(2);
            status          = data.getInt(3);
            fullName        = data.getString(4);
            rolName         = data.getString(5);
            email           = data.getString(6);
            email_pswd      = data.getString(7);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
            throw e;
        }
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
     * @return the id_rol
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     * @param id_rol the id_rol to set
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
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
     * @return the localInfo
     */
    public String[] getLocalInfo() {
        return localInfo;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the rolName
     */
    public String getRolName() {
        return rolName;
    }

    /**
     * @param rolName the rolName to set
     */
    public void setRolName(String rolName) {
        this.rolName = rolName;
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
