/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Dialogs;

import GUI.Gui;
import LN.Ln;
import Listeners.SelectKeyComboBoxListener;
import Objects.Setup.City;
import Objects.System.ItemPrintScreen;
import Objects.Setup.State;
import Objects.log_CGuias;
import Objects.log_CGuias_falt_dv;
import Objects.log_Personal;
import Objects.log_TPersonal;
import Tools.Datos;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import net.sf.jasperreports.engine.JRException;
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
public class Fxml_PrintController implements Initializable {

    @FXML 
    private AnchorPane ap_root; 
    
    @FXML 
    private Button bt_aceptar; 

    @FXML 
    private Button bt_cancelar; 
    
    @FXML
    private ComboBox<Object> cb_imp11;
    
    @FXML
    private ComboBox<Object> cb_imp21;
    
    @FXML
    private ComboBox<Object> cb_imp22;
    
    @FXML
    private ComboBox<Object> cb_imp31;
    
    @FXML
    private DatePicker dp_fecha;
    
    @FXML
    private Hyperlink hp_imp11;
    
    @FXML
    private Hyperlink hp_imp12;
    
    @FXML
    private Hyperlink hp_imp13;
    
    @FXML
    private Hyperlink hp_imp14;
    
    @FXML
    private Hyperlink hp_imp15;
    
    @FXML
    private Hyperlink hp_imp16;
    
    @FXML
    private Hyperlink hp_imp21;
    
    @FXML
    private Hyperlink hp_imp22;
    
    @FXML
    private Hyperlink hp_imp23;
    
    @FXML
    private Hyperlink hp_imp24;
    
    @FXML
    private Hyperlink hp_imp31;
    
    @FXML
    private Hyperlink hp_imp32;
    
    @FXML
    private Hyperlink hp_imp33;
    
    @FXML
    private Hyperlink hp_imp34;
    
    @FXML
    private ImageView im_imp;

    @FXML
    private Label lb_imp11;

    @FXML
    private Label lb_imp21;

    @FXML
    private Label lb_imp22;

    @FXML
    private Label lb_imp31;

    @FXML
    private Label lb_b;

    @FXML 
    private Label lb_mensj; 

    @FXML
    private RadioButton rb_imp11;
    
    @FXML
    private RadioButton rb_imp12;
    
    @FXML
    private RadioButton rb_imp13;
    
    @FXML
    private TextField tf_buscar;

    @FXML
    private VBox vb_1;
    
    @FXML
    private VBox vb_2;
    
    @FXML
    private VBox vb_3;
    
    @FXML
    private VBox vb_b;
    

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
    
    private static SimpleDateFormat sdf_dd = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format

    final ToggleGroup rb_group = new ToggleGroup();

    private static int numHyperlink       = 0; 

    boolean keybackspace = false;
    boolean print = false;

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
        assert im_imp != null : "fx:id=\"im_imp\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
        assert vb_1 != null : "fx:id=\"vb_1\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
        assert vb_2 != null : "fx:id=\"vb_2\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
        assert vb_3 != null : "fx:id=\"vb_3\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
        assert vb_b != null : "fx:id=\"vb_b\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
        
        vb_1.setVisible(false);
        vb_2.setVisible(false);
        vb_3.setVisible(false);
        vb_b.setVisible(false);
        
        // TODO        
        init_bt_aceptar();
        init_bt_cancelar();
        init_buttons(); //Establece los comportamientos de los botones
        init_screen_loads(Datos.getIdScreen());
    }

    /**
     * 
     */
    private void init_bt_aceptar(){
        assert bt_aceptar != null : "fx:id=\"bt_aceptar\" was not injected: check your FXML file 'Fxml_Print.fxml'.";

        /**
         * 
         */
        bt_aceptar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    imprimir(Datos.getIdScreen());
                }
            }
        });
        /**
         * 
         */
        bt_aceptar.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                Datos.setRep_log_personal(Ln.getInstance().find_log_Personal(tf_buscar.getText()));
                imprimir(Datos.getIdScreen());
            }
        });
    }
    
    /**
     * 
     */
    private void init_bt_cancelar(){
        assert bt_cancelar != null : "fx:id=\"bt_cancelar\" was not injected: check your FXML file 'Fxml_Print.fxml'.";
         
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
        Datos.setRep_log_personal(Ln.getInstance().load_log_Personal());
        Gui.getInstance().closeDialog();
    }

    /**
     * @param lb_mensj the lb_error to set
     */
    public void setLb_mensj(String lb_mensj) {
        this.lb_mensj.setText(lb_mensj);
    }    

    /**
     * @author MITM
     * @param idscreen
     */
    private void imprimir(int IdScreen){
        boolean result;
        //sdf = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format

        switch (IdScreen){
            case 1001001: // screen supplier
                break;
            case 2003020: // screen guide
                //Datos
                List<log_CGuias> datag = Ln.getList_log_CGuias(Datos.getRep_log_cguias());

                ObservableList<log_CGuias_falt_dv> data_fdev = FXCollections.observableArrayList();
                data_fdev.addAll(Arrays.asList(Ln.getInstance().print_log_CGuias_fdev(Datos.getNumRela(), numHyperlink)));   

//                if (numHyperlink == 9){
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//                    data_fdev.addAll(Arrays.asList(Ln.getInstance().print_log_CGuias_fdev(dp_fecha.getValue().format(formatter), numHyperlink)));   
//                }
//                else{
//                    data_fdev.addAll(Arrays.asList(Ln.getInstance().print_log_CGuias_fdev(Datos.getNumRela(), numHyperlink)));   
//                }

                JRDs = new JRBeanCollectionDataSource(data_fdev, true);

                print = false;
                if (data_fdev.size() > 0){
                    print = true;
                    //Parametros
                    JrxmlParam.put("p_user", Datos.getSesion().getUsername());

                    JrxmlParam.put("p_zona", 
                        data_fdev.get(0).getSucursal() + " - " + data_fdev.get(0).getCiudad());

                    JrxmlParam.put("p_chofer", 
                        data_fdev.get(0).getSchofer());

                    JrxmlParam.put("p_rifemp", 
                        data_fdev.get(0).getRif_emp());

                    JrxmlParam.put("p_transporte", 
                        data_fdev.get(0).getNombre_emp());

                    JrxmlParam.put("p_nrodev", 
                        datag.get(0).getNumrela());

                    JrxmlParam.put("p_fecsalida", 
                        datag.get(0).getFecsalida());
                    
//                    if (numHyperlink == 9){
//                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                        JrxmlParam.put("p_fecrecupera", 
//                            "de fecha: " + dp_fecha.getValue().format(formatter));
//                    }
                }

                break;
            case 2004010: // screen personal
                if((tf_buscar.getText() != null && !tf_buscar.equals("")) &&
                        (cb_imp11.getValue() == null ) && 
                        (cb_imp21.getValue() == null ) && 
                        (cb_imp31.getValue() == null ))
                {
                    Datos.setRep_log_personal(Ln.getInstance().find_log_Personal(tf_buscar.getText()));
                    JrxmlParam.put("p_subtitulo", "Buscar texto (Cédula o Nombres o Apellidos): " + tf_buscar.getText());
                }
                else if((tf_buscar.getText() == null) &&
                        (cb_imp11.getValue() == null) && 
                        (cb_imp21.getValue() == null) && 
                        (cb_imp31.getValue() == null))
                {
                    Datos.setRep_log_personal(Ln.getInstance().load_log_Personal());
                    JrxmlParam.put("p_subtitulo", "todo el personal");
                }
                else if((tf_buscar.getText() == null) &&
                        (cb_imp11.getValue() != null) && 
                        (cb_imp21.getValue() == null) && 
                        (cb_imp31.getValue() == null))
                {
                    String doc = null;
                    switch(cb_imp11.getSelectionModel().getSelectedItem().toString()){
                        case "Cert. de Salud":
                            doc = "cs";
                            break;
                        case "Cert. Medico":
                            doc = "cm";
                            break;
                        case "Lic. de Conducir":
                            doc = "lc";
                            break;
                        case "Man. de Alimento":
                            doc = "ma";
                            break;
                    }
                    Datos.setRep_log_personal(Ln.getInstance().print_log_Personal(doc, rb_group.getSelectedToggle().getUserData().toString()));
                    switch(rb_group.getSelectedToggle().getUserData().toString()){
                        case "xv":
                            JrxmlParam.put("p_subtitulo", cb_imp11.getSelectionModel().getSelectedItem().toString() + " - por vencer");
                            rb_imp11.setSelected(false);
                            break;
                        case "ve":
                            JrxmlParam.put("p_subtitulo", cb_imp11.getSelectionModel().getSelectedItem().toString() + " - vencido");
                            rb_imp12.setSelected(false);
                            break;
                        case "pe":
                            JrxmlParam.put("p_subtitulo", cb_imp11.getSelectionModel().getSelectedItem().toString() + " - pendiente");
                            rb_imp13.setSelected(false);
                            break;
                    }
                } 
                else if((tf_buscar.getText() == null) &&
                        (cb_imp11.getValue() == null) && 
                        (cb_imp21.getValue() != null) && 
                        (cb_imp31.getValue() == null))
                {
                    keybackspace = true;
                    JrxmlParam.put("p_subtitulo", "ubicación - " + cb_imp22.getValue());
                    switch(cb_imp21.getSelectionModel().getSelectedItem().toString()){
                        case "Ciudad":
                            City city = (City) cb_imp22.getValue();
                            Datos.setRep_log_personal(Ln.getInstance().print_log_Personal("ci", Integer.toString(city.getIdPoblacion())));
                            break;
                        case "Estado":
                            State state = (State) cb_imp22.getValue();            
                            Datos.setRep_log_personal(Ln.getInstance().print_log_Personal("es", Integer.toString(state.getIdPoblacion()) ));
                            break;
                    }
                    
                }
                else if((tf_buscar.getText() == null) &&
                        (cb_imp11.getValue() == null) && 
                        (cb_imp21.getValue() == null) && 
                        (cb_imp31.getValue() != null))
                {
                    keybackspace = true;
                    JrxmlParam.put("p_subtitulo", "Tipo de Personal ");
                    log_TPersonal log_tpersonal = (log_TPersonal) cb_imp31.getValue();            
                    Datos.setRep_log_personal(Ln.getInstance().print_log_Personal("tp", Integer.toString(log_tpersonal.getIdTPersonal())));
                }

                //Datos
                List<log_Personal> datap = Ln.getList_log_Personal(Datos.getRep_log_personal());
                JRBeanCollectionDataSource JRDs = new JRBeanCollectionDataSource(datap, true);

                //Parametros
                JrxmlParam.put("p_user", Datos.getSesion().getUsername());

                try{
                    jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_per_port_pers.jasper");
                    jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                    jview = new JasperViewer(jPrint, false);
                    jview.setTitle("DIGA - Listado de Personal (Logistica) ");

                } catch (JRException ee){
                    Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
                }

                //jview.setIconImage(...);
                jview.setVisible(true);
                jview.setResizable(false);
                
                tf_buscar.setText(null);
                cb_imp11.getSelectionModel().clearSelection();
                cb_imp21.getSelectionModel().clearSelection();
                cb_imp22.getSelectionModel().clearSelection();
                cb_imp31.getSelectionModel().clearSelection();
                break;
            case 2004020: // screen vehiculos
                break;
            case 8000030: // screen groupsupplier
                break;
            case 8000040: // screen measure
                break;
            case 9000100: // screen user
                break;
        }
        //Gui.getInstance().closeAuxDialog();                               
    }

    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){
        /**
         * 
         */
        cb_imp11.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                cb_imp11.getSelectionModel().clearSelection();  
            }
        });
        /**
         * 
         */
        cb_imp21.setOnMousePressed((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    keybackspace = false;
                }
            }
        });
        /**
         * 
         */
        cb_imp21.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                keybackspace = true;
                cb_imp21.getSelectionModel().clearSelection();  
                cb_imp22.setItems(null);
            }
        });
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_imp21.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Object> ov, Object t, Object t1) -> {
            if(keybackspace == false){
                switch(t1.toString()){
                    case "Ciudad":
                        loadCity();
                        break;
                    case "Estado":
                        loadState();
                        break;
                }
            }
        });
        /**
         * 
         */
        cb_imp31.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.BACK_SPACE)){
                cb_imp31.getSelectionModel().clearSelection();  
            }
        });
        /**
         * Dev. Parcial
         */
        hp_imp11.setOnAction((ActionEvent e) -> {
            numHyperlink = 1;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_fact_dp.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Devolución Parcial (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Notas de Cambio
         */
        hp_imp12.setOnAction((ActionEvent e) -> {
            numHyperlink = 2;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_fact_nd.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Notas de Cambio (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Facturas Anular
         */
        hp_imp13.setOnAction((ActionEvent e) -> {
            numHyperlink = 3;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_fact_an.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Facturas Anular (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Cambio de Factura
         */
        hp_imp14.setOnAction((ActionEvent e) -> {
            numHyperlink = 4;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_fact_cf.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Cambio de Factura (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Falt. y/o Sobr.
         */
        hp_imp15.setOnAction((ActionEvent e) -> {
            numHyperlink = 8;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_inv_fs.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Falt. y/o Sobr. (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Red. Camión
         */
        hp_imp21.setOnAction((ActionEvent e) -> {
            numHyperlink = 5;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_rede_ca.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Redespacho Camión (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Red. Rosario
         */
        hp_imp22.setOnAction((ActionEvent e) -> {
            numHyperlink = 6;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_rede_ro.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Redespacho Rosario (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Trans. Camión
         */
        hp_imp23.setOnAction((ActionEvent e) -> {
            numHyperlink = 10;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_tran_ca.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Transbordo Camión (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Des. Rosario
         */
        hp_imp24.setOnAction((ActionEvent e) -> {
//            numHyperlink = 7;
//            imprimir(Datos.getIdScreen());
//
//            try{ 
//                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_inv_dm.jasper");
//                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
//                jview = new JasperViewer(jPrint, false);
//                jview.setTitle("DIGA - Listado de Desgloce de Productos (Devolución) ");
//
//            } catch (JRException ee){
//                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
//            }
//
//            if (print){
//                jview.setVisible(true);
//                jview.setResizable(false);
//            }
        });        
        /**
         * Ent. de Mercancia
         */
        hp_imp31.setOnAction((ActionEvent e) -> {
            numHyperlink = 7;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_inv_em.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Entrada de Productos (Devolución) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Sal. de Mercancia Recuperacion
         */
        hp_imp32.setOnAction((ActionEvent e) -> {
            numHyperlink = 9;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_inv_re.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Salida de Productos (Recuperación) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Sal. de Mercancia Vencida
         */
        hp_imp33.setOnAction((ActionEvent e) -> {
            numHyperlink = 11;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_inv_ve.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Salida de Productos (Vencido) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
        /**
         * Sal. de Mercancia Irrecuperable
         */
        hp_imp34.setOnAction((ActionEvent e) -> {
            numHyperlink = 12;
            imprimir(Datos.getIdScreen());

            try{ 
                jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_inv_ir.jasper");
                jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
                jview = new JasperViewer(jPrint, false);
                jview.setTitle("DIGA - Listado de Recuperación de Productos (Irrecuperable) ");

            } catch (JRException ee){
                Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
            }

            if (print){
                jview.setVisible(true);
                jview.setResizable(false);
            }
        });        
    }
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     * @param IdScreen
     */
    private void init_screen_loads(int IdScreen){
        boolean result;

        switch (IdScreen){
            case 1001001: // screen supplier
                break;
            case 2003020: // screen guide
                assert cb_imp11 != null : "fx:id=\"cb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert lb_imp11 != null : "fx:id=\"lb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert rb_imp11 != null : "fx:id=\"rb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert rb_imp12 != null : "fx:id=\"rb_imp12\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert rb_imp13 != null : "fx:id=\"rb_imp13\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp11 != null : "fx:id=\"rb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp12 != null : "fx:id=\"rb_imp12\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp13 != null : "fx:id=\"rb_imp13\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp14 != null : "fx:id=\"rb_imp14\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp15 != null : "fx:id=\"rb_imp15\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp16 != null : "fx:id=\"rb_imp16\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp21 != null : "fx:id=\"rb_imp21\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp22 != null : "fx:id=\"rb_imp22\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp23 != null : "fx:id=\"rb_imp23\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp24 != null : "fx:id=\"rb_imp24\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp31 != null : "fx:id=\"rb_imp31\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp32 != null : "fx:id=\"rb_imp32\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp33 != null : "fx:id=\"rb_imp33\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp34 != null : "fx:id=\"rb_imp34\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert dp_fecha != null : "fx:id=\"dp_fecha\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 

                vb_1.setVisible(true);
                cb_imp11.setVisible(false);
                rb_imp11.setVisible(false);
                rb_imp12.setVisible(false);
                rb_imp13.setVisible(false);
                        
                lb_imp11.setText("Facturas");
                hp_imp11.setText("Dev. Parcial");
                hp_imp12.setText("Notas de Cambio");
                hp_imp13.setText("Facturas Anular");
                hp_imp14.setText("Cambio de Factura");
                hp_imp15.setText("Falt. y/o Sobr.");
//                hp_imp16.setText("Red. Rosario");
                hp_imp16.setVisible(false);


                vb_2.setVisible(true);
                cb_imp21.setVisible(false);
                cb_imp22.setVisible(false);

                lb_imp21.setText("Movimientos");
                hp_imp21.setText("Red. Camion");
                hp_imp22.setText("Red. Rosario");
                hp_imp23.setText("Trans. Camion");
//                hp_imp24.setText("Des. Rosario");
                hp_imp24.setVisible(false);
                
                vb_3.setVisible(true);
                lb_imp31.setText("Inventario");
                hp_imp31.setText("Ent. de Mercancia");
                hp_imp32.setText("Merc. Recuperación");
                hp_imp33.setText("Merc. Vencida");
                hp_imp34.setText("Merc. Irrecuperable");
                dp_fecha.setVisible(false);

                vb_3.setVisible(true);
                cb_imp31.setVisible(false);
                
                break;
            case 2004010: // screen personal
                assert cb_imp11 != null : "fx:id=\"cb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert lb_imp11 != null : "fx:id=\"lb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert rb_imp11 != null : "fx:id=\"rb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert rb_imp12 != null : "fx:id=\"rb_imp12\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert rb_imp13 != null : "fx:id=\"rb_imp13\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp11 != null : "fx:id=\"rb_imp11\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp12 != null : "fx:id=\"rb_imp12\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp13 != null : "fx:id=\"rb_imp13\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp14 != null : "fx:id=\"rb_imp14\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp15 != null : "fx:id=\"rb_imp15\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp16 != null : "fx:id=\"rb_imp16\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp21 != null : "fx:id=\"rb_imp21\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp22 != null : "fx:id=\"rb_imp22\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp23 != null : "fx:id=\"rb_imp23\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp24 != null : "fx:id=\"rb_imp24\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp31 != null : "fx:id=\"rb_imp31\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp32 != null : "fx:id=\"rb_imp32\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp33 != null : "fx:id=\"rb_imp33\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert hp_imp34 != null : "fx:id=\"rb_imp34\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 
                assert dp_fecha != null : "fx:id=\"dp_fecha\" was not injected: check your FXML file 'Fxml_Print.fxml'."; 

                vb_1.setVisible(true);
                hp_imp11.setVisible(false);
                hp_imp12.setVisible(false);
                hp_imp13.setVisible(false);
                hp_imp14.setVisible(false);
                hp_imp15.setVisible(false);
                hp_imp16.setVisible(false);
                hp_imp21.setVisible(false);
                hp_imp22.setVisible(false);
                hp_imp23.setVisible(false);
                hp_imp24.setVisible(false);
                hp_imp31.setVisible(false);
                hp_imp32.setVisible(false);
                hp_imp33.setVisible(false);
                hp_imp34.setVisible(false);
                dp_fecha.setVisible(false);
                
                lb_imp11.setText("Documentos");

                rb_imp11.setToggleGroup(rb_group);
                rb_imp11.setText("Por Vencer");
                rb_imp11.setUserData("xv");

                rb_imp12.setToggleGroup(rb_group);
                rb_imp12.setText("Vencidos");
                rb_imp12.setUserData("ve");

                rb_imp13.setToggleGroup(rb_group);
                rb_imp13.setText("Pendientes");
                rb_imp13.setUserData("pe");

                ItemPrintScreen[] itemprint;

                itemprint = Ln.getInstance().find_PrintScreen(IdScreen, "vb_1");
                final ObservableList<Object> data11 = FXCollections.observableArrayList();
                data11.addAll(Arrays.asList(itemprint));          
                cb_imp11.setItems(data11); 
                new SelectKeyComboBoxListener(cb_imp11); 
                
                
                vb_2.setVisible(true);
                lb_imp21.setText("Ubicación:");
                itemprint = Ln.getInstance().find_PrintScreen(IdScreen, "vb_2");
                final ObservableList<Object> data21 = FXCollections.observableArrayList();
                data21.addAll(Arrays.asList(itemprint));          
                cb_imp21.setItems(data21); 
                new SelectKeyComboBoxListener(cb_imp21); 
                new SelectKeyComboBoxListener(cb_imp22); 

                
                vb_3.setVisible(true);
                lb_imp31.setText("T/Personal:");
                log_TPersonal[] log_tpersonal = Ln.getInstance().load_log_TPersonal();        
                final ObservableList<Object> data31 = FXCollections.observableArrayList();
                data31.addAll(Arrays.asList(log_tpersonal));          
                cb_imp31.setItems(data31); 
                new SelectKeyComboBoxListener(cb_imp31); 

                
                vb_b.setVisible(true);
                lb_b.setText("Buscar texto (Cédula o Nombres o Apellidos):");
                tf_buscar.setText(null);
                
                break;
            case 2004020: // screen vehiculos
                break;
            case 8000030: // screen groupsupplier
                break;
            case 8000040: // screen measure
                break;
            case 9000100: // screen user
                break;
        }
    }

    /**
     * Procedimiento que obtiene los Distintos Estados de la BD
     * y los carga en el COMBOBOX
     * param: nombre del pais
     */
    private void loadState(){ 
        State[] state = Ln.getInstance().load_State();
        final ObservableList<Object> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(state));          
        cb_imp22.setItems(data); 
    }    
    /**
     * Procedimiento que obtiene las Distintas Ciudades de la BD
     * y los carga en el COMBOBOX
     * param: nombre del estado
     */
    private void loadCity(){        
        City[] city = Ln.getInstance().load_City();
        final ObservableList<Object> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(city));          
        cb_imp22.setItems(data); 
    }    

    
}

//// exporting process
// 
//// 2- export to HTML
//JasperExportManager.exportReportToHtmlFile(jasperPrint, "C://sample_report.html" );
// 
//// 3- export to Excel sheet
//JRXlsExporter exporter = new JRXlsExporter();
//exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C://simple_report.xls" );
// 
//exporter.exportReport();
