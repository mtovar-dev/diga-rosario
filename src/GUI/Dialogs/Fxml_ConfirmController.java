/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialogs;

import GUI.Gui;
import GUI.LeftBar.LeftBar;
import GUI.Screens.Screens;
import LN.Ln;
import Tools.Datos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class Fxml_ConfirmController implements Initializable {

    @FXML //  fx:id="ap_root"
    private AnchorPane ap_root; // Value injected by FXMLLoader
    
    @FXML //  fx:id="lb_error"
    private Label lb_mensj; // Value injected by FXMLLoader
    
    @FXML //  fx:id="bt_aceptar"
    private Button bt_aceptar; // Value injected by FXMLLoader

    @FXML //  fx:id="bt_cancelar"
    private Button bt_cancelar; // Value injected by FXMLLoader
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Confirm.fxml'.";
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'fxml_Confirm.fxml'."; 
        // TODO        
        init_bt_aceptar();
        init_bt_cancelar();
        
    }    
    
    /**
     * 
     */
    private void init_bt_aceptar(){
        assert bt_aceptar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'fxml_Confirm.fxml'.";
         
        /**
         * 
         */
        bt_aceptar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    bt_aceptar(Datos.getIdScreen());
                }
            }
        });
        /**
         * 
         */
        bt_aceptar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                bt_aceptar(Datos.getIdScreen());
            }
        });
    }
    
    /**
     * 
     */
    private void init_bt_cancelar(){
        assert bt_cancelar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'fxml_Confirm.fxml'.";
         
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
    public static void closeDialog(){      
        Gui.getInstance().closeAuxDialog();
    }
    /**
     * @author MITM
     * @param idscreen
     */
    private void bt_aceptar(int proceso){
        boolean result;

        switch (proceso){
            case 1000001: // change screen confirmatio                
                LeftBar.openSelection();
                break;

            case 1001000: // screen supplier
                result = Ln.getInstance().change_Supplier(Datos.getSupplier());                                                  
                if(result){
                    Datos.setSupplier(null);
                    Screens.getInstance().startSupplier();
                }
                break;
            case 1002010: // screen orden de compra
                result = Ln.getInstance().change_Orders(Datos.getOrders());                                                  
                if(result){
                    Datos.setNumOrd_comp(null);
                    Screens.getInstance().startOrdersNew();
                }
                break;
            case 2004000: // screen personal
                result = Ln.getInstance().change_log_Personal(Datos.getLog_personal());                                                  
                if(result){
                    Datos.setLog_personal(null);
                    Screens.getInstance().startPersonal();
                }
                break;
            case 2005000: // screen vehiculos
                result = Ln.getInstance().change_log_Vehiculos(Datos.getLog_vehiculos());
                if(result){
                    Datos.setLog_vehiculos(null);
                    Screens.getInstance().startVehicles();
                }
                break;
            case 8001000: // screen insurance
                result = Ln.getInstance().change_log_TSeguros(Datos.getLog_tseguros());                                                  
                if(result){
                    Datos.setMeasure(null);
                    Screens.getInstance().startMeasure();
                }
                break;
            case 8002000: // screen groupsupplier
                result = Ln.getInstance().change_GroupSupplier(Datos.getGroupSupplier());                                                  
                if(result){
                    Datos.setGroupSupplier(null);
                    Screens.getInstance().startGroupSupplier();
                }
                break;
            case 8003000: // screen measure
                result = Ln.getInstance().change_Measure(Datos.getMeasure());                                                  
                if(result){
                    Datos.setMeasure(null);
                    Screens.getInstance().startMeasure();
                }
                break;
            case 8004000: // screen reason
                result = Ln.getInstance().change_Reason(Datos.getReason());                                                  
                if(result){
                    Datos.setMeasure(null);
                    Screens.getInstance().startMeasure();
                }
                break;
            case 8005000: // screen unit
                result = Ln.getInstance().change_Unit(Datos.getUnit());                                                  
                if(result){
                    Datos.setMeasure(null);
                    Screens.getInstance().startMeasure();
                }
                break;
            case 9001000: // screen user
                result = Ln.getInstance().change_UserStatus(Datos.getUsuario());                                                  
                if(result){
                    Datos.setUsuario(null);
                    Screens.getInstance().startUser();
                }
                break;
            case 9003000: // screen role
                result = Ln.getInstance().change_Rol(Datos.getRole());                                                  
                if(result){
                    Datos.setRole(null);
                    Screens.getInstance().startRole();
                }
                break;
            
        }
        Gui.getInstance().closeAuxDialog();                               
   }
    /**
     * @param lb_mensj the lb_error to set
     */
    public void setLb_mensj(String lb_mensj) {
        this.lb_mensj.setText(lb_mensj);
    }    
}
