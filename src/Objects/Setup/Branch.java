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
 * @author MITM
 */
public class Branch {
    private int idBranch;
    private String codigo;
    private String nombre;
    private String abrev;     
    private int status;
    /**
     * 
     */
    public Branch(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Branch(ResultSet rs){
        try{
            idBranch        = rs.getInt(1);
            codigo          = rs.getString(2);
            nombre          = rs.getString(3);
            abrev           = rs.getString(4);
            status          = rs.getInt(5);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }    

    /**
     * @return the idBranch
     */
    public int getIdBranch() {
        return idBranch;
    }

    /**
     * @param idBranch the idBranch to set
     */
    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
