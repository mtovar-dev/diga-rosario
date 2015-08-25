/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.TopBar;

import GUI.Gui;
import LN.Ln;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author ARMGARCES
 */
public class TopBarController implements Initializable {
    
    @FXML //  fx:id="ap_topbar"
    private AnchorPane ap_topbar; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bt_close"
    private Label bt_close;
    
    @FXML //  fx:id="bt_min"
    private Label bt_min; 
    
    @FXML //  fx:id="im_login"
    private ImageView im_login; // Value injected by FXMLLoader

    @FXML //  fx:id="im_logout"
    private ImageView im_logout; // Value injected by FXMLLoader
    
    @FXML //  fx:id="lb_sesion"
    private Label lb_sesion; // Value injected by FXMLLoader

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources){
       assert ap_topbar != null : "fx:id=\"ap_topbar\" was not injected: check your FXML file 'Fxml_TopBar.fxml'.";
       assert lb_sesion != null : "fx:id=\"lb_sesion\" was not injected: check your FXML file 'Fxml_TopBar.fxml'.";        
       // initialize your logic here: all @FXML variables will have been injected
       
       init_bt_close();
       init_bt_min();
       init_im_login();
       init_im_logout();       
    }    
    /**
     * Proceso que inicializa y define las acciones del Boton de Cerrar Ventana
     */
    private void init_bt_close(){
        assert bt_close != null : "fx:id=\"bt_close\" was not injected: check your FXML file 'Fxml_TopBar.fxml'.";
        
        bt_close.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonClose();
                }
            }
        });
    }
    
    /**
     * Proceso que inicializa y define las acciones del Boton de Minimizar
     */
    private void init_bt_min(){
        assert bt_min != null : "fx:id=\"bt_min\" was not injected: check your FXML file 'Fxml_TopBar.fxml'.";
        
        bt_min.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonMinimize();
                }
            }
        });
    }    
    /**
     * 
     */
    private void init_im_login() {
         assert im_login != null : "fx:id=\"im_login\" was not injected: check your FXML file 'fxml_TopBar.fxml'.";
         
         Gui.getInstance().setIm_login(im_login);
         
         im_login.setOnMouseClicked((MouseEvent mouseEvent) -> {
             if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                 if(mouseEvent.getClickCount() > 0){
                     botonLogIn();
                 }
             }
         });
    }    
    /**
     * 
     */
    private void init_im_logout() {
         assert im_logout != null : "fx:id=\"im_logout\" was not injected: check your FXML file 'Fxml_TopBar.fxml'.";
         
         Gui.getInstance().setIm_logout(im_logout);
         
         im_logout.setOnMouseClicked((MouseEvent mouseEvent) -> {
             if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                 if(mouseEvent.getClickCount() > 0){
                     //Llamada al Archivo FXML
                     botonLogOut();
                 }
             }
         });
    }    
     /**
     * 
     */
    public static void botonClose(){
        Ln.getInstance().closeApp();
        System.exit(0);    
    }                 
    /**
     * 
     */
    public static void botonLogIn(){
        //Llamada al Archivo FXML
        AnchorPane login = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_LogIn.fxml");                            
        //Despliega la Ventana Emergente
        Gui.getInstance().showDialog(login,0);    
    }
    /**
     * 
     */
    public static void botonLogOut(){
        //Cerrar Sesion
        Ln.getInstance().logOut();   
    }
    /**
     * 
     */
    public static void botonMinimize(){
        Gui.getInstance().Minimize();
    }
}
