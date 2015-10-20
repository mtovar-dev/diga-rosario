/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Indicators;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Zsi_nros_sem {
    private int ano;
    private int sem;
    private double Xm;
    private double Rm;
    
    /**
     * 
     */
    public Zsi_nros_sem(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Zsi_nros_sem(ResultSet rs){
        try{
            ano         = rs.getInt(1);
            sem         = rs.getInt(2);
            Xm          = rs.getDouble(3);
            Rm          = rs.getDouble(4);
            
                    
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the sem
     */
    public int getSem() {
        return sem;
    }

    /**
     * @param sem the sem to set
     */
    public void setSem(int sem) {
        this.sem = sem;
    }

    /**
     * @return the Xm
     */
    public double getXm() {
        return Xm;
    }

    /**
     * @param Xm the Xm to set
     */
    public void setXm(double Xm) {
        this.Xm = Xm;
    }

    /**
     * @return the Rm
     */
    public double getRm() {
        return Rm;
    }

    /**
     * @param Rm the Rm to set
     */
    public void setRm(double Rm) {
        this.Rm = Rm;
    }

}
