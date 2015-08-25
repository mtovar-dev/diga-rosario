/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects.Setup;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Personal
 */
public class Reason {
    private int idReason;
    private String nombre;
    private String abrev; 
    private int valClasif;
    private int valDev;
    private int valblq;
    private int status;
    private int valobserv;
    private int valfact;
    /**
     * 
     */
    public Reason(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Reason(ResultSet rs){
        try{
            idReason        = rs.getInt(1);
            nombre          = rs.getString(2);
            abrev           = rs.getString(3);
            valClasif       = rs.getInt(4);
            valDev          = rs.getInt(5);
            valblq          = rs.getInt(6);
            status          = rs.getInt(7);
            valobserv       = rs.getInt(8);
            valfact         = rs.getInt(9);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the idReason
     */
    public int getIdReason() {
        return idReason;
    }

    /**
     * @param idReason the idReason to set
     */
    public void setIdReason(int idReason) {
        this.idReason = idReason;
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
     * @return the valClasif
     */
    public int getValClasif() {
        return valClasif;
    }

    /**
     * @param valClasif the valClasif to set
     */
    public void setValClasif(int valClasif) {
        this.valClasif = valClasif;
    }

    /**
     * @return the valDev
     */
    public int getValDev() {
        return valDev;
    }

    /**
     * @param valDev the valDev to set
     */
    public void setValDev(int valDev) {
        this.valDev = valDev;
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
        //return this.abrev + " / " + this.nombre ;
        return this.getNombre() ;
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

}
