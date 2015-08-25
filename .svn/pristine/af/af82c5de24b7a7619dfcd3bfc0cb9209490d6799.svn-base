/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Dialogs;

import GUI.Gui;
import Tools.Datos;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author MITM
 */
public class Fxml_VisorController implements Initializable {
    
    @FXML
    private AnchorPane ap_root;

    @FXML
    private ImageView im_close;

    @FXML
    private ImageView im_view;

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_VisorController.fxml'.";

        init_im_view();
        init_im_close();
    }

    /**
     * 
     */
    private void init_im_view(){
        assert im_view != null : "fx:id=\"im_view\" was not injected: check your FXML file 'Fxml_VisorController.fxml'."; 

        File file = new File(Datos.getPath_im_view());
        im_view.setImage(new Image(file.toURI().toString()));
    }
    /**
     * 
     */
    private void init_im_close(){
        assert im_close != null : "fx:id=\"im_close\" was not injected: check your FXML file 'fxml_LogIn.fxml'.";                 
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
}
