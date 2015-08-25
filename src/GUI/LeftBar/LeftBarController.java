/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.LeftBar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author ARMGARCES
 */
public class LeftBarController implements Initializable {

//    @FXML //  fx:id="box"
//    private VBox box; // Value injected by FXMLLoader

    @FXML //  fx:id="tv_tree"
    private TreeView<String> tv_tree; // Value injected by FXMLLoader    

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // TODO
//        assert box != null : "fx:id=\"box\" was not injected: check your FXML file 'Fxml_LeftBar.fxml'.";
        assert tv_tree != null : "fx:id=\"tv_tree\" was not injected: check your FXML file 'Fxml_LeftBar.fxml'.";

    }    
}
