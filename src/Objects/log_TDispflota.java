/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class log_TDispflota {
    private int idTDispflota;
    private String nombre;
    private String abrev;
    private int valpersonal;
    private int valvehiculo;
    private int status;

    /**
     * 
     */
    public log_TDispflota(){
        
    }

    /**
     * 
     * @param rs 
     */
    public log_TDispflota(ResultSet rs){
        try{
            idTDispflota    = rs.getInt(1);
            nombre          = rs.getString(2);
            abrev           = rs.getString(3);
            valpersonal     = rs.getInt(4);
            valvehiculo     = rs.getInt(5);
            status          = rs.getInt(6);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idTDispflota
     */
    public int getIdTDispflota() {
        return idTDispflota;
    }

    /**
     * @param idTDispflota the idTDispflota to set
     */
    public void setIdTDispflota(int idTDispflota) {
        this.idTDispflota = idTDispflota;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the abrev
     */
    public String getAbrev() {
        return abrev;
    }

    /**
     * @param abrev the abrev to set
     */
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    /**
     * @return the valpersonal
     */
    public int getValpersonal() {
        return valpersonal;
    }

    /**
     * @param valpersonal the valpersonal to set
     */
    public void setValpersonal(int valpersonal) {
        this.valpersonal = valpersonal;
    }

    /**
     * @return the valvehiculo
     */
    public int getValvehiculo() {
        return valvehiculo;
    }

    /**
     * @param valvehiculo the valvehiculo to set
     */
    public void setValvehiculo(int valvehiculo) {
        this.valvehiculo = valvehiculo;
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
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
