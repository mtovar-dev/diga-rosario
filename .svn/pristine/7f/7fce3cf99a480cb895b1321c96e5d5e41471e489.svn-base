/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.TopBar;

import BD.ConnBdType;
import GUI.Gui;
import Objects.System.Sesion;
import Tools.Tools;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author ARMGARCES
 */
public class TopBar {
    private static Gui gui = Gui.getInstance();
    private static String[] tooltips;

    private TopBar() {
    }
    
    /**
     * 
     * @param param 
     */
    public static void refreshSesion(Sesion param){
        Node node = Tools.getNode(Gui.getAp_topbar(), "#lb_sesion");
        Label lb_sesion = (Label) node;
        if(param != null){
            lb_sesion.setText(param.getUsername());

            tooltips = new String[]{
                "       Usuario: "  + param.getFullName() + "  \n" +
                "      Servidor: "  + ConnBdType.serverName.substring(8) + " \n" +
                " Base_Datos: "     + ConnBdType.databaseName.substring(8).toUpperCase() + " "
                };

            Tooltip tip_tool = new Tooltip(tooltips[0]);
            Tooltip.install(lb_sesion, tip_tool);

        }else{
            lb_sesion.setText("");
        }
    }
    
    /**
     * 
     */
    public static void refreshLogImage(){
        
        Node node = Tools.getNode(Gui.getAp_topbar(),"#hbox");        
        HBox hbox = (HBox) node;
        ImageView im = (ImageView) hbox.getChildren().get(0);
        hbox.getChildren().remove(0);
        
        if(im.getId().equals("im_login")){
            hbox.getChildren().add(gui.getIm_logout());
        }
        if(im.getId().equals("im_logout")){
            hbox.getChildren().add(gui.getIm_login());
        }
    }
    /**************************************************************************/
    /**
     * 
     * @return 
     */
    public static TopBar getInstance() {
        return TopBarHolder.INSTANCE;
    }
    
    private static class TopBarHolder {

        private static final TopBar INSTANCE = new TopBar();
    }
}
