/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ARMGARCES
 */
public class Fxml_IndexController implements Initializable {

    @FXML //  fx:id="hbox_toolbar"
    private HBox hbox_toolbar; // Value injected by FXMLLoader

    @FXML //  fx:id="im_config"
    private ImageView im_config; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool1"
    private ImageView im_tool1; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool2"
    private ImageView im_tool2; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool3"
    private ImageView im_tool3; // Value injected by FXMLLoader
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // TODO
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'fxml_Index.fxml'.";
        assert im_config != null : "fx:id=\"im_config\" was not injected: check your FXML file 'fxml_Index.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'fxml_Index.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'fxml_Index.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'fxml_Index.fxml'.";

        init_im_config();
        
    }
    
    /**
     * 
     */
    public void init_im_config(){
        im_config.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //Llamada al Archivo FXML
                    //Screens.getInstance().startUser();
                    //AnchorPane config = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Config.fxml");
                    //Gui.getStage().getScene().;
                    //Despliega la Ventana Emergente
                    //Gui.getInstance().showDialog(config,0);
                }
            }
        });
    }
}
