/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialogs;

import GUI.Gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ARMGARCES
 */
public class Fxml_ConfigController implements Initializable {

    @FXML //  fx:id="bt_close"
    private Label bt_close; // Value injected by FXMLLoader
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // TODO
        init_bt_close();
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
}
