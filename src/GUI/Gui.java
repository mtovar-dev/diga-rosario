/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.LeftBar.LeftBar;
import Tools.Datos;
import Tools.Tools;
import java.io.IOException;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ARMGARCES
 */
public class Gui {
    private static Stage stage;
    private static Stage primaryStage;
    private static Stage dialog;
    private static Stage auxDialog;
    
    private static AnchorPane ap_topbar;
    private static AnchorPane ap_leftbar;
    private static AnchorPane ap_center;
    
    private static ImageView im_login;
    private static ImageView im_logout;
        
    private static LeftBar leftBar;
    
    //Campos para el manejo de los Eventos de Foco
    private static int fieldsType;
    private static int fieldFocused;
    private static int fieldsSize;
    private static Node[] fields;

    //Para el Cambio de Pantalla
    private static int tipoOperacion = 0;
    private static String IdBusqueda;

    /**
     * 
     */
    private Gui() {
        leftBar = new LeftBar();
    }
    
    /**
     * 
     * @param url Ubicacion del archivo a ser Cargado
     * @return la interfaz grafica a mostrarse
     */
    public AnchorPane loadFxml(String url){
        try {
            URL tb_url = Gui.class.getResource(url);     
            return (AnchorPane)FXMLLoader.load(tb_url);
        }catch(IOException ioe){
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            Tools.getErrorMessage(stacktrace,"Error archivo "+url+" no encontrado = " + ioe);                        
        } 
        return null;
    }
    /**
     * 
     * @param param 
     * @param type 
     * Archivo Fxml que representa la interfaz grafica a mostrarse
     */
    public void showDialog(AnchorPane param,int type){
        
        Scene scene = new Scene(param, param.getPrefWidth(),param.getPrefHeight());        
        scene.setFill(Color.TRANSPARENT);
        
        Stage vent = new Stage();
        //Stage dialog1 = null;
        //Stage aux = null;
                
        vent.initStyle(StageStyle.UNDECORATED);
        vent.initModality(Modality.APPLICATION_MODAL);
        vent.setResizable(false);
        vent.setScene(scene);
        
        switch(type){
            case 0:
                Stage dialog1 = Gui.getInstance().getDialog();
                if(dialog1 != null){
                    dialog1.close();
                }
                Gui.getInstance().setDialog(vent);
                break;
            case 1:
                Stage aux = Gui.getInstance().getAuxDialog();
                if(aux != null){
                    aux.close();
                }                
                Gui.getInstance().setAuxDialog(vent);
                
                Gui.getInstance().getAuxDialog().addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {       
                    @Override
                    public void handle(KeyEvent ke) {               
                       if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.ESCAPE)){
                           closeAuxDialog();
                       }
                    }
                });
                break;
        }
        vent.show();
    }
    /**
     * 
     * @param mensj 
     */
    public void showBusqueda(String mensj) {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Search.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(conf,"#lb_mensj");
        Label lb_msg = (Label) node;
        lb_msg.setText(mensj);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,0); 
    }
    /**
     * 
     * @param mensj 
     */
    public void showConfirmar(String mensj) {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Confirm.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(conf,"#lb_mensj");
        Label lb_msg = (Label) node;
        lb_msg.setText(mensj);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,1); 
    }
    /**
     * 
     * @param mensj 
     */
    public void showPrint(String mensj) {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Print.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(conf,"#lb_mensj");
        Label lb_msg = (Label) node;
        lb_msg.setText(mensj);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,0); 
    }
    /**
     * 
     * @param mensj 
     */
    public void showEmail(String mensj) {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Email.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(conf,"#lb_mensj");
        Label lb_msg = (Label) node;
        lb_msg.setText(mensj);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,0); 
    }
    /**
     * 
     */
    public void showEmailSend() {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_EmailSend.fxml");
        
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,0); 
    }
    /**
     * 
     * @param mensj 
     */
    public void showVisor(String mensj) {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Visor.fxml");
        
        //Cambio de Mensaje del Label
        //Node node = Tools.getNode(conf,"#lb_mensj");
        //Label lb_msg = (Label) node;
        //lb_msg.setText(mensj);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,1); 
    }
    /**
     * 
     * @param mensj 
     */
    public void showPassUpd(String mensj) {
        //Llamada al Archivo FXML
        AnchorPane conf = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_PassUpd.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(conf,"#lb_mensj");
        Label lb_msg = (Label) node;
        lb_msg.setText(mensj);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(conf,0); 
    }
    /**
     * 
     * @param msg
     * @param icon
     */
    public void showMessage(String msg, String icon) {                                  
        //Llamada al Archivo FXML
        AnchorPane error = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Error.fxml");
        
        //Cambio de Mensaje del Label
        Node nodem = Tools.getNode(error,"#lb_error");
        Label lb_msg = (Label) nodem;
        lb_msg.setText(msg);

        //Cambio de Mensaje del Label
        Node nodei = Tools.getNode(error,"#im_icon");
        ImageView im_icon = (ImageView) nodei;

        switch(icon){
            case "I":
                im_icon.setImage(new Image(getClass().getResourceAsStream("/Images/img14.png")));
                break;
            case "A":
                im_icon.setImage(new Image(getClass().getResourceAsStream("/Images/img15.png")));
                break;
            case "E":
                im_icon.setImage(new Image(getClass().getResourceAsStream("/Images/img16.png")));
                break;
        }

        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(error,1);           
    }
    /**
     * 
     * @param msg
     */
    public void ventanaMensaje(String msg) {                                  
        //Llamada al Archivo FXML
        AnchorPane error = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Error.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(error,"#lb_error");
        Label lb_msg = (Label) node;
        lb_msg.setText(msg);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(error,1);           
    }
    /**
     * 
     * @param msg
     */
    public void ventanaError(String msg) {                                  
        //Llamada al Archivo FXML
        AnchorPane error = Gui.getInstance().loadFxml("/GUI/Dialogs/Fxml_Error.fxml");
        
        //Cambio de Mensaje del Label
        Node node = Tools.getNode(error,"#lb_error");
        Label lb_msg = (Label) node;
        lb_msg.setText(msg);
        //Creacion de Ventana Emergente
        Gui.getInstance().showDialog(error,1);         
    }
    
    /********************************* GET AND SETTERS **************************/
    public static void sumFieldFocused(){
        fieldFocused++;
    }
    /**
     * 
     * @return 
     */
    public static int getFieldFocused(){
        return fieldFocused;
    }
    /**
     * 
     * @param value 
     */
    public static void setFieldFocused(int value){
        fieldFocused = value;
    }

    /**
     * @return the fieldsSize
     */
    public static int getFieldsSize() {
        return fieldsSize;
    }

    /**
     * @param aFieldsSize the fieldsSize to set
     */
    public static void setFieldsSize(int aFieldsSize) {
        fieldsSize = aFieldsSize;
    }

    /**
     * @return the fieldsType
     */
    public static int getFieldsType() {
        return fieldsType;
    }

    /**
     * @param aFieldsType the fieldsType to set
     */
    public static void setFieldsType(int aFieldsType) {
        fieldsType = aFieldsType;
    }

    /**
     * @return the fields
     */
    public static Node[] getFields() {
        return fields;
    }

    /**
     * @param aFields the fields to set
     */
    public static void setFields(Node[] aFields) {
        fields = aFields;
    }
    /**
     * @return the leftBar
     */
    public static LeftBar getLeftBar() {
        return leftBar;
    }

    /**
     * @param aNd the leftBar to set
     */
    public static void setLeftBar(LeftBar aNd) {
        leftBar = aNd;
    }
    
    /**
     * @return the ap_topbar
     */
    public static AnchorPane getAp_topbar() {
        return ap_topbar;
    }

    /**
     * @param aTopbar the ap_topbar to set
     */
    public static void setAp_topbar(AnchorPane aTopbar) {
        ap_topbar = aTopbar;
    }

    /**
     * @return the ap_leftbar
     */
    public static AnchorPane getAp_leftbar() {
        return ap_leftbar;
    }

    /**
     * @param aLeftbar the ap_leftbar to set
     */
    public static void setAp_leftbar(AnchorPane aLeftbar) {
        ap_leftbar = aLeftbar;
    }
    /**
     * @return the ap_center
     */
    public static AnchorPane getAp_center() {
        return ap_center;
    }
    /**
     * @param aCenter the ap_center to set
     */
    public static void setAp_center(AnchorPane aCenter) {
        ap_center = aCenter;
    }
    /**
     * @return the tipoOperacion
     */
    public int getTipoOperacion() {
        return tipoOperacion;
    }
    /**
     * @param aTipoOperacion the tipoOperacion to set
     */
    public void setTipoOperacion(int aTipoOperacion) {
        tipoOperacion = aTipoOperacion;
    }
    /**
     * @return the IdBusqueda
     */
    public static String getIdBusqueda() {
        return IdBusqueda;
    }
    /**
     * @param aIdBusqueda the IdBusqueda to set
     */
    public static void setIdBusqueda(String aIdBusqueda) {
        IdBusqueda = aIdBusqueda;
    }
  
    /***************************************************************************/
    /**
     * Funcion que permite Minimizar la Ventana
     */
    public void Minimize(){
        stage.setIconified(true);
    }
    
    /**
     * 
     */
    public void closeDialog(){        
        getDialog().close();
    }
    
    /**
     * 
     */
    public void closeAuxDialog(){        
        getAuxDialog().close();
    }
    
    /***************************************************************************/
    
    

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param aStage the stage to set
     */
    public void setStage(Stage aStage) {
        stage = aStage;
    }

    /**
     * @return the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param aPrimaryStage the primaryStage to set
     */
    public void setPrimaryStage(Stage aPrimaryStage) {
        primaryStage = aPrimaryStage;
    }

    /**
     * @return the dialog
     */
    public Stage getDialog() {
        return dialog;
    }

    /**
     * @param aDialog the dialog to set
     */
    private void setDialog(Stage aDialog) {
        dialog = aDialog;
    }
    
    /**
     * @param aDialog the dialog to set
     * @param type
     */
    public void setDialog(Stage aDialog,int type) {        
        switch(type){
            case 0:
                setDialog(aDialog);
                break;
            case 1:
                setAuxDialog(aDialog);
                break;
        }
    }

    /**
     * @return the auxDialog
     */
    public Stage getAuxDialog() {
        return auxDialog;
    }

    /**
     * @param aAuxDialog the auxDialog to set
     */
    private void setAuxDialog(Stage aAuxDialog) {
        auxDialog = aAuxDialog;
    }

    /**
     * @return the im_login
     */
    public ImageView getIm_login() {
        return im_login;
    }

    /**
     * @param aIm_login the im_login to set
     */
    public void setIm_login(ImageView aIm_login) {
        im_login = aIm_login;
    }

    /**
     * @return the im_logout
     */
    public ImageView getIm_logout() {
        return im_logout;
    }

    /**
     * @param aIm_logout the im_logout to set
     */
    public void setIm_logout(ImageView aIm_logout) {
        im_logout = aIm_logout;
    }

    
    
    /***************************************************************************/
    
    private static class GuiHolder {

        private static final Gui INSTANCE = new Gui();
    }
    
    public static Gui getInstance() {
        return GuiHolder.INSTANCE;
    }

    /**
     * 
     */
    public static void refreshIdBusqueda(){
        Node node = null;
        switch (Datos.getIdButton()){
            case 1002011: // button orden de compra
                node = Tools.getNode(Gui.getAp_center(), "#tf_orden");
                break;
            case 1002012: // button proveedores
                node = Tools.getNode(Gui.getAp_center(), "#tf_rif");
                break;
            case 2003031: // button chofer
                node = Tools.getNode(Gui.getAp_center(), "#tf_chofer");
                break;
            case 2003032: // screen vehiculo 1
                node = Tools.getNode(Gui.getAp_center(), "#tf_veh1");
                break;
            case 2003033: // screen vehiculo 2
                node = Tools.getNode(Gui.getAp_center(), "#tf_veh2");
                break;
            case 2003034: // screen vehiculo 1
                node = Tools.getNode(Gui.getAp_center(), "#tf_ayud1");
                break;
            case 2003035: // screen vehiculo 2
                node = Tools.getNode(Gui.getAp_center(), "#tf_ayud2");
                break;
            case 2003036: // screen cheq puerta
                node = Tools.getNode(Gui.getAp_center(), "#tf_cheqp");
                break;
            case 2003037: // screen Guia de Carga
                break;
            case 2003038: // screen cheq puerta
                node = Tools.getNode(Gui.getAp_center(), "#tf_cheqpdv");
                break;
            case 2003039: // screen cheq puerta
                node = Tools.getNode(Gui.getAp_center(), "#tf_proddv");
                break;
            case 2003040: // screen clientes
                node = Tools.getNode(Gui.getAp_center(), "#tf_factdv");
                break;
            case 2003041: // screen clientes
                node = Tools.getNode(Gui.getAp_center(), "#tf_nroguia");
                break;
            case 2003042: // screen sup. de ruta
                node = Tools.getNode(Gui.getAp_center(), "#tf_supruta");
                break;
            case 2004011: // screen Aseguradora
                node = Tools.getNode(Gui.getAp_center(), "#tf_toma");
                break;
            case 2005011: // screen Aseguradora
                node = Tools.getNode(Gui.getAp_center(), "#tf_seguro");
                break;
            case 7001021: // screen Aud. x empleado
                node = Tools.getNode(Gui.getAp_center(), "#tf_nroci");
                break;
        }
                
        if (node instanceof TextField ){
            TextField tf = (TextField) node;
            switch (Datos.getIdButton()){
                case 2003040: // screen clientes
                    tf.setText("C" + IdBusqueda);
                    break;
                default:
                    tf.setText(IdBusqueda);
            }
            tf.requestFocus();
        }
    }
}
