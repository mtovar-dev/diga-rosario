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
public class log_TMotdev {
    private int idTMotdev;
    private String nombre;
    private String abrev; 
    private int valclasif;
    private int valdev;
    private int valblq;
    private int valobserv;
    private int valfact;
    private int status;
    /**
     * 
     */
    public log_TMotdev(){
        
    }

    /**
     * 
     * @param rs 
     */
    public log_TMotdev(ResultSet rs){
        try{
            idTMotdev       = rs.getInt(1);
            nombre          = rs.getString(2);
            abrev           = rs.getString(3);
            valclasif       = rs.getInt(4);
            valdev          = rs.getInt(5);
            valblq          = rs.getInt(6);
            status          = rs.getInt(7);
            valobserv       = rs.getInt(8);
            valfact         = rs.getInt(9);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idTMotdev
     */
    public int getIdTMotdev() {
        return idTMotdev;
    }

    /**
     * @param idTMotdev the idTMotdev to set
     */
    public void setIdTMotdev(int idTMotdev) {
        this.idTMotdev = idTMotdev;
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
     * @return the valclasif
     */
    public int getValclasif() {
        return valclasif;
    }

    /**
     * @param valclasif the valclasif to set
     */
    public void setValclasif(int valclasif) {
        this.valclasif = valclasif;
    }

    /**
     * @return the valdev
     */
    public int getValdev() {
        return valdev;
    }

    /**
     * @param valdev the valdev to set
     */
    public void setValdev(int valdev) {
        this.valdev = valdev;
    }

    /**
     * @return the valblq
     */
    public int getValblq() {
        return valblq;
    }

    /**
     * @param valblq the valblq to set
     */
    public void setValblq(int valblq) {
        this.valblq = valblq;
    }

    /**
     * @return the valobserv
     */
    public int getValobserv() {
        return valobserv;
    }

    /**
     * @param valobserv the valobserv to set
     */
    public void setValobserv(int valobserv) {
        this.valobserv = valobserv;
    }

    /**
     * @return the valfact
     */
    public int getValfact() {
        return valfact;
    }

    /**
     * @param valfact the valfact to set
     */
    public void setValfact(int valfact) {
        this.valfact = valfact;
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
     * @return 
     */
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
