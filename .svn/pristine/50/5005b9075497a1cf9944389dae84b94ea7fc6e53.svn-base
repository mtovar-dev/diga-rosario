/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialogs;

import GUI.Gui;
import GUI.Screens.Screens;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author ARMGARCES
 */
public class Fxml_CheckController implements Initializable{
    @FXML
    private Button bt_aceptar;
    @FXML
    private AnchorPane ap_root;
    @FXML
    private Label lb_mensj;    
    @FXML
    private Button bt_cancelar;
    @FXML
    private TextField usuario;
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_CheckController.fxml'.";

        init_bt_cancelar();
        init_bt_aceptar();
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
    private void init_bt_cancelar(){
        assert bt_cancelar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'Fxml_CheckController.fxml'.";         
        /**
         * 
         */
        bt_cancelar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    closeDialog();
                }
            }
        });
        /**
         * 
         */
        bt_cancelar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                closeDialog();
            }
        });
    }
    /**
     * 
     */
    private void init_bt_aceptar(){
        assert bt_aceptar != null : "fx:id=\"bt_close\" was not injected: check your FXML file 'Fxml_CheckController.fxml'.";
        /**
         * 
         */
        bt_aceptar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    openApp();
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
            openApp();
        }else{
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();                    
        }            
    }

    /**
     * 
     * @param opc 
     */
    private void init_FocusArray(){
        Node[] nodos;
        nodos = new Node[]{usuario};
        Gui.setFields(nodos); 
        Gui.setFieldsSize(nodos.length);
        Gui.setFieldFocused(0);
        //
        for(int i=0;i < Gui.getFields().length; i++){
            FocusPropertyChangeListener fpcl = new FocusPropertyChangeListener(Gui.getFields()[i],i);
            Gui.getFields()[i].focusedProperty().addListener(fpcl);                
        }
    }    
    /**
     * 
     */
    private void openApp(){
        closeDialog();
        if(usuario.getText() != null ){
            boolean isCorrect = Ln.getInstance().check_UserName(usuario.getText());
            if(isCorrect){
                Screens.getInstance().startIndex(Gui.getInstance().getPrimaryStage());  
            }else{                
                Gui.getInstance().showMessage("El Sistema no se encuentra Disponible!", "I");
            }
        }        
    }
}
