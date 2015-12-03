
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialogs;

import GUI.Gui;
import LN.Ln;
import Objects.Inventory.InventoryBlockProd;
import Objects.Orders.Orders;
import Objects.System.Email;
import Tools.Datos;
import Tools.Mail;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author MITM
 */
public class Fxml_EmailSendController implements Initializable{
    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_enviar; 

    @FXML 
    private Button bt_cancelar; 
    
    @FXML
    private RadioButton rb_email1;

    @FXML
    private RadioButton rb_email2;

    @FXML
    private TextArea ta_para;

    @FXML
    private TextArea ta_cc;

    @FXML
    private TextArea ta_mensaje;

    @FXML
    private TextField tf_asunto;

    
    private static final String path_dat = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_dat");

    private static final String path_ima = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_ima");

    private static final String path_rep = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_rep");

    private static final String path_exp = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_exp");

    private static String rows = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("rows");

    private static final String path = System.getProperty("user.dir");
    
    Map<String, Object> JrxmlParam = new HashMap<String, Object>();

    private static JasperReport jReport = null;
    private static JasperViewer jview = null;
    private static JasperPrint jPrint = null;
    
    private static JRBeanCollectionDataSource JRDs = null;
    
    final ToggleGroup rb_group = new ToggleGroup();
    
    private static final ObservableList<Orders> orders = FXCollections.observableArrayList();
    private static final ObservableList<InventoryBlockProd> invenblockprod = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_EmailSendController.fxml'.";

        init_bt_enviar();
        init_bt_cancelar();
        
        switch (Datos.getIdButton()){
            case 1002012: // button orden
                orders.addAll(Arrays.asList(Datos.getRep_orders()));   
                ObservableList<Orders> data = FXCollections.observableArrayList();
                Datos.setRep_orders(Ln.getInstance().find_orders(Datos.getNumOrd_comp()));
                data.addAll(Datos.getRep_orders());   

                ta_para.setText(data.get(0).getCorreo());
                tf_asunto.setText("Orden de Compra (Diga) - " + Datos.getNumOrd_comp());
                if(Datos.getSupplier().getCountry().getAbrev().equals("VE")){
                    switch (Datos.getSesion().getEmail()){
                        case "enarvaez@grupodiga.com":
                            ta_cc.setText(Datos.getSesion().getEmail() + ", efernandes@grupodiga.com");
                            ta_mensaje.setText(
                                "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\">Anexo envi&oacute; una nueva orden de compra para ser despachada en la fecha requerida.</span></p>" +
                                "<p><span style=\"font-size: small;\">Favor confirmar la recepci&oacute;n de este correo</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\"><strong>TSU. Elvimar Narvaez</strong></span></p>" +
                                "<p><span style=\"font-size: x-small;\">Asistente Presidencia</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Cel: +58 414 477.75.11</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                            );
                            break;
                        case "efernandes@grupodiga.com":
                            ta_cc.setText(Datos.getSesion().getEmail() + ", enarvaez@grupodiga.com");
                            ta_mensaje.setText(
                                "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la agenda de recepci&oacute;n de las siguientes &oacute;rdenes de compra para ser recibidas en la fecha requerida.</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\"><strong>LIC. Erika Fernades</strong></span></p>" +
                                "<p><span style=\"font-size: x-small;\">Asistente Presidencia</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Cel: +58 424 380.29.10</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                            );
                            break;
                    }
                }
                else{
                    ta_cc.setText(Datos.getSesion().getEmail() + ", armgarces@gmail.com");
                    ta_mensaje.setText(
                        "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                        "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                        "<p><span style=\"font-size: small;\">Anexo envi&oacute; una nueva orden de compra.</span></p>" +
                        "<p><span style=\"font-size: small;\">Favor confirmar la recepci&oacute;n de este correo</span></p>" +
                        "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                        "<p><span style=\"font-size: small;\"><strong>ING. Dahize Escalante</strong></span></p>" +
                        "<p><span style=\"font-size: x-small;\">Importaciones</span></p>" +
                        "<p><span style=\"font-size: x-small;\">Cel: +58 414 588.89.78</span></p>" +
                        "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                        "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                        "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                    );
                }
                break;
            case 1002013: // button agenda
                orders.addAll(Arrays.asList(Datos.getRep_orders()));   
                ta_para.setText("descargas@grupodiga.com, morita@grupodiga.com, emontero@grupodiga.com, glezama@grupodiga.com");
                tf_asunto.setText("Agenda de Recepcion");
                if(Datos.getSupplier().getCountry().getAbrev().equals("VE")){
                    switch (Datos.getSesion().getEmail()){
                        case "enarvaez@grupodiga.com":
                            ta_cc.setText(Datos.getSesion().getEmail() + ", efernandes@grupodiga.com, fmanzano@grupodiga.com");
                            ta_mensaje.setText(
                                "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la agenda de recepci&oacute;n de las siguientes &oacute;rdenes de compra para ser recibidas en la fecha requerida.</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\"><strong>TSU. Elvimar Narvaez</strong></span></p>" +
                                "<p><span style=\"font-size: x-small;\">Asistente Presidencia</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Cel: +58 414 477.75.11</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                            );
                            break;
                        case "efernandes@grupodiga.com":
                            ta_cc.setText(Datos.getSesion().getEmail() + ", enarvaez@grupodiga.com, fmanzano@grupodiga.com");
                            ta_mensaje.setText(
                                "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la agenda de recepci&oacute;n de las siguientes &oacute;rdenes de compra para ser recibidas en la fecha requerida.</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                                "<p><span style=\"font-size: small;\"><strong>LIC. Erika Fernades</strong></span></p>" +
                                "<p><span style=\"font-size: x-small;\">Asistente Presidencia</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Cel: +58 424 380.29.10</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                                "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                                "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                            );
                            break;
                    }
                }
                else{
                    ta_cc.setText(Datos.getSesion().getEmail() + ", armgarces@gmail.com, fmanzano@grupodiga.com");
                    ta_mensaje.setText(
                        "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                        "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                        "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la agenda de recepci&oacute;n de las siguientes &oacute;rdenes de compra para ser recibidas en la fecha requerida.</span></p>" +
                        "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                        "<p><span style=\"font-size: small;\"><strong>ING. Dahize Escalante</strong></span></p>" +
                        "<p><span style=\"font-size: x-small;\">Importaciones</span></p>" +
                        "<p><span style=\"font-size: x-small;\">Cel: +58 414 588.89.78</span></p>" +
                        "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                        "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                        "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                    );
                }
                break;
            case 2004011: // button bloqueo de productos
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format

                invenblockprod.addAll(Arrays.asList(Datos.getRep_invenblockprod()));   

                switch (Datos.getSesion().getEmail()){
                    case "enarvaez@grupodiga.com":
                        ta_para.setText("fmanzano@grupodiga.com, emontero@grupodiga.com, aortega@grupodiga.com");
                        tf_asunto.setText("Productos Bloqueados por presidencia al - " + sdf.format(invenblockprod.get(0).getFecha()));
                        ta_cc.setText(Datos.getSesion().getEmail() + ", mtorres@grupodiga.com, efernandes@grupodiga.com, glezama@grupodiga.com");
                        ta_mensaje.setText(
                            "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                            "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la Relaci&oacute;n de Productos Bloqueados en el Dpto. de Presidencia a la fecha.</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                            "<p><span style=\"font-size: small;\"><strong>TSU. Elvimar Narvaez</strong></span></p>" +
                            "<p><span style=\"font-size: x-small;\">Asistente Presidencia</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Cel: +58 414 477.75.11</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                        );
                        break;
                    case "efernandes@grupodiga.com":
                        ta_para.setText("fmanzano@grupodiga.com, emontero@grupodiga.com, aortega@grupodiga.com");
                        tf_asunto.setText("Productos Bloqueados por presidencia al - " + sdf.format(invenblockprod.get(0).getFecha()));
                        ta_cc.setText(Datos.getSesion().getEmail() + ", mtorres@grupodiga.com, enarvaez@grupodiga.com, glezama@grupodiga.com");
                        ta_mensaje.setText(
                            "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                            "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la Relaci&oacute;n de Productos Bloqueados en el Dpto. de Presidencia a la fecha.</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                            "<p><span style=\"font-size: small;\"><strong>TSU. Elvimar Narvaez</strong></span></p>" +
                            "<p><span style=\"font-size: x-small;\">Asistente Presidencia</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Cel: +58 424 380.29.10</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Fax: +58 243 269.20.04</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                        );
                        break;
                    case "glezama@grupodiga.com":
                        ta_para.setText("fmanzano@grupodiga.com, emontero@grupodiga.com, aortega@grupodiga.com, armgarces@grupodiga.com");
                        tf_asunto.setText("Productos Bloqueados para Inventario al - " + sdf.format(invenblockprod.get(0).getFecha()));
                        ta_cc.setText(Datos.getSesion().getEmail() + ", cpaez@grupodiga.com, mtorres@grupodiga.com, enarvaez@grupodiga.com");
                        ta_mensaje.setText(
                            "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                            "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la Relaci&oacute;n de Productos Bloqueados en el Dpto. de Inventario;n a la fecha.</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                            "<p><span style=\"font-size: small;\"><strong>Genny Lezama</strong></span></p>" +
                            "<p><span style=\"font-size: x-small;\">Dpto. de Inventario</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Cel: +58 412 143.46.74</span></p>" +
                            "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                            "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                        );
                        break;
                }
                break;
            case 2005021: // button fact anuladas
                ta_para.setText("gerentes@grupodiga.com, supervisoresnacionales@grupodiga.com, supervisoresregionales@grupodiga.com");
                tf_asunto.setText("Relación de Facturas Anuladas");
                ta_cc.setText(Datos.getSesion().getEmail() + ", mzamora@grupodiga.com");
                ta_mensaje.setText(
                    "<p><span style=\"font-size: small;\">Buenas,</span></p>" +
                    "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                    "<p><span style=\"font-size: small;\">A continuaci&oacute;n detallo la Relaci&oacute;n de Facturas Anuladas por Sucursal en el Dpto. de Devoluci&oacute;n a la fecha.</span></p>" +
                    "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" +
                    "<p><span style=\"font-size: small;\"><strong>Oswaldo Serrano</strong></span></p>" +
                    "<p><span style=\"font-size: x-small;\">Dpto. Devolución</span></p>" +
                    "<p><span style=\"font-size: x-small;\">Cel: +58 414 297.51.17</span></p>" +
                    "<p><span style=\"font-size: x-small;\">Ofi: +58 243 217.34.10 al 15</span></p>" +
                    "<p><span style=\"font-size: x-small;\">&nbsp;</span></p>" 
                );
                break;
        }
                
        //Capturador de eventos de Teclado en toda la pantalla         
    }    
    /**
     * 
     */
    private void init_bt_enviar(){
        assert bt_enviar != null : "fx:id=\"bt_enviar\" was not injected: check your FXML file 'Fxml_EmailSendController.fxml'.";
        /**
         * 
         */
        bt_enviar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    try {
                        EmailSend();
                        Gui.getInstance().showMessage("Se ha enviado correctamente!", "I");
                        closeDialog();
                    } catch (JRException ex) {
                        Gui.getInstance().showMessage("No se ha enviado, por favor intente mas tarde!", "E");
                        Logger.getLogger(Fxml_EmailSendController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });         
        /**
         * 
         */
        bt_enviar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                try {
                    EmailSend();
                    Gui.getInstance().showMessage("Se ha enviado correctamente!", "I");
                    closeDialog();
                } catch (JRException ex) {
                    Gui.getInstance().showMessage("No se ha enviado, por favor intente mas tarde!", "E");
                    Logger.getLogger(Fxml_EmailSendController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });         
    }
    /**
     * 
     */
    private void init_bt_cancelar(){
        assert bt_cancelar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'Fxml_EmailSendController.fxml'.";         
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
    private void closeDialog(){
        Gui.getInstance().closeDialog();
    }    
    /**
     * 
     */
    private void EmailSend() throws JRException{
        Email email = new Email();

        switch (Datos.getIdButton()){
            case 1002012: // button orden
                ObservableList<Orders> datao = FXCollections.observableArrayList();
                datao.addAll(Datos.getRep_orders());   
                JRDs = new JRBeanCollectionDataSource(datao, true);

                JrxmlParam.put("p_user", Datos.getSesion().getUsername());
                JrxmlParam.put("p_orden", "ORDEN DE COMPRA:  " + datao.get(0).getIdOrden());
                
                if(Datos.getSupplier().getCountry().getAbrev().equals("VE")){
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_ord_nac.jasper");
                }
                else{
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_ord_imp.jasper");
                }
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);

                JasperExportManager.exportReportToPdfFile(jPrint, path + path_exp + "/orden_compra-" + Datos.getNumOrd_comp() + ".pdf");

                email.setPathFile(path + path_exp + "/orden_compra-" + Datos.getNumOrd_comp() + ".pdf");
                email.setAttachFile(path + path_exp + "/orden_compra-" + Datos.getNumOrd_comp() + ".pdf");
                break;
            case 1002013: // button agenda
                ObservableList<Orders> dataa = FXCollections.observableArrayList();
                dataa.addAll(Datos.getRep_orders());   
                JRDs = new JRBeanCollectionDataSource(dataa, true);

                JrxmlParam.put("p_user", Datos.getSesion().getUsername());
                JrxmlParam.put("p_orden", "Agenda de Recepción ");

                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/compras/ord_com_port_res.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);

                JasperExportManager.exportReportToPdfFile(jPrint, path + path_exp + "/agenda_recep.pdf");

                email.setPathFile(path + path_exp + "/agenda_recep.pdf");
                email.setAttachFile(path + path_exp + "/agenda_recep.pdf");
                break;
            case 2004011: // button bloqueo de productos
                email.setPathFile(path + path_exp + "/bloq_productos-" + Datos.getNumOrd_toma() + ".pdf");
                email.setAttachFile(path + path_exp + "/bloq_productos-" + Datos.getNumOrd_toma() + ".pdf");
                break;
            case 2005021: // button fact anuladas
                email.setPathFile(path + path_exp + "/fact_anuladas.pdf");
                email.setAttachFile(path + path_exp + "/fact_anuladas.pdf");
                break;
        }

        email.setUsr_email(Datos.getSesion().getEmail());
        email.setUsr_to(ta_para.getText().trim());
        email.setUsr_cc(ta_cc.getText().trim());
        email.setSubject(tf_asunto.getText().trim());
        email.setMessage(ta_mensaje.getText());

        Mail.SendMail(email);
    }
}
