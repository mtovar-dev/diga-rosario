/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Indicators;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.Reports.Dev_FaltCarga;
import Tools.Datos;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
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
    private Label lb_lcs;

    @FXML
    private Label lb_lci;

    @FXML
    private Label lb_Xm;

    @FXML
    private Label lb_Rm;

    @FXML
    private LineChart<String,Number> lc_grax;
    
    @FXML
    private LineChart<?, ?> lc_grar;
    
    @FXML
    private Slider sl_semf;

    @FXML
    private Slider sl_semi;
    
    @FXML
    private TableView<?> tb_query;

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
    
    private static final ObservableList<Dev_FaltCarga> sqlQuery = FXCollections.observableArrayList();

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
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Rep_FaltCargaController.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons(); //Establece los comportamientos de los botones

        loadYear();      
//        createTableQuery();

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
    private void createTableQuery(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_orden       = new TableColumn("#");
        TableColumn col_guia         = new TableColumn("G.Falt");
        TableColumn col_fecha       = new TableColumn("Fecha");        
        TableColumn col_nombre      = new TableColumn("Nombre del Chofer");        
        TableColumn col_numrela     = new TableColumn("Nro. Relación");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_orden          , 36,   36);  
        this.objectWidth(col_guia           , 60,   60); 
        this.objectWidth(col_fecha          , 80,   80);  
        this.objectWidth(col_nombre         , 290,  290);  
        this.objectWidth(col_numrela        , 90,   90);  

        col_guia.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Dev_FaltCarga, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_fecha.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Dev_FaltCarga, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        

        col_numrela.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Dev_FaltCarga, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setAlignment(Pos.CENTER);
                    }

                    private String getString() {
                        String ret = "";
                        if (getItem() != null) {
                            ret = getItem().toString();
                            if (ret.equals("0"))
                                ret = "";
                        } else {
                            ret = "";
                        }
                        return ret;
                    }                
                };
            }
        });        


        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_orden.setCellValueFactory( 
                new PropertyValueFactory<>("numorden") );
        col_guia.setCellValueFactory( 
                new PropertyValueFactory<>("guiafalt") );
        col_fecha.setCellValueFactory( 
                new PropertyValueFactory<>("fecha") );
        col_nombre.setCellValueFactory( 
                new PropertyValueFactory<>("chofer") );
        col_numrela.setCellValueFactory( 
                new PropertyValueFactory<>("numrela") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_query.getColumns().addAll(
                col_orden, col_guia, col_fecha, col_nombre, col_numrela
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
        tb_query.setOnKeyReleased(eh);    
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
    private void loadTableQuery(Dev_FaltCarga[] sqlQuery){    
        if(sqlQuery != null){
            ObservableList<Dev_FaltCarga> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(sqlQuery));        
//            tb_query.setItems(data);        
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
        /**
         * BOTON EXECUTE
         */
        bt_aceptar.setOnAction((ActionEvent event) -> {
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();

            xAxis.setLabel("Semanas");       

//            final LineChart<String,Number> lineChart = 
//                    new LineChart<String,Number>(xAxis,yAxis);

//            lc_grax = new LineChart<String,Number>(xAxis,yAxis);
            
            lc_grax.setTitle("Guias Pendientes / Semana");

            
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("LCS");
            series1.getData().add(new XYChart.Data("29", 1995.74));
            series1.getData().add(new XYChart.Data("30", 1995.74));
            series1.getData().add(new XYChart.Data("31", 1995.74));
            series1.getData().add(new XYChart.Data("32", 1995.74));
            series1.getData().add(new XYChart.Data("33", 1995.74));
            series1.getData().add(new XYChart.Data("34", 1995.74));
            series1.getData().add(new XYChart.Data("35", 1995.74));
            series1.getData().add(new XYChart.Data("36", 1995.74));
            series1.getData().add(new XYChart.Data("37", 1995.74));
            series1.getData().add(new XYChart.Data("38", 1995.74));
            series1.getData().add(new XYChart.Data("39", 1995.74));
            series1.getData().add(new XYChart.Data("40", 1995.74));

            
            XYChart.Series series2 = new XYChart.Series();
            series2.setName("X");
            series2.getData().add(new XYChart.Data("29", 1257));
            series2.getData().add(new XYChart.Data("30", 1140));
            series2.getData().add(new XYChart.Data("31", 1235));
            series2.getData().add(new XYChart.Data("32", 1258));
            series2.getData().add(new XYChart.Data("33", 955));
            series2.getData().add(new XYChart.Data("34", 970));
            series2.getData().add(new XYChart.Data("35", 1552));
            series2.getData().add(new XYChart.Data("36", 1145));
            series2.getData().add(new XYChart.Data("37", 992));
            series2.getData().add(new XYChart.Data("38", 1017));
            series2.getData().add(new XYChart.Data("39", 1019));
            series2.getData().add(new XYChart.Data("40", 771));


            XYChart.Series series3 = new XYChart.Series();
            series3.setName("Xm");
            series3.getData().add(new XYChart.Data("29", 1153));
            series3.getData().add(new XYChart.Data("30", 1153));
            series3.getData().add(new XYChart.Data("31", 1153));
            series3.getData().add(new XYChart.Data("32", 1153));
            series3.getData().add(new XYChart.Data("33", 1153));
            series3.getData().add(new XYChart.Data("34", 1153));
            series3.getData().add(new XYChart.Data("35", 1153));
            series3.getData().add(new XYChart.Data("36", 1153));
            series3.getData().add(new XYChart.Data("37", 1153));
            series3.getData().add(new XYChart.Data("38", 1153));
            series3.getData().add(new XYChart.Data("39", 1153));
            series3.getData().add(new XYChart.Data("40", 1153));


            XYChart.Series series4 = new XYChart.Series();
            series4.setName("LCI");
            series4.getData().add(new XYChart.Data("29", 310.26));
            series4.getData().add(new XYChart.Data("30", 310.26));
            series4.getData().add(new XYChart.Data("31", 310.26));
            series4.getData().add(new XYChart.Data("32", 310.26));
            series4.getData().add(new XYChart.Data("33", 310.26));
            series4.getData().add(new XYChart.Data("34", 310.26));
            series4.getData().add(new XYChart.Data("35", 310.26));
            series4.getData().add(new XYChart.Data("36", 310.26));
            series4.getData().add(new XYChart.Data("37", 310.26));
            series4.getData().add(new XYChart.Data("38", 310.26));
            series4.getData().add(new XYChart.Data("39", 310.26));
            series4.getData().add(new XYChart.Data("40", 310.26));

            lc_grax.getData().addAll(series1, series2, series3, series4);
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
//            vb_table.relocate(30, 439);
//            vb_table.setPrefHeight(133);
//        }else{
//            vb_table.relocate(30, 64);
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
    
}
