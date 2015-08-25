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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ARMGARCES
 *         MITM
 */
public class Fxml_ErrorController implements Initializable {

    @FXML 
    private AnchorPane ap_root1; 
    
    @FXML 
    private Label lb_error; 
        
    @FXML 
    private ImageView im_close; 

    @FXML 
    private ImageView im_icon; 

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root1 != null : "fx:id=\"ap_root1\" was not injected: check your FXML file 'Fxml_Error.fxml'.";
        assert im_icon != null : "fx:id=\"im_icon\" was not injected: check your FXML file 'fxml_Error.fxml'.";                 
        // TODO
        init_label();
        init_im_close();
        
        //Capturador de eventos de Teclado en toda la pantalla 
        ap_root1.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.ESCAPE)){
                closeDialog();
            }
        });
    }    
    
    /**
     * 
     */
    private void init_label(){
        assert lb_error != null : "fx:id=\"lb_error\" was not injected: check your FXML file 'fxml_Error.fxml'.";        
    }
    /**
     * 
     */
    private void init_im_close(){
        assert im_close != null : "fx:id=\"im_close\" was not injected: check your FXML file 'fxml_Error.fxml'.";                 
        im_close.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    closeDialog();
                }
            }
        });  
    }
    /**
     * 
     */
    private void closeDialog(){
        Gui.getInstance().closeAuxDialog();
    }
    /**
     * @param lb_error the lb_error to set
     */
    public void setLb_error(String lb_error) {
        this.lb_error.setText(lb_error);
    }
}
