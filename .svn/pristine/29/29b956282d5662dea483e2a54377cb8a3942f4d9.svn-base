/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author MITM
 */
public class Fxml_MaterialController implements Initializable {

    @FXML //  fx:id="ap_root"
    private AnchorPane ap_root; // Value injected by FXMLLoader

    @FXML //  fx:id="cb_pais"
    private ComboBox<?> cb_pais; // Value injected by FXMLLoader

    @FXML //  fx:id="ch_IvaAgent"
    private CheckBox ch_IvaAgent; // Value injected by FXMLLoader

    @FXML //  fx:id="ch_t100"
    private CheckBox ch_t100; // Value injected by FXMLLoader

    @FXML //  fx:id="ch_t75"
    private CheckBox ch_t75; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_2"
    private HBox hb_2; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_3"
    private HBox hb_3; // Value injected by FXMLLoader

    @FXML //  fx:id="hbox_toolbar"
    private HBox hbox_toolbar; // Value injected by FXMLLoader

    @FXML //  fx:id="im_check"
    private ImageView im_check; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool1"
    private ImageView im_tool1; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool10"
    private ImageView im_tool10; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool11"
    private ImageView im_tool11; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool12"
    private ImageView im_tool12; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool2"
    private ImageView im_tool2; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool3"
    private ImageView im_tool3; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool4"
    private ImageView im_tool4; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool5"
    private ImageView im_tool5; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool6"
    private ImageView im_tool6; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool7"
    private ImageView im_tool7; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool8"
    private ImageView im_tool8; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool9"
    private ImageView im_tool9; // Value injected by FXMLLoader

    @FXML //  fx:id="lb_Title"
    private Label lb_Title; // Value injected by FXMLLoader

    @FXML //  fx:id="lb_ocultar"
    private Label lb_ocultar; // Value injected by FXMLLoader

    @FXML //  fx:id="tb_table"
    private TableView<?> tb_table; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_buscar"
    private TextField tf_buscar; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_celular"
    private TextField tf_celular; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_contacto"
    private TextField tf_contacto; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_correo"
    private TextField tf_correo; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_fax"
    private TextField tf_fax; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_nombre"
    private TextField tf_nombre; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_referencia"
    private TextField tf_referencia; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_rif"
    private TextField tf_rif; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_telefonos"
    private TextField tf_telefonos; // Value injected by FXMLLoader

    @FXML //  fx:id="vb_form"
    private VBox vb_form; // Value injected by FXMLLoader    

    private static int tipoOperacion;    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert cb_pais != null : "fx:id=\"cb_pais\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert ch_IvaAgent != null : "fx:id=\"ch_IvaAgent\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert ch_t100 != null : "fx:id=\"ch_t100\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert ch_t75 != null : "fx:id=\"ch_t75\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert hb_2 != null : "fx:id=\"hb_2\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert hb_3 != null : "fx:id=\"hb_3\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert lb_ocultar != null : "fx:id=\"lb_ocultar\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_celular != null : "fx:id=\"tf_celular\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_contacto != null : "fx:id=\"tf_contacto\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_correo != null : "fx:id=\"tf_correo\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_fax != null : "fx:id=\"tf_fax\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_nombre != null : "fx:id=\"tf_nombre\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_referencia != null : "fx:id=\"tf_referencia\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_rif != null : "fx:id=\"tf_rif\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert tf_telefonos != null : "fx:id=\"tf_telefonos\" was not injected: check your FXML file 'Fxml_Material.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Material.fxml'.";

        //
        tf_buscar.setVisible(false);
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){     
                    //
//                    loadTable( Ln.getInstance().findUser(tf_buscar.getText()));
                    tf_buscar.setVisible(false);
                }
            }
        };
        
        tf_buscar.setOnKeyPressed(eh);
        tipoOperacion = 0;  

    }

}
