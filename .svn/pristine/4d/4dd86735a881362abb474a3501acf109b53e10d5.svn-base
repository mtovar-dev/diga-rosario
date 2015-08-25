/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects.System;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class ItemPrintScreen {
    
    private int     id_mnu_print;
    private String  nombre_mn;
    private int     id_screen;

    /*  
     * 
     */    
    public ItemPrintScreen(){
    
    }

    /*  
     * 
     * @param rs 
     */
    public ItemPrintScreen(ResultSet rs){
        try{
            id_mnu_print    = rs.getInt(1);
            nombre_mn       = rs.getString(2);            
            id_screen       = rs.getInt(3);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }        
    }

    /**
     * @return the id_mnu_print
     */
    public int getId_mnu_print() {
        return id_mnu_print;
    }

    /**
     * @param id_mnu_print the id_mnu_print to set
     */
    public void setId_mnu_print(int id_mnu_print) {
        this.id_mnu_print = id_mnu_print;
    }

    /**
     * @return the nombre_mn
     */
    public String getNombre_mn() {
        return nombre_mn;
    }

    /**
     * @param nombre_mn the nombre_mn to set
     */
    public void setNombre_mn(String nombre_mn) {
        this.nombre_mn = nombre_mn;
    }

    /**
     * @return the id_screen
     */
    public int getId_screen() {
        return id_screen;
    }

    /**
     * @param id_screen the id_screen to set
     */
    public void setId_screen(int id_screen) {
        this.id_screen = id_screen;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.nombre_mn;
    }
    
}
