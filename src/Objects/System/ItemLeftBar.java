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
 * @author MITM
 */
public class ItemLeftBar {
    
    private int     id_menu;
    private String  menu;
    private String  nombre_mn;
    private int     id_smenu1;
    private String  nombre_smn1;
    
    private String string;
    /*  
     * 
     */
    public ItemLeftBar(){
    
    }
    
    /*  
     * 
     * @param rs 
     */
    public ItemLeftBar(ResultSet rs){
        try{
            id_menu         = rs.getInt(1);
            menu            = rs.getString(2);            
            nombre_mn       = rs.getString(3);
            id_smenu1       = rs.getInt(4);
            nombre_smn1     = rs.getString(5);
            
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }        
    }

    /**
     * @return the id_menu
     */
    public int getId_menu() {
        return id_menu;
    }

    /**
     * @param id_menu the id_menu to set
     */
    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    /**
     * @return the menu
     */
    public String getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(String menu) {
        this.menu = menu;
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
     * @return the id_smenu1
     */
    public int getId_smenu1() {
        return id_smenu1;
    }

    /**
     * @param id_smenu1 the id_smenu1 to set
     */
    public void setId_smenu1(int id_smenu1) {
        this.id_smenu1 = id_smenu1;
    }

    /**
     * @return the nombre_smn1
     */
    public String getNombre_smn1() {
        return nombre_smn1;
    }

    /**
     * @param nombre_smn1 the nombre_smn1 to set
     */
    public void setNombre_smn1(String nombre_smn1) {
        this.nombre_smn1 = nombre_smn1;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return string;
    }
}
