/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialogs;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ARMGARCES
 */
public class Fxml_LogInController implements Initializable {

    @FXML //  fx:id="ap_root"
    private AnchorPane ap_root; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bt_close"
    private Label bt_close; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bt_login"
    private Button bt_login; // Value injected by FXMLLoader

    @FXML //  fx:id="pswd"
    private PasswordField pswd; // Value injected by FXMLLoader

    @FXML //  fx:id="usuario"
    private TextField usuario; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_User.fxml'.";

        init_bt_close();
        init_bt_login();
        init_FocusArray();
        //Capturador de eventos de Teclado en toda la pantalla         
        ap_root.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                nextFocusedField(ke);
            }
            if (ke.getCode().equals(KeyCode.ESCAPE)){
                closeDialog();
            }
        });
    }    
    /**
     * 
     */
    private void closeDialog(){
        Gui.getInstance().closeDialog();
    }
    /**
     * 
     */
    private void init_bt_close(){
        assert bt_close != null : "fx:id=\"bt_close\" was not injected: check your FXML file 'fxml_LogIn.fxml'.";
         
         bt_close.setOnMouseClicked((MouseEvent mouseEvent) -> {
             if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                 if(mouseEvent.getClickCount() > 0){
                     Gui.getInstance().closeDialog();
                 }
             }
        });
    }
    
    /**
     * 
     */
    private void init_bt_login(){
        assert bt_login != null : "fx:id=\"bt_close\" was not injected: check your FXML file 'fxml_LogIn.fxml'.";
         
         bt_login.setOnMouseClicked((MouseEvent mouseEvent) -> {
             if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                 if(mouseEvent.getClickCount() > 0){
                     //
                    Ln.getInstance().logIn(usuario.getText(), pswd.getText());
                 }
             }
        });         
    }

    /**
     * 
     */
    private void nextFocusedField(KeyEvent ke) {
        Gui.sumFieldFocused();        
        if(Gui.getFieldFocused() >= Gui.getFieldsSize()){
            if(usuario.getText() != null && pswd.getText() != null){
                Ln.getInstance().logIn(usuario.getText(), pswd.getText());
            }
        }            
        else{
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();                    
        }
            
    }

    /**
     * 
     * @param opc 
     */
    private void init_FocusArray(){
        Node[] nodos;
        nodos = new Node[]{usuario,pswd};
        Gui.setFields(nodos); 
        Gui.setFieldsSize(nodos.length);
        Gui.setFieldFocused(0);
        //
        for(int i=0;i < Gui.getFields().length; i++){
            FocusPropertyChangeListener fpcl = new FocusPropertyChangeListener(Gui.getFields()[i],i);
            Gui.getFields()[i].focusedProperty().addListener(fpcl);                
        }
    }    
}
