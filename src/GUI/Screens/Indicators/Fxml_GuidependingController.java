/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Indicators;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.Indicators.Zsi_nros_sem;
import Objects.Indicators.Zsi_nros_sem_avg;
import Objects.Indicators.Zsi_nros_sem_day;
import Objects.Indicators.Zsi_nros_sem_r;
import Objects.Reports.Dev_FaltCarga;
import Tools.Datos;
import java.io.File;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
public class Fxml_GuidependingController implements Initializable {

    @FXML
    private AnchorPane ap_root;

    @FXML 
    private Button bt_aceptar; 

    @FXML
    private ComboBox<Integer> cb_ano;

    @FXML
    private HBox hb_1;    
    
    @FXML
    private HBox hbox_toolbar;

    @FXML
    private ImageView im_tool2;

    @FXML
    private ImageView im_tool1;

    @FXML
    private ImageView im_tool8;

    @FXML
    private ImageView im_tool12;

    @FXML
    private ImageView im_tool7;

    @FXML
    private ImageView im_tool9;

    @FXML
    private ImageView im_tool4;

    @FXML
    private ImageView im_tool3;

    @FXML
    private ImageView im_tool6;

    @FXML
    private ImageView im_tool10;

    @FXML
    private ImageView im_tool5;

    @FXML
    private ImageView im_tool11;

    @FXML
    private Label lb_mensj;

    @FXML
    private Label lb_screen;

    @FXML
    private Label lb_Title;

    @FXML
    private Label lb_lcsx;

    @FXML
    private Label lb_lcsr;

    @FXML
    private Label lb_lcix;

    @FXML
    private Label lb_lcir;

    @FXML
    private Label lb_Xm;

    @FXML
    private Label lb_Rm;

    @FXML
    private LineChart<String,Number> lc_grax;
    
    @FXML
    private LineChart<?, ?> lc_grar;
    
    @FXML
    private Slider sl_semi;
    
    @FXML
    private Slider sl_semf;

    @FXML
    private ScrollBar sbh_table;
    
    @FXML
    private TableView<Zsi_nros_sem_avg> tb_queryX;

    @FXML
    private TableView<Zsi_nros_sem_r> tb_queryR;

    @FXML
    private TextField tf_buscar;

    
    private VBox vb_form;

    @FXML
    private VBox vb_table;


    private static String rows = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("rows");
    
    private static final String path_dat = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_dat");

    private static final String path_ima = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_ima");

    private static final String path_rep = 
            java.util.ResourceBundle.getBundle("BD/DBcon").getString("path_rep");

    private static final String path = System.getProperty("user.dir");
    
    Map<String, Object> JrxmlParam = new HashMap<String, Object>();

    private static JasperReport jReport = null;
    private static JasperViewer jview = null;
    private static JasperPrint jPrint = null;
    
    private static JRBeanCollectionDataSource JRDs = null;
    
    private static SimpleDateFormat sdf_dd = new SimpleDateFormat("dd/MM/yy"); // Set your date format
    private static DateTimeFormatter dtf_yyyy = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static DateTimeFormatter dtf_dd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;
    private File file;    

    private static int numGuias         = 0; 

    private static final CategoryAxis xAxis = new CategoryAxis();
    private static final NumberAxis yAxis = new NumberAxis();

    private static XYChart.Series seriesX1 = new XYChart.Series();
    private static XYChart.Series seriesX2 = new XYChart.Series();
    private static XYChart.Series seriesX3 = new XYChart.Series();
    private static XYChart.Series seriesX4 = new XYChart.Series();

    private static XYChart.Series seriesR1 = new XYChart.Series();
    private static XYChart.Series seriesR2 = new XYChart.Series();
    private static XYChart.Series seriesR3 = new XYChart.Series();
    private static XYChart.Series seriesR4 = new XYChart.Series();
    
    private static final ObservableList<Zsi_nros_sem_avg> sqlQueryX = FXCollections.observableArrayList();
    private static final ObservableList<Zsi_nros_sem_avg> sqlQueryR = FXCollections.observableArrayList();

    private static final String ScreenName = "Consulta";
    
    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert bt_aceptar != null : "fx:id=\"bt_aceptar\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert cb_ano != null : "fx:id=\"cb_ano1\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert lb_mensj != null : "fx:id=\"lb_mensj\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert lb_screen != null : "fx:id=\"lb_screen\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert lb_lcsx != null : "fx:id=\"lb_lcsx\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert lb_lcix != null : "fx:id=\"lb_lcix\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert lb_lcsr != null : "fx:id=\"lb_lcsr\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert lb_lcir != null : "fx:id=\"lb_lcir\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert sl_semi != null : "fx:id=\"sl_semi\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert sl_semf != null : "fx:id=\"sl_semf\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert sbh_table != null : "fx:id=\"sbh_table\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert tb_queryX != null : "fx:id=\"tb_queryX\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tb_queryR != null : "fx:id=\"tb_queryR\" was not injected: check your FXML file 'Fxml_Guide.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
//        defineToolBar();         
//        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones

        loadYear();      
        createTableQueryX();
        createTableQueryR();

        //Capturador de eventos de Teclado en toda la pantalla 
        ap_root.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                nextFocusedField(ke);    //Traslado el ENFOQUE al siguiente Campo
            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT1)){
//                botonNuevo();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT2)){
//                botonEditar();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT4)){
//                botonEliminar();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT5)){
//                botonImprimir();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT6)){
//                //CANCELAR
//                botonInicio();
//            }
//            if (ke.isAltDown() && ke.getCode().equals(KeyCode.B)){
//                botonBuscar();
//            }
        });
        
    }
    
    /***************************************************************************/
    /***************************** PROCEDIMIENTOS ******************************/
    /***************************************************************************/

    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadYear(){
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        final ObservableList<Integer> data = FXCollections.observableArrayList();
        for (int i = localCalendar.get(Calendar.YEAR); i >= 2014; i--) {
            data.addAll(i);
        }
        cb_ano.setItems(data);    
        cb_ano.getSelectionModel().selectFirst();    
    }    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableQueryX(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_ano         = new TableColumn("#");
        TableColumn col_sem01       = new TableColumn("01");
        TableColumn col_sem02       = new TableColumn("02");
        TableColumn col_sem03       = new TableColumn("03");
        TableColumn col_sem04       = new TableColumn("04");
        TableColumn col_sem05       = new TableColumn("05");
        TableColumn col_sem06       = new TableColumn("06");
        TableColumn col_sem07       = new TableColumn("07");
        TableColumn col_sem08       = new TableColumn("08");
        TableColumn col_sem09       = new TableColumn("09");
        TableColumn col_sem10       = new TableColumn("10");
        TableColumn col_sem11       = new TableColumn("11");
        TableColumn col_sem12       = new TableColumn("12");
        TableColumn col_sem13       = new TableColumn("13");
        TableColumn col_sem14       = new TableColumn("14");
        TableColumn col_sem15       = new TableColumn("15");
        TableColumn col_sem16       = new TableColumn("16");
        TableColumn col_sem17       = new TableColumn("17");
        TableColumn col_sem18       = new TableColumn("18");
        TableColumn col_sem19       = new TableColumn("19");
        TableColumn col_sem20       = new TableColumn("20");
        TableColumn col_sem21       = new TableColumn("21");
        TableColumn col_sem22       = new TableColumn("22");
        TableColumn col_sem23       = new TableColumn("23");
        TableColumn col_sem24       = new TableColumn("24");
        TableColumn col_sem25       = new TableColumn("25");
        TableColumn col_sem26       = new TableColumn("26");
        TableColumn col_sem27       = new TableColumn("27");
        TableColumn col_sem28       = new TableColumn("28");
        TableColumn col_sem29       = new TableColumn("29");
        TableColumn col_sem30       = new TableColumn("30");
        TableColumn col_sem31       = new TableColumn("31");
        TableColumn col_sem32       = new TableColumn("32");
        TableColumn col_sem33       = new TableColumn("33");
        TableColumn col_sem34       = new TableColumn("34");
        TableColumn col_sem35       = new TableColumn("35");
        TableColumn col_sem36       = new TableColumn("36");
        TableColumn col_sem37       = new TableColumn("37");
        TableColumn col_sem38       = new TableColumn("38");
        TableColumn col_sem39       = new TableColumn("39");
        TableColumn col_sem40       = new TableColumn("40");
        TableColumn col_sem41       = new TableColumn("41");
        TableColumn col_sem42       = new TableColumn("42");
        TableColumn col_sem43       = new TableColumn("43");
        TableColumn col_sem44       = new TableColumn("44");
        TableColumn col_sem45       = new TableColumn("45");
        TableColumn col_sem46       = new TableColumn("46");
        TableColumn col_sem47       = new TableColumn("47");
        TableColumn col_sem48       = new TableColumn("48");
        TableColumn col_sem49       = new TableColumn("49");
        TableColumn col_sem50       = new TableColumn("50");
        TableColumn col_sem51       = new TableColumn("51");
        TableColumn col_sem52       = new TableColumn("52");
        TableColumn col_sem53       = new TableColumn("53");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_ano            ,45,   45);
        this.objectWidth(col_sem01          ,45,   45);  
        this.objectWidth(col_sem02          ,45,   45); 
        this.objectWidth(col_sem03          ,45,   45);  
        this.objectWidth(col_sem04          ,45,   45);  
        this.objectWidth(col_sem05          ,45,   45);  
        this.objectWidth(col_sem06          ,45,   45);  
        this.objectWidth(col_sem07          ,45,   45); 
        this.objectWidth(col_sem08          ,45,   45);  
        this.objectWidth(col_sem09          ,45,   45);  
        this.objectWidth(col_sem10          ,45,   45);  
        this.objectWidth(col_sem11          ,45,   45);  
        this.objectWidth(col_sem12          ,45,   45); 
        this.objectWidth(col_sem13          ,45,   45);  
        this.objectWidth(col_sem14          ,45,   45);  
        this.objectWidth(col_sem15          ,45,   45);  
        this.objectWidth(col_sem16          ,45,   45);  
        this.objectWidth(col_sem17          ,45,   45); 
        this.objectWidth(col_sem18          ,45,   45);  
        this.objectWidth(col_sem19          ,45,   45);  
        this.objectWidth(col_sem20          ,45,   45);  
        this.objectWidth(col_sem21          ,45,   45);  
        this.objectWidth(col_sem22          ,45,   45); 
        this.objectWidth(col_sem23          ,45,   45);  
        this.objectWidth(col_sem24          ,45,   45);  
        this.objectWidth(col_sem25          ,45,   45);  
        this.objectWidth(col_sem26          ,45,   45);  
        this.objectWidth(col_sem27          ,45,   45); 
        this.objectWidth(col_sem28          ,45,   45);  
        this.objectWidth(col_sem29          ,45,   45);  
        this.objectWidth(col_sem30          ,45,   45);  
        this.objectWidth(col_sem31          ,45,   45);  
        this.objectWidth(col_sem32          ,45,   45); 
        this.objectWidth(col_sem33          ,45,   45);  
        this.objectWidth(col_sem34          ,45,   45);  
        this.objectWidth(col_sem35          ,45,   45);  
        this.objectWidth(col_sem36          ,45,   45);  
        this.objectWidth(col_sem37          ,45,   45); 
        this.objectWidth(col_sem38          ,45,   45);  
        this.objectWidth(col_sem39          ,45,   45);  
        this.objectWidth(col_sem40          ,45,   45);  
        this.objectWidth(col_sem41          ,45,   45);  
        this.objectWidth(col_sem42          ,45,   45); 
        this.objectWidth(col_sem43          ,45,   45);  
        this.objectWidth(col_sem44          ,45,   45);  
        this.objectWidth(col_sem45          ,45,   45);  
        this.objectWidth(col_sem46          ,45,   45);  
        this.objectWidth(col_sem47          ,45,   45); 
        this.objectWidth(col_sem48          ,45,   45);  
        this.objectWidth(col_sem49          ,45,   45);  
        this.objectWidth(col_sem50          ,45,   45);  
        this.objectWidth(col_sem51          ,45,   45);  
        this.objectWidth(col_sem52          ,45,   45); 
        this.objectWidth(col_sem53          ,45,   45);  


        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_ano.setCellValueFactory( 
                new PropertyValueFactory<>("ano") );
        col_sem01.setCellValueFactory( 
                new PropertyValueFactory<>("sem01") );
        col_sem02.setCellValueFactory( 
                new PropertyValueFactory<>("sem02") );
        col_sem03.setCellValueFactory( 
                new PropertyValueFactory<>("sem03") );
        col_sem04.setCellValueFactory( 
                new PropertyValueFactory<>("sem04") );
        col_sem05.setCellValueFactory( 
                new PropertyValueFactory<>("sem05") );
        col_sem06.setCellValueFactory( 
                new PropertyValueFactory<>("sem06") );
        col_sem07.setCellValueFactory( 
                new PropertyValueFactory<>("sem07") );
        col_sem08.setCellValueFactory( 
                new PropertyValueFactory<>("sem08") );
        col_sem09.setCellValueFactory( 
                new PropertyValueFactory<>("sem09") );
        col_sem10.setCellValueFactory( 
                new PropertyValueFactory<>("sem10") );
        col_sem11.setCellValueFactory( 
                new PropertyValueFactory<>("sem11") );
        col_sem12.setCellValueFactory( 
                new PropertyValueFactory<>("sem12") );
        col_sem13.setCellValueFactory( 
                new PropertyValueFactory<>("sem13") );
        col_sem14.setCellValueFactory( 
                new PropertyValueFactory<>("sem14") );
        col_sem15.setCellValueFactory( 
                new PropertyValueFactory<>("sem15") );
        col_sem16.setCellValueFactory( 
                new PropertyValueFactory<>("sem16") );
        col_sem17.setCellValueFactory( 
                new PropertyValueFactory<>("sem17") );
        col_sem18.setCellValueFactory( 
                new PropertyValueFactory<>("sem18") );
        col_sem19.setCellValueFactory( 
                new PropertyValueFactory<>("sem19") );
        col_sem20.setCellValueFactory( 
                new PropertyValueFactory<>("sem20") );
        col_sem21.setCellValueFactory( 
                new PropertyValueFactory<>("sem21") );
        col_sem22.setCellValueFactory( 
                new PropertyValueFactory<>("sem22") );
        col_sem23.setCellValueFactory( 
                new PropertyValueFactory<>("sem23") );
        col_sem24.setCellValueFactory( 
                new PropertyValueFactory<>("sem24") );
        col_sem25.setCellValueFactory( 
                new PropertyValueFactory<>("sem25") );
        col_sem26.setCellValueFactory( 
                new PropertyValueFactory<>("sem26") );
        col_sem27.setCellValueFactory( 
                new PropertyValueFactory<>("sem27") );
        col_sem28.setCellValueFactory( 
                new PropertyValueFactory<>("sem28") );
        col_sem29.setCellValueFactory( 
                new PropertyValueFactory<>("sem29") );
        col_sem30.setCellValueFactory( 
                new PropertyValueFactory<>("sem30") );
        col_sem31.setCellValueFactory( 
                new PropertyValueFactory<>("sem31") );
        col_sem32.setCellValueFactory( 
                new PropertyValueFactory<>("sem32") );
        col_sem33.setCellValueFactory( 
                new PropertyValueFactory<>("sem33") );
        col_sem34.setCellValueFactory( 
                new PropertyValueFactory<>("sem34") );
        col_sem35.setCellValueFactory( 
                new PropertyValueFactory<>("sem35") );
        col_sem36.setCellValueFactory( 
                new PropertyValueFactory<>("sem36") );
        col_sem37.setCellValueFactory( 
                new PropertyValueFactory<>("sem37") );
        col_sem38.setCellValueFactory( 
                new PropertyValueFactory<>("sem38") );
        col_sem39.setCellValueFactory( 
                new PropertyValueFactory<>("sem39") );
        col_sem40.setCellValueFactory( 
                new PropertyValueFactory<>("sem40") );
        col_sem41.setCellValueFactory( 
                new PropertyValueFactory<>("sem41") );
        col_sem42.setCellValueFactory( 
                new PropertyValueFactory<>("sem42") );
        col_sem43.setCellValueFactory( 
                new PropertyValueFactory<>("sem43") );
        col_sem44.setCellValueFactory( 
                new PropertyValueFactory<>("sem44") );
        col_sem45.setCellValueFactory( 
                new PropertyValueFactory<>("sem45") );
        col_sem46.setCellValueFactory( 
                new PropertyValueFactory<>("sem46") );
        col_sem47.setCellValueFactory( 
                new PropertyValueFactory<>("sem47") );
        col_sem48.setCellValueFactory( 
                new PropertyValueFactory<>("sem48") );
        col_sem49.setCellValueFactory( 
                new PropertyValueFactory<>("sem49") );
        col_sem50.setCellValueFactory( 
                new PropertyValueFactory<>("sem50") );
        col_sem51.setCellValueFactory( 
                new PropertyValueFactory<>("sem51") );
        col_sem52.setCellValueFactory( 
                new PropertyValueFactory<>("sem52") );
        col_sem53.setCellValueFactory( 
                new PropertyValueFactory<>("sem53") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_queryX.getColumns().addAll(
                col_sem01, col_sem02, col_sem03, col_sem04, col_sem05, col_sem06, col_sem07, col_sem08, col_sem09, col_sem10,
                col_sem11, col_sem12, col_sem13, col_sem14, col_sem15, col_sem16, col_sem17, col_sem18, col_sem19, col_sem20,
                col_sem21, col_sem22, col_sem23, col_sem24, col_sem25, col_sem26, col_sem27, col_sem28, col_sem29, col_sem30,
                col_sem31, col_sem32, col_sem33, col_sem34, col_sem35, col_sem36, col_sem37, col_sem38, col_sem39, col_sem40,
                col_sem41, col_sem42, col_sem43, col_sem44, col_sem45, col_sem46, col_sem47, col_sem48, col_sem49, col_sem50,
                col_sem51, col_sem52, col_sem53
                );                
        
        //Se Asigna menu contextual 

        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRowInvoice();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_queryX.setOnKeyReleased(eh);
    }
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTableQueryR(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_ano         = new TableColumn("#");
        TableColumn col_sem01       = new TableColumn("01");
        TableColumn col_sem02       = new TableColumn("02");
        TableColumn col_sem03       = new TableColumn("03");
        TableColumn col_sem04       = new TableColumn("04");
        TableColumn col_sem05       = new TableColumn("05");
        TableColumn col_sem06       = new TableColumn("06");
        TableColumn col_sem07       = new TableColumn("07");
        TableColumn col_sem08       = new TableColumn("08");
        TableColumn col_sem09       = new TableColumn("09");
        TableColumn col_sem10       = new TableColumn("10");
        TableColumn col_sem11       = new TableColumn("11");
        TableColumn col_sem12       = new TableColumn("12");
        TableColumn col_sem13       = new TableColumn("13");
        TableColumn col_sem14       = new TableColumn("14");
        TableColumn col_sem15       = new TableColumn("15");
        TableColumn col_sem16       = new TableColumn("16");
        TableColumn col_sem17       = new TableColumn("17");
        TableColumn col_sem18       = new TableColumn("18");
        TableColumn col_sem19       = new TableColumn("19");
        TableColumn col_sem20       = new TableColumn("20");
        TableColumn col_sem21       = new TableColumn("21");
        TableColumn col_sem22       = new TableColumn("22");
        TableColumn col_sem23       = new TableColumn("23");
        TableColumn col_sem24       = new TableColumn("24");
        TableColumn col_sem25       = new TableColumn("25");
        TableColumn col_sem26       = new TableColumn("26");
        TableColumn col_sem27       = new TableColumn("27");
        TableColumn col_sem28       = new TableColumn("28");
        TableColumn col_sem29       = new TableColumn("29");
        TableColumn col_sem30       = new TableColumn("30");
        TableColumn col_sem31       = new TableColumn("31");
        TableColumn col_sem32       = new TableColumn("32");
        TableColumn col_sem33       = new TableColumn("33");
        TableColumn col_sem34       = new TableColumn("34");
        TableColumn col_sem35       = new TableColumn("35");
        TableColumn col_sem36       = new TableColumn("36");
        TableColumn col_sem37       = new TableColumn("37");
        TableColumn col_sem38       = new TableColumn("38");
        TableColumn col_sem39       = new TableColumn("39");
        TableColumn col_sem40       = new TableColumn("40");
        TableColumn col_sem41       = new TableColumn("41");
        TableColumn col_sem42       = new TableColumn("42");
        TableColumn col_sem43       = new TableColumn("43");
        TableColumn col_sem44       = new TableColumn("44");
        TableColumn col_sem45       = new TableColumn("45");
        TableColumn col_sem46       = new TableColumn("46");
        TableColumn col_sem47       = new TableColumn("47");
        TableColumn col_sem48       = new TableColumn("48");
        TableColumn col_sem49       = new TableColumn("49");
        TableColumn col_sem50       = new TableColumn("50");
        TableColumn col_sem51       = new TableColumn("51");
        TableColumn col_sem52       = new TableColumn("52");
        TableColumn col_sem53       = new TableColumn("53");
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_ano            ,45,   45);
        this.objectWidth(col_sem01          ,45,   45);  
        this.objectWidth(col_sem02          ,45,   45); 
        this.objectWidth(col_sem03          ,45,   45);  
        this.objectWidth(col_sem04          ,45,   45);  
        this.objectWidth(col_sem05          ,45,   45);  
        this.objectWidth(col_sem06          ,45,   45);  
        this.objectWidth(col_sem07          ,45,   45); 
        this.objectWidth(col_sem08          ,45,   45);  
        this.objectWidth(col_sem09          ,45,   45);  
        this.objectWidth(col_sem10          ,45,   45);  
        this.objectWidth(col_sem11          ,45,   45);  
        this.objectWidth(col_sem12          ,45,   45); 
        this.objectWidth(col_sem13          ,45,   45);  
        this.objectWidth(col_sem14          ,45,   45);  
        this.objectWidth(col_sem15          ,45,   45);  
        this.objectWidth(col_sem16          ,45,   45);  
        this.objectWidth(col_sem17          ,45,   45); 
        this.objectWidth(col_sem18          ,45,   45);  
        this.objectWidth(col_sem19          ,45,   45);  
        this.objectWidth(col_sem20          ,45,   45);  
        this.objectWidth(col_sem21          ,45,   45);  
        this.objectWidth(col_sem22          ,45,   45); 
        this.objectWidth(col_sem23          ,45,   45);  
        this.objectWidth(col_sem24          ,45,   45);  
        this.objectWidth(col_sem25          ,45,   45);  
        this.objectWidth(col_sem26          ,45,   45);  
        this.objectWidth(col_sem27          ,45,   45); 
        this.objectWidth(col_sem28          ,45,   45);  
        this.objectWidth(col_sem29          ,45,   45);  
        this.objectWidth(col_sem30          ,45,   45);  
        this.objectWidth(col_sem31          ,45,   45);  
        this.objectWidth(col_sem32          ,45,   45); 
        this.objectWidth(col_sem33          ,45,   45);  
        this.objectWidth(col_sem34          ,45,   45);  
        this.objectWidth(col_sem35          ,45,   45);  
        this.objectWidth(col_sem36          ,45,   45);  
        this.objectWidth(col_sem37          ,45,   45); 
        this.objectWidth(col_sem38          ,45,   45);  
        this.objectWidth(col_sem39          ,45,   45);  
        this.objectWidth(col_sem40          ,45,   45);  
        this.objectWidth(col_sem41          ,45,   45);  
        this.objectWidth(col_sem42          ,45,   45); 
        this.objectWidth(col_sem43          ,45,   45);  
        this.objectWidth(col_sem44          ,45,   45);  
        this.objectWidth(col_sem45          ,45,   45);  
        this.objectWidth(col_sem46          ,45,   45);  
        this.objectWidth(col_sem47          ,45,   45); 
        this.objectWidth(col_sem48          ,45,   45);  
        this.objectWidth(col_sem49          ,45,   45);  
        this.objectWidth(col_sem50          ,45,   45);  
        this.objectWidth(col_sem51          ,45,   45);  
        this.objectWidth(col_sem52          ,45,   45); 
        this.objectWidth(col_sem53          ,45,   45);  


        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_ano.setCellValueFactory( 
                new PropertyValueFactory<>("ano") );
        col_sem01.setCellValueFactory( 
                new PropertyValueFactory<>("sem01") );
        col_sem02.setCellValueFactory( 
                new PropertyValueFactory<>("sem02") );
        col_sem03.setCellValueFactory( 
                new PropertyValueFactory<>("sem03") );
        col_sem04.setCellValueFactory( 
                new PropertyValueFactory<>("sem04") );
        col_sem05.setCellValueFactory( 
                new PropertyValueFactory<>("sem05") );
        col_sem06.setCellValueFactory( 
                new PropertyValueFactory<>("sem06") );
        col_sem07.setCellValueFactory( 
                new PropertyValueFactory<>("sem07") );
        col_sem08.setCellValueFactory( 
                new PropertyValueFactory<>("sem08") );
        col_sem09.setCellValueFactory( 
                new PropertyValueFactory<>("sem09") );
        col_sem10.setCellValueFactory( 
                new PropertyValueFactory<>("sem10") );
        col_sem11.setCellValueFactory( 
                new PropertyValueFactory<>("sem11") );
        col_sem12.setCellValueFactory( 
                new PropertyValueFactory<>("sem12") );
        col_sem13.setCellValueFactory( 
                new PropertyValueFactory<>("sem13") );
        col_sem14.setCellValueFactory( 
                new PropertyValueFactory<>("sem14") );
        col_sem15.setCellValueFactory( 
                new PropertyValueFactory<>("sem15") );
        col_sem16.setCellValueFactory( 
                new PropertyValueFactory<>("sem16") );
        col_sem17.setCellValueFactory( 
                new PropertyValueFactory<>("sem17") );
        col_sem18.setCellValueFactory( 
                new PropertyValueFactory<>("sem18") );
        col_sem19.setCellValueFactory( 
                new PropertyValueFactory<>("sem19") );
        col_sem20.setCellValueFactory( 
                new PropertyValueFactory<>("sem20") );
        col_sem21.setCellValueFactory( 
                new PropertyValueFactory<>("sem21") );
        col_sem22.setCellValueFactory( 
                new PropertyValueFactory<>("sem22") );
        col_sem23.setCellValueFactory( 
                new PropertyValueFactory<>("sem23") );
        col_sem24.setCellValueFactory( 
                new PropertyValueFactory<>("sem24") );
        col_sem25.setCellValueFactory( 
                new PropertyValueFactory<>("sem25") );
        col_sem26.setCellValueFactory( 
                new PropertyValueFactory<>("sem26") );
        col_sem27.setCellValueFactory( 
                new PropertyValueFactory<>("sem27") );
        col_sem28.setCellValueFactory( 
                new PropertyValueFactory<>("sem28") );
        col_sem29.setCellValueFactory( 
                new PropertyValueFactory<>("sem29") );
        col_sem30.setCellValueFactory( 
                new PropertyValueFactory<>("sem30") );
        col_sem31.setCellValueFactory( 
                new PropertyValueFactory<>("sem31") );
        col_sem32.setCellValueFactory( 
                new PropertyValueFactory<>("sem32") );
        col_sem33.setCellValueFactory( 
                new PropertyValueFactory<>("sem33") );
        col_sem34.setCellValueFactory( 
                new PropertyValueFactory<>("sem34") );
        col_sem35.setCellValueFactory( 
                new PropertyValueFactory<>("sem35") );
        col_sem36.setCellValueFactory( 
                new PropertyValueFactory<>("sem36") );
        col_sem37.setCellValueFactory( 
                new PropertyValueFactory<>("sem37") );
        col_sem38.setCellValueFactory( 
                new PropertyValueFactory<>("sem38") );
        col_sem39.setCellValueFactory( 
                new PropertyValueFactory<>("sem39") );
        col_sem40.setCellValueFactory( 
                new PropertyValueFactory<>("sem40") );
        col_sem41.setCellValueFactory( 
                new PropertyValueFactory<>("sem41") );
        col_sem42.setCellValueFactory( 
                new PropertyValueFactory<>("sem42") );
        col_sem43.setCellValueFactory( 
                new PropertyValueFactory<>("sem43") );
        col_sem44.setCellValueFactory( 
                new PropertyValueFactory<>("sem44") );
        col_sem45.setCellValueFactory( 
                new PropertyValueFactory<>("sem45") );
        col_sem46.setCellValueFactory( 
                new PropertyValueFactory<>("sem46") );
        col_sem47.setCellValueFactory( 
                new PropertyValueFactory<>("sem47") );
        col_sem48.setCellValueFactory( 
                new PropertyValueFactory<>("sem48") );
        col_sem49.setCellValueFactory( 
                new PropertyValueFactory<>("sem49") );
        col_sem50.setCellValueFactory( 
                new PropertyValueFactory<>("sem50") );
        col_sem51.setCellValueFactory( 
                new PropertyValueFactory<>("sem51") );
        col_sem52.setCellValueFactory( 
                new PropertyValueFactory<>("sem52") );
        col_sem53.setCellValueFactory( 
                new PropertyValueFactory<>("sem53") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_queryR.getColumns().addAll(
                col_sem01, col_sem02, col_sem03, col_sem04, col_sem05, col_sem06, col_sem07, col_sem08, col_sem09, col_sem10,
                col_sem11, col_sem12, col_sem13, col_sem14, col_sem15, col_sem16, col_sem17, col_sem18, col_sem19, col_sem20,
                col_sem21, col_sem22, col_sem23, col_sem24, col_sem25, col_sem26, col_sem27, col_sem28, col_sem29, col_sem30,
                col_sem31, col_sem32, col_sem33, col_sem34, col_sem35, col_sem36, col_sem37, col_sem38, col_sem39, col_sem40,
                col_sem41, col_sem42, col_sem43, col_sem44, col_sem45, col_sem46, col_sem47, col_sem48, col_sem49, col_sem50,
                col_sem51, col_sem52, col_sem53
                );                
        
        //Se Asigna menu contextual 

        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    //selectedRowInvoice();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_queryR.setOnKeyReleased(eh);
    }
    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){       
        //tf_nroguia.setText(String.valueOf(Datos.getLog_cguias().getNumrela()));
        
        //Ejecuta el metodo que define el formulario segun el tipo de operacion que fue ejecutada
        setCurrentOperation();
    }  
    /**
     * Metodo que ejecuta los procesos de modificacion del formulario y otros, 
     * correspondientes al tipo de operacion que se este ejecutando
     */
    private void setCurrentOperation(){     
        boolean isNamesVisible = true;   //Valor logico si los campos de nombres y apellidos seran visibles
        Integer[] disables;              //Se declara el arreglo que contendra las posiciones de la TOOLBAR que seran DESHABILITADOS para cada operacion
        loadToolBar();                   //Se Refresca la barra de Herramientas
        lb_Title.setText("");            //Se deja en blanco la etiqueta del Titulo
        //Se evalua el tipo de Operacion
        switch(tipoOperacion){
            case 0:  //SOLO LECTURA                    

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,5,6,9,10};
                disableAllToolBar(disables); 
                break;
            case 1:  //NUEVO
//                lb_Title.setText("NUEVO");

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText("EDITAR");

                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{2,5,6,7,8,9,10};
                disableAllToolBar(disables); 
                break;
        }        
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableQueryX(Zsi_nros_sem_avg[] sqlQuery){    
        if(sqlQuery != null){
            ObservableList<Zsi_nros_sem_avg> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(sqlQuery));        
            tb_queryX.setItems(data);        
        }
    } 
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTableQueryR(Zsi_nros_sem_r[] sqlQuery){    
        if(sqlQuery != null){
            ObservableList<Zsi_nros_sem_r> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(sqlQuery));        
            tb_queryR.setItems(data);        
        }
    } 

    /***************************************************************************/
    /************************ METODOS DE ACCESO RAPIDO *************************/
    /***************************************************************************/
        
    /**
     * Metodo que define el arreglo de NODOS del formulario que podran ser
     * enfocados con las teclas
     * @param opc 
     */
    private void init_FocusArray(int opc){
        Gui.setFieldsType(opc);
        //Se definen los NODOS del formulario que estaran activos segun la operacion
        //y se inicializa la posicion del foco
        Node[] nodos = null;
        switch(opc){
            case 0:     //SOLO LECTURA
                nodos = new Node[]{
                    cb_ano, sl_semi, sl_semf, bt_aceptar
                    };
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    };
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    };
                break;
        }             
        switch (opc){
            case 0: 
            case 1: 
            case 2: 
                Gui.setFields(nodos); 
                Gui.setFieldFocused(0);
                Gui.setFieldsSize(nodos.length);
                break;
        }

        //Inicializo los Listeners de cada uno de los NODOS del formulario
        for(int i=0;i < Gui.getFields().length; i++){
            FocusPropertyChangeListener fpcl = new FocusPropertyChangeListener(Gui.getFields()[i],i);
            Gui.getFields()[i].focusedProperty().addListener(fpcl);                
        }
    }  
    /**
     * Metodo encargado de cambiar el FOCUS entre los nodos del Formulario y 
     * ejecutar los procedimientos correspondientes.
     */
    private void nextFocusedField(KeyEvent ke) {
        Gui.sumFieldFocused();  //Aumenta el contador
        //Si el foco esta en algun nodo del formulario 
        if(Gui.getFieldFocused() < Gui.getFieldsSize()){
            //Se Enfoca el nuevo nodo correspondiente
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();            
        }else{  //Sino
//            botonGuardar();  //Guardar los datos
        }                
    }
    
    /***************************************************************************/
    /**************************** METODOS DE TOOLBAR ***************************/
    /***************************************************************************/
    
    /**
     * Inicializa la TOOLBAR, carga de la BD la configuracion del usuario, define el orden de los botones 
     * y asigna los TOOLTIPS de cada boton.
     */
    private void defineToolBar() {
        //ARREGLO CON LOS BOTONES ORDENADOS POR POSICION
        tools = new ImageView[]{im_tool1,im_tool2,im_tool3,im_tool4,im_tool5,im_tool6,im_tool7,im_tool8,im_tool9,im_tool10,im_tool11,im_tool12};        
        //CARGA DE LA BD LA CONFIGURACION DE USUARIO PARA LA PANTALLA
        toolsConfig = Ln.getInstance().loadToolBar();
        // arreglo con cada etiqueta, ordenado por boton
        tooltips = new String[]{
            "Nueva " + ScreenName + " ",
            "Editar " + ScreenName + " ",
            "Guardar " + ScreenName + " ",
            "Cambiar Status de " + ScreenName + " ",
            "Imprimir " + ScreenName + " ",
            "Cancelar ",
            "Sin Asignar ",
            "Faltante en " + ScreenName + " ",
            "Devolución en " + ScreenName + " ",
            "Sin Asignar",
            "Sin Asignar",
            "Buscar " + ScreenName + " "
            };
        //se asigna la etiqueta a su respectivo boton
        for (int i = 0; i < tools.length; i++) {            
            Tooltip tip_tool = new Tooltip(tooltips[i]);
            Tooltip.install(tools[i], tip_tool);
        }
        
        im_tool1.setVisible(false);
        im_tool2.setVisible(false);
        im_tool3.setVisible(false);
        im_tool4.setVisible(false);
        im_tool6.setVisible(false);
        im_tool7.setVisible(false);
        im_tool8.setVisible(false);
        im_tool9.setVisible(false);
        im_tool10.setVisible(false);
        im_tool11.setVisible(false);
        im_tool12.setVisible(false);
    }
    /**
     * Metodo que se encarga de habilitar y deshabilitar los botones segun
     * la configuracion asignada al ROL del Usuario
     */    
    private void loadToolBar() {
        //si existe la configuracion de la TOOLBAR asociada al usuario
        if(toolsConfig != null){
            //Si el id de pantalla es la correcta y se encuentra activo 1 el TOOLBAR
            if(Datos.getIdScreen()==toolsConfig[0] && toolsConfig[1]==1){                
                for (int i = 0; i < tools.length; i++){    //Recorre el arreglo de botones
                    if(toolsConfig[i+2] == 1){      //Si esta disponible 1 
                        enableToolBar(tools, i);    //habilita el boton
                    }else{  
                        disableToolBar(tools,i);    //deshabilita el boton
                    }                    
                }
            }
        }
        else{
            for (int i = 0; i < tools.length; i++){    //Recorre el arreglo de botones
                disableToolBar(tools,i);    //deshabilita el boton
            }
        }
    }
    /**
     * Metodo que se encarga de DESHABILITAR toodos los botones definidos en el parametro de entrada.
     * @param disables Contiene las posiciones del Arreglo TOOLS que define cuales botones seran desactivados
     */
    private void disableAllToolBar(Integer[] disables) {
        for (int i = 0; i < disables.length; i++) { //Recorre todo el arreglo
            //Deshabilita el boton de TOOLS que se encuentra en la posicion disbles[i]
            disableToolBar(tools,disables[i]);  
        }
    }
    /**
     * Metodo que DESHABILITA un boton del TOOLBAR
     * @param im Arreglo con todos los botones del TOOLBAR
     * @param j Posicion del boton que se va a deshabilitar
     */
    private void disableToolBar(ImageView[] im,int j) {        
        BoxBlur bb = new BoxBlur();     //Inicializa el efecto Difuminado
        //se define los parametros del efecto del 
        bb.setWidth(5);                 
        bb.setHeight(5);                
        bb.setIterations(1);            
        im[j].setEffect(bb);            //Asigna el Efecto al Boton Correspondiente
        im[j].setDisable(true);         //Deshabilita el Boton Correspondiente
    }    
    /**
     * Metodo que HABILITA un boton del TOOLBAR
     * @param im Arreglo con todos los botones del TOOLBAR
     * @param j Posicion del boton que se va a habilitar
     */
    private void enableToolBar(ImageView[] im,int j) {        
        im[j].setEffect(null);      //Quita cualquier efecto asignado al boton
        im[j].setDisable(false);    //Habilita el boton   
    }
    
    /***************************************************************************/
    /**************************** METODOS DE BOTONES ***************************/
    /***************************************************************************/
    
    /**
     * Metodo que Define el comportamiento del TEXTFIELD de busqueda
     */
    private void defineBotonBuscar() {
        tf_buscar.setVisible(false);    //establece el textField como oculto al iniciarse la Pantalla
        //Manejador del Evento
        
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //SI es presionado ENTER o TAB entonces
                if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){     
                    //Valida que el evento se haya generado en el campo de busqueda
                    if(((Node)ke.getSource()).getId().equals("tf_buscar")){                        
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        tf_buscar.setVisible(false);    //establece el textField como oculto al finalizar
                    }
                }
            }
        };
        //Se asigna el manejador a ejecutarse cuando se suelta una tecla
        tf_buscar.setOnKeyReleased(eh);
    }        
    
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA

        ObservableList<Dev_FaltCarga> data = FXCollections.observableArrayList();
        data.addAll(Datos.getRep_dev_faltcarga());   
        JRDs = new JRBeanCollectionDataSource(data, true);

        JrxmlParam.put("p_user", Datos.getSesion().getUsername());
        JrxmlParam.put("p_subtitulo", "");
 
        try{ 
            jReport = (JasperReport) JRLoader.loadObjectFromFile(path + path_rep + "/logistica/log_dev_port_rep_faltcarga.jasper");
            jPrint = JasperFillManager.fillReport(jReport, JrxmlParam, JRDs);
            jview = new JasperViewer(jPrint, false);
            jview.setTitle("DIGA - Relación de Notas de Faltante en Carga (Logistica) ");
        } catch (JRException ee){
            Gui.getInstance().showMessage("Error Cargando Reporte: \n" + ee.getMessage(), "E");
        }
        jview.setVisible(true);
        jview.setResizable(false);
    }
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){
        tb_queryR.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth) {
                Pane header = (Pane) tb_queryR.lookup("TableHeaderRow");
                if (header.isVisible()){
                    header.setMaxHeight(0);
                    header.setMinHeight(0);
                    header.setPrefHeight(0);
                    header.setVisible(false);
                }
            }
        });        
        /**
         * BOTON EXECUTE
         */
        bt_aceptar.setOnAction((ActionEvent event) -> {
            int year = 0;
            int sem = 0;

            double A2 = .483;
            double D3 = 0;
            double D4 = 2.004;
            
            double Xm = 0;
            double lcsX = 0;
            double lciX = 0;

            double Rm = 0;
            double lcsR = 0;
            double lciR = 0;

            if (cb_ano.getValue() != null)
                year = cb_ano.getValue();

            NumberFormat df = DecimalFormat.getInstance();
            df.setMinimumFractionDigits(2);
            df.setRoundingMode(RoundingMode.DOWN);

            Zsi_nros_sem[] zsi_nros_sem_avgv = Ln.getInstance().find_Zsi_nros_sem(year);
            Zsi_nros_sem_avg[] zsi_nros_sem_avg = Ln.getInstance().find_Zsi_nros_sem_avg(year);
            Zsi_nros_sem_day[] zsi_nros_sem_day = Ln.getInstance().find_Zsi_nros_sem_day(year);
            Zsi_nros_sem_r[] zsi_nros_sem_r = Ln.getInstance().find_Zsi_nros_sem_r(year);

            sqlQueryX.addAll(zsi_nros_sem_avg);
            
            Datos.setInd_zsi_nros_sem_avg(zsi_nros_sem_avg);
            loadTableQueryX(Datos.getInd_zsi_nros_sem_avg());

            Datos.setInd_zsi_nros_sem_r(zsi_nros_sem_r);
            loadTableQueryR(Datos.getInd_zsi_nros_sem_r());
            
            Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
            int currentWeekOfYear = localCalendar.get(Calendar.WEEK_OF_YEAR);
            
            for (int i = 0; i < zsi_nros_sem_avgv.length; i++) {
                if(i <= currentWeekOfYear){
                    if(zsi_nros_sem_avgv[i].getXm() != 0){
                        sem += 1;
                        Xm += zsi_nros_sem_avgv[i].getXm();
                    }
                    if(zsi_nros_sem_avgv[i].getRm()!= 0){
                        Rm += zsi_nros_sem_avgv[i].getRm();
                    }
                }
                else{
                    break;
                }
            }
            sl_semf.setValue(sem);

            Xm = Xm / sem;
            String xm = Double.toString(Xm);
            lb_Xm.setText(df.format(Double.parseDouble(xm)));

            Rm = Rm / sem;
            String rm = Double.toString(Rm);
            lb_Rm.setText(df.format(Double.parseDouble(rm)));

            for (int i = 0; i < zsi_nros_sem_avgv.length; i++) {
                if(i <= currentWeekOfYear){
                    if(zsi_nros_sem_avgv[i].getXm() != 0){
                        lcsX = zsi_nros_sem_avgv[i].getXm() + (A2 * Rm);
                        lciX = zsi_nros_sem_avgv[i].getXm() - (A2 * Rm);
                    }
                    if(zsi_nros_sem_avgv[i].getRm() != 0){
                        lcsR = (D4 * Rm);
                        lciR = (D3 * Rm);
                    }
                }
                else{
                    break;
                }
            }
            String lcsx = Double.toString(lcsX);
            lb_lcsx.setText(df.format(Double.parseDouble(lcsx)));
            String lcix = Double.toString(lciX);
            lb_lcix.setText(df.format(Double.parseDouble(lcix)));

            String lcsr = Double.toString(lcsR);
            lb_lcsr.setText(df.format(Double.parseDouble(lcsr)));
            String lcir = Double.toString(lciR);
            lb_lcir.setText(df.format(Double.parseDouble(lcir)));
            
            
            lc_grax.getData().clear();
            xAxis.setLabel("Semanas");       
            
            seriesX1.setName("LCS");
            seriesX1.getData().add(new XYChart.Data("2", lcsX));
            seriesX1.getData().add(new XYChart.Data("3", lcsX));
            seriesX1.getData().add(new XYChart.Data("4", lcsX));
            seriesX1.getData().add(new XYChart.Data("5", lcsX));
            seriesX1.getData().add(new XYChart.Data("6", lcsX));
            seriesX1.getData().add(new XYChart.Data("7", lcsX));
            seriesX1.getData().add(new XYChart.Data("8", lcsX));
            seriesX1.getData().add(new XYChart.Data("9", lcsX));
            seriesX1.getData().add(new XYChart.Data("10", lcsX));
            seriesX1.getData().add(new XYChart.Data("11", lcsX));
            seriesX1.getData().add(new XYChart.Data("12", lcsX));
            seriesX1.getData().add(new XYChart.Data("13", lcsX));
            seriesX1.getData().add(new XYChart.Data("14", lcsX));
            seriesX1.getData().add(new XYChart.Data("15", lcsX));
            seriesX1.getData().add(new XYChart.Data("16", lcsX));
            seriesX1.getData().add(new XYChart.Data("17", lcsX));
            seriesX1.getData().add(new XYChart.Data("18", lcsX));
            seriesX1.getData().add(new XYChart.Data("19", lcsX));
            seriesX1.getData().add(new XYChart.Data("20", lcsX));
            seriesX1.getData().add(new XYChart.Data("21", lcsX));
            seriesX1.getData().add(new XYChart.Data("22", lcsX));
            seriesX1.getData().add(new XYChart.Data("23", lcsX));
            seriesX1.getData().add(new XYChart.Data("24", lcsX));
            seriesX1.getData().add(new XYChart.Data("25", lcsX));
            seriesX1.getData().add(new XYChart.Data("26", lcsX));
            seriesX1.getData().add(new XYChart.Data("27", lcsX));
            seriesX1.getData().add(new XYChart.Data("28", lcsX));
            seriesX1.getData().add(new XYChart.Data("29", lcsX));
            seriesX1.getData().add(new XYChart.Data("30", lcsX));
            seriesX1.getData().add(new XYChart.Data("31", lcsX));
            seriesX1.getData().add(new XYChart.Data("32", lcsX));
            seriesX1.getData().add(new XYChart.Data("33", lcsX));
            seriesX1.getData().add(new XYChart.Data("34", lcsX));
            seriesX1.getData().add(new XYChart.Data("35", lcsX));
            seriesX1.getData().add(new XYChart.Data("36", lcsX));
            seriesX1.getData().add(new XYChart.Data("37", lcsX));
            seriesX1.getData().add(new XYChart.Data("38", lcsX));
            seriesX1.getData().add(new XYChart.Data("39", lcsX));
            seriesX1.getData().add(new XYChart.Data("40", lcsX));
            seriesX1.getData().add(new XYChart.Data("41", lcsX));
            seriesX1.getData().add(new XYChart.Data("42", lcsX));
            seriesX1.getData().add(new XYChart.Data("43", lcsX));
            seriesX1.getData().add(new XYChart.Data("44", lcsX));
            seriesX1.getData().add(new XYChart.Data("45", lcsX));
            seriesX1.getData().add(new XYChart.Data("46", lcsX));
            seriesX1.getData().add(new XYChart.Data("47", lcsX));
            seriesX1.getData().add(new XYChart.Data("48", lcsX));
            seriesX1.getData().add(new XYChart.Data("49", lcsX));
            seriesX1.getData().add(new XYChart.Data("50", lcsX));
            seriesX1.getData().add(new XYChart.Data("51", lcsX));
            seriesX1.getData().add(new XYChart.Data("52", lcsX));
            seriesX1.getData().add(new XYChart.Data("53", lcsX));

            
            seriesX2.setName("X");
            seriesX2.getData().add(new XYChart.Data("2", zsi_nros_sem_avg[0].getSem02()));
            seriesX2.getData().add(new XYChart.Data("3", zsi_nros_sem_avg[0].getSem03()));
            seriesX2.getData().add(new XYChart.Data("4", zsi_nros_sem_avg[0].getSem04()));
            seriesX2.getData().add(new XYChart.Data("5", zsi_nros_sem_avg[0].getSem05()));
            seriesX2.getData().add(new XYChart.Data("6", zsi_nros_sem_avg[0].getSem06()));
            seriesX2.getData().add(new XYChart.Data("7", zsi_nros_sem_avg[0].getSem07()));
            seriesX2.getData().add(new XYChart.Data("8", zsi_nros_sem_avg[0].getSem08()));
            seriesX2.getData().add(new XYChart.Data("9", zsi_nros_sem_avg[0].getSem09()));
            seriesX2.getData().add(new XYChart.Data("10", zsi_nros_sem_avg[0].getSem10()));
            seriesX2.getData().add(new XYChart.Data("11", zsi_nros_sem_avg[0].getSem11()));
            seriesX2.getData().add(new XYChart.Data("12", zsi_nros_sem_avg[0].getSem12()));
            seriesX2.getData().add(new XYChart.Data("13", zsi_nros_sem_avg[0].getSem13()));
            seriesX2.getData().add(new XYChart.Data("14", zsi_nros_sem_avg[0].getSem14()));
            seriesX2.getData().add(new XYChart.Data("15", zsi_nros_sem_avg[0].getSem15()));
            seriesX2.getData().add(new XYChart.Data("16", zsi_nros_sem_avg[0].getSem16()));
            seriesX2.getData().add(new XYChart.Data("17", zsi_nros_sem_avg[0].getSem17()));
            seriesX2.getData().add(new XYChart.Data("18", zsi_nros_sem_avg[0].getSem18()));
            seriesX2.getData().add(new XYChart.Data("19", zsi_nros_sem_avg[0].getSem19()));
            seriesX2.getData().add(new XYChart.Data("20", zsi_nros_sem_avg[0].getSem20()));
            seriesX2.getData().add(new XYChart.Data("21", zsi_nros_sem_avg[0].getSem21()));
            seriesX2.getData().add(new XYChart.Data("22", zsi_nros_sem_avg[0].getSem22()));
            seriesX2.getData().add(new XYChart.Data("23", zsi_nros_sem_avg[0].getSem23()));
            seriesX2.getData().add(new XYChart.Data("24", zsi_nros_sem_avg[0].getSem24()));
            seriesX2.getData().add(new XYChart.Data("25", zsi_nros_sem_avg[0].getSem25()));
            seriesX2.getData().add(new XYChart.Data("26", zsi_nros_sem_avg[0].getSem26()));
            seriesX2.getData().add(new XYChart.Data("27", zsi_nros_sem_avg[0].getSem27()));
            seriesX2.getData().add(new XYChart.Data("28", zsi_nros_sem_avg[0].getSem28()));
            seriesX2.getData().add(new XYChart.Data("29", zsi_nros_sem_avg[0].getSem29()));
            seriesX2.getData().add(new XYChart.Data("30", zsi_nros_sem_avg[0].getSem30()));
            seriesX2.getData().add(new XYChart.Data("31", zsi_nros_sem_avg[0].getSem31()));
            seriesX2.getData().add(new XYChart.Data("32", zsi_nros_sem_avg[0].getSem32()));
            seriesX2.getData().add(new XYChart.Data("33", zsi_nros_sem_avg[0].getSem33()));
            seriesX2.getData().add(new XYChart.Data("34", zsi_nros_sem_avg[0].getSem34()));
            seriesX2.getData().add(new XYChart.Data("35", zsi_nros_sem_avg[0].getSem35()));
            seriesX2.getData().add(new XYChart.Data("36", zsi_nros_sem_avg[0].getSem36()));
            seriesX2.getData().add(new XYChart.Data("37", zsi_nros_sem_avg[0].getSem37()));
            seriesX2.getData().add(new XYChart.Data("38", zsi_nros_sem_avg[0].getSem38()));
            seriesX2.getData().add(new XYChart.Data("39", zsi_nros_sem_avg[0].getSem39()));
            seriesX2.getData().add(new XYChart.Data("40", zsi_nros_sem_avg[0].getSem40()));
            seriesX2.getData().add(new XYChart.Data("41", zsi_nros_sem_avg[0].getSem41()));
            seriesX2.getData().add(new XYChart.Data("42", zsi_nros_sem_avg[0].getSem42()));
            seriesX2.getData().add(new XYChart.Data("43", zsi_nros_sem_avg[0].getSem43()));
            seriesX2.getData().add(new XYChart.Data("44", zsi_nros_sem_avg[0].getSem44()));
            seriesX2.getData().add(new XYChart.Data("45", zsi_nros_sem_avg[0].getSem45()));
            seriesX2.getData().add(new XYChart.Data("46", zsi_nros_sem_avg[0].getSem46()));
            seriesX2.getData().add(new XYChart.Data("47", zsi_nros_sem_avg[0].getSem47()));
            seriesX2.getData().add(new XYChart.Data("48", zsi_nros_sem_avg[0].getSem48()));
            seriesX2.getData().add(new XYChart.Data("49", zsi_nros_sem_avg[0].getSem49()));
            seriesX2.getData().add(new XYChart.Data("50", zsi_nros_sem_avg[0].getSem50()));
            seriesX2.getData().add(new XYChart.Data("51", zsi_nros_sem_avg[0].getSem51()));
            seriesX2.getData().add(new XYChart.Data("52", zsi_nros_sem_avg[0].getSem52()));
            seriesX2.getData().add(new XYChart.Data("53", zsi_nros_sem_avg[0].getSem53()));

            
            seriesX3.setName("Xm");
            seriesX3.getData().add(new XYChart.Data("2", Xm));
            seriesX3.getData().add(new XYChart.Data("3", Xm));
            seriesX3.getData().add(new XYChart.Data("4", Xm));
            seriesX3.getData().add(new XYChart.Data("5", Xm));
            seriesX3.getData().add(new XYChart.Data("6", Xm));
            seriesX3.getData().add(new XYChart.Data("7", Xm));
            seriesX3.getData().add(new XYChart.Data("8", Xm));
            seriesX3.getData().add(new XYChart.Data("9", Xm));
            seriesX3.getData().add(new XYChart.Data("10", Xm));
            seriesX3.getData().add(new XYChart.Data("11", Xm));
            seriesX3.getData().add(new XYChart.Data("12", Xm));
            seriesX3.getData().add(new XYChart.Data("13", Xm));
            seriesX3.getData().add(new XYChart.Data("14", Xm));
            seriesX3.getData().add(new XYChart.Data("15", Xm));
            seriesX3.getData().add(new XYChart.Data("16", Xm));
            seriesX3.getData().add(new XYChart.Data("17", Xm));
            seriesX3.getData().add(new XYChart.Data("18", Xm));
            seriesX3.getData().add(new XYChart.Data("19", Xm));
            seriesX3.getData().add(new XYChart.Data("20", Xm));
            seriesX3.getData().add(new XYChart.Data("21", Xm));
            seriesX3.getData().add(new XYChart.Data("22", Xm));
            seriesX3.getData().add(new XYChart.Data("23", Xm));
            seriesX3.getData().add(new XYChart.Data("24", Xm));
            seriesX3.getData().add(new XYChart.Data("25", Xm));
            seriesX3.getData().add(new XYChart.Data("26", Xm));
            seriesX3.getData().add(new XYChart.Data("27", Xm));
            seriesX3.getData().add(new XYChart.Data("28", Xm));
            seriesX3.getData().add(new XYChart.Data("29", Xm));
            seriesX3.getData().add(new XYChart.Data("30", Xm));
            seriesX3.getData().add(new XYChart.Data("31", Xm));
            seriesX3.getData().add(new XYChart.Data("32", Xm));
            seriesX3.getData().add(new XYChart.Data("33", Xm));
            seriesX3.getData().add(new XYChart.Data("34", Xm));
            seriesX3.getData().add(new XYChart.Data("35", Xm));
            seriesX3.getData().add(new XYChart.Data("36", Xm));
            seriesX3.getData().add(new XYChart.Data("37", Xm));
            seriesX3.getData().add(new XYChart.Data("38", Xm));
            seriesX3.getData().add(new XYChart.Data("39", Xm));
            seriesX3.getData().add(new XYChart.Data("40", Xm));
            seriesX3.getData().add(new XYChart.Data("41", Xm));
            seriesX3.getData().add(new XYChart.Data("42", Xm));
            seriesX3.getData().add(new XYChart.Data("43", Xm));
            seriesX3.getData().add(new XYChart.Data("44", Xm));
            seriesX3.getData().add(new XYChart.Data("45", Xm));
            seriesX3.getData().add(new XYChart.Data("46", Xm));
            seriesX3.getData().add(new XYChart.Data("47", Xm));
            seriesX3.getData().add(new XYChart.Data("48", Xm));
            seriesX3.getData().add(new XYChart.Data("49", Xm));
            seriesX3.getData().add(new XYChart.Data("50", Xm));
            seriesX3.getData().add(new XYChart.Data("51", Xm));
            seriesX3.getData().add(new XYChart.Data("52", Xm));
            seriesX3.getData().add(new XYChart.Data("53", Xm));


            seriesX4.setName("LCI");
            seriesX4.getData().add(new XYChart.Data("2", lciX));
            seriesX4.getData().add(new XYChart.Data("3", lciX));
            seriesX4.getData().add(new XYChart.Data("4", lciX));
            seriesX4.getData().add(new XYChart.Data("5", lciX));
            seriesX4.getData().add(new XYChart.Data("6", lciX));
            seriesX4.getData().add(new XYChart.Data("7", lciX));
            seriesX4.getData().add(new XYChart.Data("8", lciX));
            seriesX4.getData().add(new XYChart.Data("9", lciX));
            seriesX4.getData().add(new XYChart.Data("10", lciX));
            seriesX4.getData().add(new XYChart.Data("11", lciX));
            seriesX4.getData().add(new XYChart.Data("12", lciX));
            seriesX4.getData().add(new XYChart.Data("13", lciX));
            seriesX4.getData().add(new XYChart.Data("14", lciX));
            seriesX4.getData().add(new XYChart.Data("15", lciX));
            seriesX4.getData().add(new XYChart.Data("16", lciX));
            seriesX4.getData().add(new XYChart.Data("17", lciX));
            seriesX4.getData().add(new XYChart.Data("18", lciX));
            seriesX4.getData().add(new XYChart.Data("19", lciX));
            seriesX4.getData().add(new XYChart.Data("20", lciX));
            seriesX4.getData().add(new XYChart.Data("21", lciX));
            seriesX4.getData().add(new XYChart.Data("22", lciX));
            seriesX4.getData().add(new XYChart.Data("23", lciX));
            seriesX4.getData().add(new XYChart.Data("24", lciX));
            seriesX4.getData().add(new XYChart.Data("25", lciX));
            seriesX4.getData().add(new XYChart.Data("26", lciX));
            seriesX4.getData().add(new XYChart.Data("27", lciX));
            seriesX4.getData().add(new XYChart.Data("28", lciX));
            seriesX4.getData().add(new XYChart.Data("29", lciX));
            seriesX4.getData().add(new XYChart.Data("30", lciX));
            seriesX4.getData().add(new XYChart.Data("31", lciX));
            seriesX4.getData().add(new XYChart.Data("32", lciX));
            seriesX4.getData().add(new XYChart.Data("33", lciX));
            seriesX4.getData().add(new XYChart.Data("34", lciX));
            seriesX4.getData().add(new XYChart.Data("35", lciX));
            seriesX4.getData().add(new XYChart.Data("36", lciX));
            seriesX4.getData().add(new XYChart.Data("37", lciX));
            seriesX4.getData().add(new XYChart.Data("38", lciX));
            seriesX4.getData().add(new XYChart.Data("39", lciX));
            seriesX4.getData().add(new XYChart.Data("40", lciX));
            seriesX4.getData().add(new XYChart.Data("41", lciX));
            seriesX4.getData().add(new XYChart.Data("42", lciX));
            seriesX4.getData().add(new XYChart.Data("43", lciX));
            seriesX4.getData().add(new XYChart.Data("44", lciX));
            seriesX4.getData().add(new XYChart.Data("45", lciX));
            seriesX4.getData().add(new XYChart.Data("46", lciX));
            seriesX4.getData().add(new XYChart.Data("47", lciX));
            seriesX4.getData().add(new XYChart.Data("48", lciX));
            seriesX4.getData().add(new XYChart.Data("49", lciX));
            seriesX4.getData().add(new XYChart.Data("50", lciX));
            seriesX4.getData().add(new XYChart.Data("51", lciX));
            seriesX4.getData().add(new XYChart.Data("52", lciX));
            seriesX4.getData().add(new XYChart.Data("53", lciX));

            lc_grax.getData().addAll(seriesX1, seriesX2, seriesX3, seriesX4);



            lc_grar.getData().clear();

            seriesR1.setName("LCS");
            seriesR1.getData().add(new XYChart.Data("2", lcsR));
            seriesR1.getData().add(new XYChart.Data("3", lcsR));
            seriesR1.getData().add(new XYChart.Data("4", lcsR));
            seriesR1.getData().add(new XYChart.Data("5", lcsR));
            seriesR1.getData().add(new XYChart.Data("6", lcsR));
            seriesR1.getData().add(new XYChart.Data("7", lcsR));
            seriesR1.getData().add(new XYChart.Data("8", lcsR));
            seriesR1.getData().add(new XYChart.Data("9", lcsR));
            seriesR1.getData().add(new XYChart.Data("10", lcsR));
            seriesR1.getData().add(new XYChart.Data("11", lcsR));
            seriesR1.getData().add(new XYChart.Data("12", lcsR));
            seriesR1.getData().add(new XYChart.Data("13", lcsR));
            seriesR1.getData().add(new XYChart.Data("14", lcsR));
            seriesR1.getData().add(new XYChart.Data("15", lcsR));
            seriesR1.getData().add(new XYChart.Data("16", lcsR));
            seriesR1.getData().add(new XYChart.Data("17", lcsR));
            seriesR1.getData().add(new XYChart.Data("18", lcsR));
            seriesR1.getData().add(new XYChart.Data("19", lcsR));
            seriesR1.getData().add(new XYChart.Data("20", lcsR));
            seriesR1.getData().add(new XYChart.Data("21", lcsR));
            seriesR1.getData().add(new XYChart.Data("22", lcsR));
            seriesR1.getData().add(new XYChart.Data("23", lcsR));
            seriesR1.getData().add(new XYChart.Data("24", lcsR));
            seriesR1.getData().add(new XYChart.Data("25", lcsR));
            seriesR1.getData().add(new XYChart.Data("26", lcsR));
            seriesR1.getData().add(new XYChart.Data("27", lcsR));
            seriesR1.getData().add(new XYChart.Data("28", lcsR));
            seriesR1.getData().add(new XYChart.Data("29", lcsR));
            seriesR1.getData().add(new XYChart.Data("30", lcsR));
            seriesR1.getData().add(new XYChart.Data("31", lcsR));
            seriesR1.getData().add(new XYChart.Data("32", lcsR));
            seriesR1.getData().add(new XYChart.Data("33", lcsR));
            seriesR1.getData().add(new XYChart.Data("34", lcsR));
            seriesR1.getData().add(new XYChart.Data("35", lcsR));
            seriesR1.getData().add(new XYChart.Data("36", lcsR));
            seriesR1.getData().add(new XYChart.Data("37", lcsR));
            seriesR1.getData().add(new XYChart.Data("38", lcsR));
            seriesR1.getData().add(new XYChart.Data("39", lcsR));
            seriesR1.getData().add(new XYChart.Data("40", lcsR));
            seriesR1.getData().add(new XYChart.Data("41", lcsR));
            seriesR1.getData().add(new XYChart.Data("42", lcsR));
            seriesR1.getData().add(new XYChart.Data("43", lcsR));
            seriesR1.getData().add(new XYChart.Data("44", lcsR));
            seriesR1.getData().add(new XYChart.Data("45", lcsR));
            seriesR1.getData().add(new XYChart.Data("46", lcsR));
            seriesR1.getData().add(new XYChart.Data("47", lcsR));
            seriesR1.getData().add(new XYChart.Data("48", lcsR));
            seriesR1.getData().add(new XYChart.Data("49", lcsR));
            seriesR1.getData().add(new XYChart.Data("50", lcsR));
            seriesR1.getData().add(new XYChart.Data("51", lcsR));
            seriesR1.getData().add(new XYChart.Data("52", lcsR));
            seriesR1.getData().add(new XYChart.Data("53", lcsR));

            seriesR2.setName("R");
            seriesR2.getData().add(new XYChart.Data("2", zsi_nros_sem_r[0].getSem02()));
            seriesR2.getData().add(new XYChart.Data("3", zsi_nros_sem_r[0].getSem03()));
            seriesR2.getData().add(new XYChart.Data("4", zsi_nros_sem_r[0].getSem04()));
            seriesR2.getData().add(new XYChart.Data("5", zsi_nros_sem_r[0].getSem05()));
            seriesR2.getData().add(new XYChart.Data("6", zsi_nros_sem_r[0].getSem06()));
            seriesR2.getData().add(new XYChart.Data("7", zsi_nros_sem_r[0].getSem07()));
            seriesR2.getData().add(new XYChart.Data("8", zsi_nros_sem_r[0].getSem08()));
            seriesR2.getData().add(new XYChart.Data("9", zsi_nros_sem_r[0].getSem09()));
            seriesR2.getData().add(new XYChart.Data("10", zsi_nros_sem_r[0].getSem10()));
            seriesR2.getData().add(new XYChart.Data("11", zsi_nros_sem_r[0].getSem11()));
            seriesR2.getData().add(new XYChart.Data("12", zsi_nros_sem_r[0].getSem12()));
            seriesR2.getData().add(new XYChart.Data("13", zsi_nros_sem_r[0].getSem13()));
            seriesR2.getData().add(new XYChart.Data("14", zsi_nros_sem_r[0].getSem14()));
            seriesR2.getData().add(new XYChart.Data("15", zsi_nros_sem_r[0].getSem15()));
            seriesR2.getData().add(new XYChart.Data("16", zsi_nros_sem_r[0].getSem16()));
            seriesR2.getData().add(new XYChart.Data("17", zsi_nros_sem_r[0].getSem17()));
            seriesR2.getData().add(new XYChart.Data("18", zsi_nros_sem_r[0].getSem18()));
            seriesR2.getData().add(new XYChart.Data("19", zsi_nros_sem_r[0].getSem19()));
            seriesR2.getData().add(new XYChart.Data("20", zsi_nros_sem_r[0].getSem20()));
            seriesR2.getData().add(new XYChart.Data("21", zsi_nros_sem_r[0].getSem21()));
            seriesR2.getData().add(new XYChart.Data("22", zsi_nros_sem_r[0].getSem22()));
            seriesR2.getData().add(new XYChart.Data("23", zsi_nros_sem_r[0].getSem23()));
            seriesR2.getData().add(new XYChart.Data("24", zsi_nros_sem_r[0].getSem24()));
            seriesR2.getData().add(new XYChart.Data("25", zsi_nros_sem_r[0].getSem25()));
            seriesR2.getData().add(new XYChart.Data("26", zsi_nros_sem_r[0].getSem26()));
            seriesR2.getData().add(new XYChart.Data("27", zsi_nros_sem_r[0].getSem27()));
            seriesR2.getData().add(new XYChart.Data("28", zsi_nros_sem_r[0].getSem28()));
            seriesR2.getData().add(new XYChart.Data("29", zsi_nros_sem_r[0].getSem29()));
            seriesR2.getData().add(new XYChart.Data("30", zsi_nros_sem_r[0].getSem30()));
            seriesR2.getData().add(new XYChart.Data("31", zsi_nros_sem_r[0].getSem31()));
            seriesR2.getData().add(new XYChart.Data("32", zsi_nros_sem_r[0].getSem32()));
            seriesR2.getData().add(new XYChart.Data("33", zsi_nros_sem_r[0].getSem33()));
            seriesR2.getData().add(new XYChart.Data("34", zsi_nros_sem_r[0].getSem34()));
            seriesR2.getData().add(new XYChart.Data("35", zsi_nros_sem_r[0].getSem35()));
            seriesR2.getData().add(new XYChart.Data("36", zsi_nros_sem_r[0].getSem36()));
            seriesR2.getData().add(new XYChart.Data("37", zsi_nros_sem_r[0].getSem37()));
            seriesR2.getData().add(new XYChart.Data("38", zsi_nros_sem_r[0].getSem38()));
            seriesR2.getData().add(new XYChart.Data("39", zsi_nros_sem_r[0].getSem39()));
            seriesR2.getData().add(new XYChart.Data("40", zsi_nros_sem_r[0].getSem40()));
            seriesR2.getData().add(new XYChart.Data("41", zsi_nros_sem_r[0].getSem41()));
            seriesR2.getData().add(new XYChart.Data("42", zsi_nros_sem_r[0].getSem42()));
            seriesR2.getData().add(new XYChart.Data("43", zsi_nros_sem_r[0].getSem43()));
            seriesR2.getData().add(new XYChart.Data("44", zsi_nros_sem_r[0].getSem44()));
            seriesR2.getData().add(new XYChart.Data("45", zsi_nros_sem_r[0].getSem45()));
            seriesR2.getData().add(new XYChart.Data("46", zsi_nros_sem_r[0].getSem46()));
            seriesR2.getData().add(new XYChart.Data("47", zsi_nros_sem_r[0].getSem47()));
            seriesR2.getData().add(new XYChart.Data("48", zsi_nros_sem_r[0].getSem48()));
            seriesR2.getData().add(new XYChart.Data("49", zsi_nros_sem_r[0].getSem49()));
            seriesR2.getData().add(new XYChart.Data("50", zsi_nros_sem_r[0].getSem50()));
            seriesR2.getData().add(new XYChart.Data("51", zsi_nros_sem_r[0].getSem51()));
            seriesR2.getData().add(new XYChart.Data("52", zsi_nros_sem_r[0].getSem52()));
            seriesR2.getData().add(new XYChart.Data("53", zsi_nros_sem_r[0].getSem53()));
            
            seriesR3.setName("Rm");
            seriesR3.getData().add(new XYChart.Data("2", Rm));
            seriesR3.getData().add(new XYChart.Data("3", Rm));
            seriesR3.getData().add(new XYChart.Data("4", Rm));
            seriesR3.getData().add(new XYChart.Data("5", Rm));
            seriesR3.getData().add(new XYChart.Data("6", Rm));
            seriesR3.getData().add(new XYChart.Data("7", Rm));
            seriesR3.getData().add(new XYChart.Data("8", Rm));
            seriesR3.getData().add(new XYChart.Data("9", Rm));
            seriesR3.getData().add(new XYChart.Data("10", Rm));
            seriesR3.getData().add(new XYChart.Data("11", Rm));
            seriesR3.getData().add(new XYChart.Data("12", Rm));
            seriesR3.getData().add(new XYChart.Data("13", Rm));
            seriesR3.getData().add(new XYChart.Data("14", Rm));
            seriesR3.getData().add(new XYChart.Data("15", Rm));
            seriesR3.getData().add(new XYChart.Data("16", Rm));
            seriesR3.getData().add(new XYChart.Data("17", Rm));
            seriesR3.getData().add(new XYChart.Data("18", Rm));
            seriesR3.getData().add(new XYChart.Data("19", Rm));
            seriesR3.getData().add(new XYChart.Data("20", Rm));
            seriesR3.getData().add(new XYChart.Data("21", Rm));
            seriesR3.getData().add(new XYChart.Data("22", Rm));
            seriesR3.getData().add(new XYChart.Data("23", Rm));
            seriesR3.getData().add(new XYChart.Data("24", Rm));
            seriesR3.getData().add(new XYChart.Data("25", Rm));
            seriesR3.getData().add(new XYChart.Data("26", Rm));
            seriesR3.getData().add(new XYChart.Data("27", Rm));
            seriesR3.getData().add(new XYChart.Data("28", Rm));
            seriesR3.getData().add(new XYChart.Data("29", Rm));
            seriesR3.getData().add(new XYChart.Data("30", Rm));
            seriesR3.getData().add(new XYChart.Data("31", Rm));
            seriesR3.getData().add(new XYChart.Data("32", Rm));
            seriesR3.getData().add(new XYChart.Data("33", Rm));
            seriesR3.getData().add(new XYChart.Data("34", Rm));
            seriesR3.getData().add(new XYChart.Data("35", Rm));
            seriesR3.getData().add(new XYChart.Data("36", Rm));
            seriesR3.getData().add(new XYChart.Data("37", Rm));
            seriesR3.getData().add(new XYChart.Data("38", Rm));
            seriesR3.getData().add(new XYChart.Data("39", Rm));
            seriesR3.getData().add(new XYChart.Data("40", Rm));
            seriesR3.getData().add(new XYChart.Data("41", Rm));
            seriesR3.getData().add(new XYChart.Data("42", Rm));
            seriesR3.getData().add(new XYChart.Data("43", Rm));
            seriesR3.getData().add(new XYChart.Data("44", Rm));
            seriesR3.getData().add(new XYChart.Data("45", Rm));
            seriesR3.getData().add(new XYChart.Data("46", Rm));
            seriesR3.getData().add(new XYChart.Data("47", Rm));
            seriesR3.getData().add(new XYChart.Data("48", Rm));
            seriesR3.getData().add(new XYChart.Data("49", Rm));
            seriesR3.getData().add(new XYChart.Data("50", Rm));
            seriesR3.getData().add(new XYChart.Data("51", Rm));
            seriesR3.getData().add(new XYChart.Data("52", Rm));
            seriesR3.getData().add(new XYChart.Data("53", Rm));

            seriesR4.setName("LCI");
            seriesR4.getData().add(new XYChart.Data("2", lciR));
            seriesR4.getData().add(new XYChart.Data("3", lciR));
            seriesR4.getData().add(new XYChart.Data("4", lciR));
            seriesR4.getData().add(new XYChart.Data("5", lciR));
            seriesR4.getData().add(new XYChart.Data("6", lciR));
            seriesR4.getData().add(new XYChart.Data("7", lciR));
            seriesR4.getData().add(new XYChart.Data("8", lciR));
            seriesR4.getData().add(new XYChart.Data("9", lciR));
            seriesR4.getData().add(new XYChart.Data("10", lciR));
            seriesR4.getData().add(new XYChart.Data("11", lciR));
            seriesR4.getData().add(new XYChart.Data("12", lciR));
            seriesR4.getData().add(new XYChart.Data("13", lciR));
            seriesR4.getData().add(new XYChart.Data("14", lciR));
            seriesR4.getData().add(new XYChart.Data("15", lciR));
            seriesR4.getData().add(new XYChart.Data("16", lciR));
            seriesR4.getData().add(new XYChart.Data("17", lciR));
            seriesR4.getData().add(new XYChart.Data("18", lciR));
            seriesR4.getData().add(new XYChart.Data("19", lciR));
            seriesR4.getData().add(new XYChart.Data("20", lciR));
            seriesR4.getData().add(new XYChart.Data("21", lciR));
            seriesR4.getData().add(new XYChart.Data("22", lciR));
            seriesR4.getData().add(new XYChart.Data("23", lciR));
            seriesR4.getData().add(new XYChart.Data("24", lciR));
            seriesR4.getData().add(new XYChart.Data("25", lciR));
            seriesR4.getData().add(new XYChart.Data("26", lciR));
            seriesR4.getData().add(new XYChart.Data("27", lciR));
            seriesR4.getData().add(new XYChart.Data("28", lciR));
            seriesR4.getData().add(new XYChart.Data("29", lciR));
            seriesR4.getData().add(new XYChart.Data("30", lciR));
            seriesR4.getData().add(new XYChart.Data("31", lciR));
            seriesR4.getData().add(new XYChart.Data("32", lciR));
            seriesR4.getData().add(new XYChart.Data("33", lciR));
            seriesR4.getData().add(new XYChart.Data("34", lciR));
            seriesR4.getData().add(new XYChart.Data("35", lciR));
            seriesR4.getData().add(new XYChart.Data("36", lciR));
            seriesR4.getData().add(new XYChart.Data("37", lciR));
            seriesR4.getData().add(new XYChart.Data("38", lciR));
            seriesR4.getData().add(new XYChart.Data("39", lciR));
            seriesR4.getData().add(new XYChart.Data("40", lciR));
            seriesR4.getData().add(new XYChart.Data("41", lciR));
            seriesR4.getData().add(new XYChart.Data("42", lciR));
            seriesR4.getData().add(new XYChart.Data("43", lciR));
            seriesR4.getData().add(new XYChart.Data("44", lciR));
            seriesR4.getData().add(new XYChart.Data("45", lciR));
            seriesR4.getData().add(new XYChart.Data("46", lciR));
            seriesR4.getData().add(new XYChart.Data("47", lciR));
            seriesR4.getData().add(new XYChart.Data("48", lciR));
            seriesR4.getData().add(new XYChart.Data("49", lciR));
            seriesR4.getData().add(new XYChart.Data("50", lciR));
            seriesR4.getData().add(new XYChart.Data("51", lciR));
            seriesR4.getData().add(new XYChart.Data("52", lciR));
            seriesR4.getData().add(new XYChart.Data("53", lciR));

            lc_grar.getData().addAll(seriesR1, seriesR2, seriesR3, seriesR4);
        });
    }   

    /***************************************************************************/
    /********************** METODOS DE INTERFAZ GRAFICA ************************/
    /***************************************************************************/
    /**
     * Metodo que establece el estado grafico del formulario, y mueve la tabla de datos
     * de posicion vertical
     * @param value TRUE si el formulario es Visible
     */
    private void setFormVisible(boolean value){
        vb_form.setVisible(value);  //Establece el estado grafico del formulario
//        if(value){  //Si el estado es visible entonces 
//            vb_table.relocate(25, 439);
//            vb_table.setPrefHeight(133);
//        }else{
//            vb_table.relocate(25, 64);
//            vb_table.setPrefHeight(508);
//        }
    }           
    /**
     * Metodo que establece el valor maximo y minimo de cada columna una tabla
     * @param col Columna que va a ser Configurada
     * @param min Valor minimo del ancho de la Columna
     * @param max Valor maximo del ancho de la Columna
     */
    private void objectWidth(TableColumn col,int min,int max){
        col.setMinWidth(min);   //Establece el valor minimo
        col.setMaxWidth(max);   //Establece el valor maximo
    }
    /** @return plotted y values for monotonically increasing integer x values, starting from x=1 */
    public ObservableList<XYChart.Data<Integer, Integer>> plot(int... y) {
        final ObservableList<XYChart.Data<Integer, Integer>> dataset = FXCollections.observableArrayList();
        int i = 0;
        while (i < y.length) {
            final XYChart.Data<Integer, Integer> data = new XYChart.Data<>(i + 1, y[i]);
            data.setNode(
                new HoveredThresholdNode(
                    (i == 0) ? 0 : y[i-1],
                    y[i]
                )
            );

            dataset.add(data);
            i++;
        }

        return dataset;
    }
    /** a node which displays a value on hover, but is otherwise empty */
    class HoveredThresholdNode extends StackPane {
        HoveredThresholdNode(int priorValue, int value) {
            setPrefSize(15, 15);

            final Label label = createDataThresholdLabel(priorValue, value);

            setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override 
                public void handle(MouseEvent mouseEvent) {
                    getChildren().setAll(label);
                    setCursor(Cursor.NONE);
                    toFront();
                }
            });
            
            setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override 
                public void handle(MouseEvent mouseEvent) {
                    getChildren().clear();
                    setCursor(Cursor.CROSSHAIR);
                }
            });
        }

        private Label createDataThresholdLabel(int priorValue, int value) {
            final Label label = new Label(value + "");
            label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
            label.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

            if (priorValue == 0) {
                label.setTextFill(Color.DARKGRAY);
            } 
            else if (value > priorValue) {
                label.setTextFill(Color.FORESTGREEN);
            } 
            else {
                label.setTextFill(Color.FIREBRICK);
            }

            label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
            return label;
        }
    }
}    
