/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Rrhh;
import GUI.Gui;
import LN.Ln;
import Objects.Infocent.Asignacion;
import Objects.Infocent.Concepto;
import Objects.Infocent.Deduccion;
import Objects.Infocent.Empleado;
import Objects.Infocent.Empresa;
import Objects.Infocent.InfocentTableData;
import Objects.Infocent.Mes;
import Objects.Infocent.Reporte;
import Tools.Datos;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author armgarces
 */
public class Fxml_AuditoriaRrhhController implements Initializable {
    //RAIZ
    @FXML
    private AnchorPane ap_root;
    //ETIQUETAS
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private Label lb5;
    @FXML
    private Label lb6;
    @FXML
    private Label lb_param1;
    @FXML
    private Label lb_param2;
    @FXML
    private Label lb_param3;
    @FXML
    private Label lb_Title;
    @FXML
    private Label lb_screen;
    @FXML
    private Label lb_proceso;
    @FXML
    private Label lb_concepto;
    //TABLAS
    @FXML
    private TableView<Asignacion> tb_table1;
    @FXML
    private TableView<Deduccion> tb_table2;
    //CAMPOS DE DATOS
    @FXML
    private TextField tf_buscar;
    @FXML
    private TextField tf_cedula;
    //IMAGENES
    @FXML
    private ImageView im_tool1;
    @FXML
    private ImageView im_tool2;
    @FXML
    private ImageView im_tool3;
    @FXML
    private ImageView im_tool4;
    @FXML
    private ImageView im_tool5;
    @FXML
    private ImageView im_tool6;
    @FXML
    private ImageView im_tool7;
    @FXML
    private ImageView im_tool8;
    @FXML
    private ImageView im_tool9;
    @FXML
    private ImageView im_tool10;
    @FXML
    private ImageView im_tool11;
    @FXML
    private ImageView im_tool12;
    //ORGANIZADORES VERTICALES
    @FXML
    private VBox vb_1;
    @FXML
    private VBox vb_table;
    //ORGANIZADORES HORIZONTALES
    @FXML
    private HBox hb_1;
    @FXML
    private HBox hb_2;
    @FXML
    private HBox hb_3;
    @FXML
    private HBox hb_4;
    @FXML
    private HBox hbox_toolbar;
    //LISTAS DESPLEGABLES
    @FXML
    private ChoiceBox<Empresa> cb_empresa;
    @FXML
    private ChoiceBox<Mes> cb_mes;
    @FXML
    private ChoiceBox<Integer> cb_ano;
    @FXML
    private ChoiceBox<Empleado> cb_ficha;
    @FXML
    private ChoiceBox<Integer> cb_proceso;
    @FXML
    private ChoiceBox<Integer> cb_periodos;
    @FXML
    private ChoiceBox<Reporte> cb_reporte;
    @FXML
    private ChoiceBox<String> cb_nomina;  
    @FXML
    private ChoiceBox<Concepto> cb_concepto;
    //OTROS TIPOS DE DATOS
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;
    private static final String ScreenName = "Auditoria";
    public static int cont;
    /**
     * Reimplementacion del metodo de Inicializacion de la pantalla
     * @param fxmlFileLocation
     * @param resources 
     */
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {                    
        defineToolBar();        //Inicializa la Barra de Herramientas
        defineButtons();         //Establece los comportamientos de los botones
        setCurrentOperation();
        initializeReportes();
        loadTables();
        searchData();        
    }  
    /**
     * Inicializacion de la pantalla
     */
    private void initializeReportes(){
        cont = 0;
        loadReportes();
        loadMes();
        loadAño();      
        loadEmpresas();
        DisableFields(1);
        //definicion del comportamiento de los ChoiceBox para cuando se cambie el item seleccionado
        cb_reporte.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Reporte>() {
            @Override
            public void changed(ObservableValue<? extends Reporte> observable, Reporte oldValue, Reporte newValue) {
                cont++;
                if(cont == 1){
                    DisableFields(newValue.getId());
                    reporteChanged(newValue.getId());
                    searchData();                    
                }
                cont--;
            }
        });      
        cb_empresa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Empresa>() {
            @Override
            public void changed(ObservableValue<? extends Empresa> observable, Empresa oldValue, Empresa newValue) {
                cont++;
                if(cont == 1){
                    empresaChanged(newValue);
                    searchData();
                }
                cont--;
            }
        });
                
        cb_mes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Mes>() {
            @Override
            public void changed(ObservableValue<? extends Mes> observable, Mes oldValue, Mes newValue) {
                cont++;
                if(cont == 1){
                    anoChanged();
                    searchData();
                }
                cont--;
            }
        });
        cb_ano.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                cont++;
                if(cont == 1){
                    anoChanged();
                    searchData();
                }
                cont--;
            }
        });
        cb_ficha.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Empleado>() {
            @Override
            public void changed(ObservableValue<? extends Empleado> observable, Empleado oldValue, Empleado newValue) {                
                cont++;
                if(cont == 1){
                    searchData();
                }
                cont--;
            }
        });
        cb_periodos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                cont++;
                if(cont == 1){
                    searchData();
                }
                cont--;
            }
        });
        cb_nomina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cont++;
                if(cont == 1){
                    nominaChanged(newValue);
                    searchData();
                }
                cont--;
            }
        });
        cb_proceso.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                cont++;
                if(cont == 1){
                    procesoChanged(newValue);   
                    searchData();
                }
                cont--;
            }
        });
        cb_concepto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Concepto>() {
            @Override
            public void changed(ObservableValue<? extends Concepto> observable, Concepto oldValue, Concepto newValue) {                
                cont++;
                if(cont == 1){
                    searchData();
                }
                cont--;
            }
        });
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
        tools = new ImageView[]{im_tool1,im_tool2,im_tool3,im_tool4,im_tool6,im_tool7,im_tool8,im_tool5,im_tool9,im_tool10,im_tool11,im_tool12};        
        //CARGA DE LA BD LA CONFIGURACION DE USUARIO PARA LA PANTALLA
        toolsConfig = Ln.getInstance().loadToolBar();
        // arreglo con cada etiqueta, ordenado por boton
        tooltips = new String[]{
            "Nuevo " + ScreenName + " ",
            "Editar " + ScreenName + " ",
            "Guardar " + ScreenName + " ",
            "Cambiar Status " + ScreenName + " ",
            "Imprimir " + ScreenName + " ",
            "Cancelar ",
            "Sin Asignar " + ScreenName + " ",
            "Sin Asignar",
            "Sin Asignar",
            "Sin Asignar",
            "Sin Asignar",
            "Buscar " + ScreenName + " "
            };
        //se asigna la etiqueta a su respectivo boton
        for (int i = 0; i < tools.length; i++) {            
            Tooltip tip_tool = new Tooltip(tooltips[i]);
            Tooltip.install(tools[i], tip_tool);
        }
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
        for (Integer disable : disables) {
            //Recorre todo el arreglo
            //Deshabilita el boton de TOOLS que se encuentra en la posicion disbles[i]
            disableToolBar(tools, disable);  
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
     * Inicializa 
     */
    private void botonInicio() {
        tipoOperacion = 0;                  //OPERACION SOLO LECTURA
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setText("");
        tf_buscar.setVisible(false);
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA
        Gui.getInstance().showPrint(ScreenName + " en Construcción");  
    }
    /**
     * define los botones a ser utilizados en la pnatalla
     */
    private void defineButtons(){
        botonInicio();
        /**
         * BOTON IMPRIMIR DEL TOOLBAR
         */
        im_tool6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //botonImprimir();
                }
            }
        });
        //Definicion del evento de teclado
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //SI es presionado ENTER o TAB entonces
                if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){     
                    //Valida que el evento se haya generado en el campo de busqueda
                    if(((Node)ke.getSource()).getId().equals("tf_cedula")){                        
                        //Solicita las fichas del empleado
                        loadFichas();
                        //Busca los datos
                        int reporte   = cb_reporte.getSelectionModel().getSelectedItem().getId();
                        String cedula = tf_cedula.getText();
                        int mes       = cb_mes.getSelectionModel().getSelectedItem().getNum();
                        int ano       = cb_ano.getSelectionModel().getSelectedItem();
                        if(reporte == 1 && !cedula.isEmpty()){
                            loadPeriodos(cedula, mes, ano);
                        }
                        searchData();
                    }
                }
            }
        };
        //Se asigna el manejador a ejecutarse cuando se suelta una tecla
        tf_cedula.setOnKeyReleased(eh);
    }
    /***************************************************************************/
    /********************** METODOS DE INTERFAZ GRAFICA ************************/
    /***************************************************************************/             
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
    /***************************************************************************/
    /************************ METODOS DE ACCESO RAPIDO *************************/
    /***************************************************************************/      
    
    /***************************************************************************/
    /************************ METODOS CHANGE LISTENERS *************************/ 
    /***************************************************************************/
    /**
     * El Item seleccionado en el ComboBox ha cambiado
     * @param newValue 
     *
    private void mesChanged(Mes ano){
        //Obtiene los valores seleccionados
        int reporte = cb_reporte.getSelectionModel().getSelectedItem().getId();
        int ano     = cb_ano.getSelectionModel().getSelectedItem();
        int mes     = ano.getNum();        
        Empresa empresa;
        String nomina;
        int tipo;
        switch(reporte){
            case 1:     //Reporte 1
                //actualiza los periodos para el nuevo mes
                cb_periodos.getItems().clear();
                loadPeriodos(tf_cedula.getText(),mes, ano);
                break;
            case 4:     //Reporte 4
                //Obtiene los valores seleccionados
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                if(isComboBoxEmpty(cb_nomina)){
                    nomina = cb_nomina.getSelectionModel().getSelectedItem();
                    //actualiza los Tipo de Procesos para el nuevo mes
                    loadProcesosXAno(empresa, nomina, ano);
                }
                break;
            case 6:     //Reporte 6
                //Obtiene los valores seleccionados
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos para el nuevo mes
                loadProcesosXMes(empresa, nomina, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                //loadConceptos(true,empresa, nomina, mes, ano, tipo);
                break;
            case 7:     //Reporte 7
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                //loadConceptos(false,empresa, nomina, mes, ano, tipo);
                break;
        }               
    }
    /**
 El Item seleccionado en el ComboBox ha cambiado
     * @param newValue 
     */
    private void anoChanged(){
        //Obtiene los valores seleccionados
        int reporte = cb_reporte.getSelectionModel().getSelectedItem().getId();
        int mes     = cb_mes.getSelectionModel().getSelectedItem().getNum();
        int ano     = cb_ano.getSelectionModel().getSelectedItem();
        Empresa empresa;
        String nomina;
        int tipo;
        switch(reporte){
            case 1:     //Reporte 1
                cb_periodos.getItems().clear();
                loadPeriodos(tf_cedula.getText(),mes, ano);
                break;
            case 4:     //Reporte 4
                //Obtiene los valores seleccionados
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXAno(empresa, nomina, ano);
                break;                
            case 5:     //Reporte 5
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                break;
            case 6:     //Reporte 6
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                loadConceptos(true,empresa, nomina, mes, ano, tipo);
                break;
            case 7:     //Reporte 7
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                loadConceptos(false,empresa, nomina, mes, ano, tipo);
                break;
        }       
    }    
    /**
     * El Item seleccionado en el ComboBox ha cambiado
     * @param newValue 
     */
    private void empresaChanged(Empresa newValue){
        //Obtiene los valores seleccionados
        int reporte = cb_reporte.getSelectionModel().getSelectedItem().getId();
        int mes     = cb_mes.getSelectionModel().getSelectedItem().getNum();
        int ano     = cb_ano.getSelectionModel().getSelectedItem();
        Empresa empresa = newValue;
        String nomina;
        int tipo;
        switch(reporte){
            case 4:     //Reporte 4
                //Obtiene los valores seleccionados
//                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                System.out.println("nomina = " + nomina);
                //actualiza los Tipo de Procesos
                loadProcesosXAno(empresa, nomina, ano);
                break;                
            case 5:     //Reporte 5
//                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                break;
            case 6:     //Reporte 6
//                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                loadConceptos(true,empresa, nomina, mes, ano, tipo);
                break;
            case 7:     //Reporte 7
//                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                //actualiza las Nominas
                loadNominas(empresa, ano);
                nomina = cb_nomina.getSelectionModel().getSelectedItem();
                //actualiza los Tipo de Procesos
                loadProcesosXMes(empresa, nomina, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                loadConceptos(false,empresa, nomina, mes, ano, tipo);
                break;
        }       
    }
    /**
     * 
     * @param newValue 
     */
    private void reporteChanged(int newValue){
        //Obtiene los valores seleccionados
        int ano     = cb_ano.getSelectionModel().getSelectedItem();       
        Empresa empresa;
        String nomina;
        int tipo;
        int mes;
        switch(newValue){
            case 1:     //Reporte 1
                //actualiza los periodos para el nuevo mes
                mes = cb_mes.getSelectionModel().getSelectedItem().getNum(); 
                loadPeriodos(tf_cedula.getText(),mes, ano);
                break;
            case 4:     //Reporte 4
                //Obtiene los valores seleccionados
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                loadNominas(empresa, ano);
                if(!isComboBoxEmpty(cb_nomina)){
                    nomina = cb_nomina.getSelectionModel().getSelectedItem();        
                    //actualiza los Tipo de Procesos para el nuevo mes
                    loadProcesosXAno(empresa, nomina, ano);
                }
                break;
            case 5:     //Reporte 5
                //Obtiene los valores seleccionados
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                loadNominas(empresa, ano);
                if(!isComboBoxEmpty(cb_nomina) && !isComboBoxEmpty(cb_mes)){
                    nomina = cb_nomina.getSelectionModel().getSelectedItem();                    
                    mes = cb_mes.getSelectionModel().getSelectedItem().getNum(); 
                    //actualiza los Tipo de Procesos para el nuevo mes
                    loadProcesosXMes(empresa, nomina, mes, ano);
                }
                break;
            case 6:     //Reporte 6
                //Obtiene los valores seleccionados
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                loadNominas(empresa, ano);
                if(!isComboBoxEmpty(cb_nomina) && !isComboBoxEmpty(cb_mes)){
                    nomina = cb_nomina.getSelectionModel().getSelectedItem();                    
                    mes = cb_mes.getSelectionModel().getSelectedItem().getNum(); 
                    //actualiza los Tipo de Procesos para el nuevo mes
                    loadProcesosXMes(empresa, nomina, mes, ano);
                    tipo = cb_proceso.getSelectionModel().getSelectedItem();
                    //actualiza los Conceptos
                    loadConceptos(true,empresa, nomina, mes, ano, tipo);
                }
                break;
            case 7:     //Reporte 7
                empresa = cb_empresa.getSelectionModel().getSelectedItem();
                loadNominas(empresa, ano);
                if(!isComboBoxEmpty(cb_nomina) && !isComboBoxEmpty(cb_mes)){
                    nomina = cb_nomina.getSelectionModel().getSelectedItem();                    
                    mes = cb_mes.getSelectionModel().getSelectedItem().getNum(); 
                    //actualiza los Tipo de Procesos para el nuevo mes
                    loadProcesosXMes(empresa, nomina, mes, ano);
                    tipo = cb_proceso.getSelectionModel().getSelectedItem();
                    //actualiza los Conceptos
                    loadConceptos(false,empresa, nomina, mes, ano, tipo);
                }
                break;
        }               
    }
    /**
     * El Item seleccionado en el ComboBox ha cambiado
     * @param newValue 
     */
    private void nominaChanged(String newValue){
        //Obtiene los valores seleccionados
        int reporte = cb_reporte.getSelectionModel().getSelectedItem().getId();        
        int ano     = cb_ano.getSelectionModel().getSelectedItem();
        Empresa empresa = cb_empresa.getSelectionModel().getSelectedItem();
        int tipo;
        int mes;
        switch(reporte){
            case 4:     //Reporte 5
                //actualiza los Tipo de Procesos 
                loadProcesosXAno(empresa, newValue, ano);
                break;
            case 5:     //Reporte 5
                mes  = cb_mes.getSelectionModel().getSelectedItem().getNum();
                //actualiza los Tipo de Procesos 
                loadProcesosXMes(empresa, newValue, mes, ano);
                break;
            case 6:     //Reporte 6
                mes  = cb_mes.getSelectionModel().getSelectedItem().getNum();
                //actualiza los Tipo de Procesos 
                loadProcesosXMes(empresa, newValue, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                loadConceptos(true,empresa, newValue, mes, ano, tipo);
                break;
            case 7:     //Reporte 7
                mes  = cb_mes.getSelectionModel().getSelectedItem().getNum();
                //actualiza los Tipo de Procesos 
                loadProcesosXMes(empresa, newValue, mes, ano);
                tipo = cb_proceso.getSelectionModel().getSelectedItem();
                //actualiza los Conceptos
                loadConceptos(false,empresa, newValue, mes, ano, tipo);
                break;
        }               
    } 
    /**
     * El Item seleccionado en el ComboBox ha cambiado
     * @param newValue valor del tipo de proceso
     */
    private void procesoChanged(int newValue){
        //Obtiene los parametros seleccionados
        int reporte = cb_reporte.getSelectionModel().getSelectedItem().getId();  
        int mes     = cb_mes.getSelectionModel().getSelectedItem().getNum();
        int ano     = cb_ano.getSelectionModel().getSelectedItem();
        Empresa empresa = cb_empresa.getSelectionModel().getSelectedItem();
        String nomina = cb_nomina.getSelectionModel().getSelectedItem();        
        switch(reporte){
            case 6:     //Reporte 6    
                //actualiza los Conceptos
                loadConceptos(true,empresa, nomina, mes, ano, newValue);
                break;
            case 7:     //Reporte 7
                //actualiza los Conceptos
                loadConceptos(false,empresa, nomina, mes, ano, newValue);
                break;
        }
    }
    /***************************************************************************/
    /***************************** LOAD COMBOBOXS ******************************/
    /***************************************************************************/
    /**
     * Se cargan los datos del ComboBox
     */
    private void loadMes(){        
        Mes[] unit = new Mes[]{
            new Mes(1,"Enero"),
            new Mes(2,"Febrero"),
            new Mes(3,"Marzo"),
            new Mes(4,"Abril"),
            new Mes(5,"Mayo"),
            new Mes(6,"Junio"),
            new Mes(7,"Julio"),
            new Mes(8,"Agosto"),
            new Mes(9,"Septiembre"),
            new Mes(10,"Octubre"),
            new Mes(11,"Noviembre"),
            new Mes(12,"Diciembre")
        };        
        final ObservableList<Mes> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(unit)); 
        cb_mes.setItems(data);    
        cb_mes.getSelectionModel().selectFirst();        
    }
    /**
     * Se cargan los datos del ComboBox
     */
    private void loadAño(){   
        Integer[] unit = new Integer[]{2014,2013,2012,2011,2010,2009,2008,2007,2006,2005,2004};
        final ObservableList<Integer> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(unit)); 
        cb_ano.setItems(data);    
        cb_ano.getSelectionModel().selectFirst();        
    }    
    /**
     * Se cargan los datos del ComboBox
     */
    public void loadFichas(){
        if(!tf_cedula.getText().isEmpty()){
            Empleado[] fichas = Ln.getInstance().loadInfoEmpleado(new Empleado(tf_cedula.getText()));
            if(fichas != null){
                final ObservableList<Empleado> data = FXCollections.observableArrayList();
                data.addAll(Arrays.asList(fichas)); 
                cb_ficha.setItems(data);    
                cb_ficha.getSelectionModel().selectFirst(); 
            }
        }
    }
    /**
     * Se cargan los datos del ComboBox
     */ 
    private void loadReportes(){        
        Reporte[] unit = new Reporte[]{
            new Reporte(1,"por Cedula y Periodo"),
            new Reporte(2,"por Cedula y Mes"),
            new Reporte(3,"por Cedula y Año"),
            new Reporte(4,"por Empresa y Año"),
            new Reporte(5,"por Empresa y Mes"),
            new Reporte(6,"Asignaciones por Concepto"),
            new Reporte(7,"Deducciones por Concepto")
        };        
        final ObservableList<Reporte> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(unit)); 
        cb_reporte.setItems(data);    
        cb_reporte.getSelectionModel().selectFirst();        
    }  
    /**
     * Se cargan los datos del ComboBox
     */
    private void loadEmpresas(){              
        Empresa[] empresas = new Empresa[]{
            new Empresa("DI","DIGA"),
            new Empresa("GI","GLOMAR")
        };
        final ObservableList<Empresa> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(empresas)); 
        cb_empresa.setItems(data);    
        cb_empresa.getSelectionModel().selectFirst();        
    }
    /**
     * Se cargan los datos del ComboBox
     */
    private void loadNominas(Empresa empresa,int ano){              
        String[] nominas = Ln.getInstance().loadNominas(empresa,ano);
        if(nominas != null){
            final ObservableList<String> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(nominas)); 
            cb_nomina.setItems(data);    
            cb_nomina.getSelectionModel().selectFirst();        
        }
    }
    /**
     * Se cargan los datos del ComboBox
     * @param cedula
     * @param mes
     * @param ano 
     */
    private void loadPeriodos(String cedula,int mes,int ano){     
        Integer[] nominas = Ln.getInstance().loadPeriodos(cedula,mes,ano);
        if(nominas != null){
            final ObservableList<Integer> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(nominas)); 
            cb_periodos.setItems(data);    
            cb_periodos.getSelectionModel().selectFirst();        
        }
    }
    /**
     * Se cargan los datos del ComboBox
     * @param empresa
     * @param nomina
     * @param mes
     * @param ano 
     */
    private void loadProcesosXMes(Empresa empresa,String nomina,int mes,int ano){              
        Integer[] procesos = Ln.getInstance().loadTipoProcesosXMes(empresa,nomina,mes,ano);
        if(procesos != null){
            //Set items del ChoiceBox de periodos
            final ObservableList<Integer> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(procesos)); 
            cb_proceso.setItems(data);  
            cb_proceso.getSelectionModel().selectFirst();                   
        }
    }
    /**
     * Se cargan los datos del ComboBox
     * @param empresa
     * @param nomina
     * @param ano 
     */
    private void loadProcesosXAno(Empresa empresa,String nomina,int ano){              
        Integer[] procesos = Ln.getInstance().loadTipoProcesosXAno(empresa,nomina,ano);
        if(procesos != null){
            //Set items del ChoiceBox de periodos
            final ObservableList<Integer> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(procesos)); 
            cb_proceso.setItems(data);  
            cb_proceso.getSelectionModel().selectFirst();                   
        }
    }
    /**
     * Se cargan los datos del ComboBox
     * @param empresa
     * @param nomina
     * @param mes
     * @param ano
     * @param tipo 
     */
    private void loadConceptos(Boolean isAsignacion,Empresa empresa,String nomina,int mes,int ano,int tipo){              
        Concepto[] conceptos = Ln.getInstance().loadConceptos("",empresa,nomina,mes,ano,tipo);
        if(conceptos != null){
            final ObservableList<Concepto> data = FXCollections.observableArrayList();
            data.addAll(Arrays.asList(conceptos)); 
            cb_concepto.setItems(data);    
            cb_concepto.getSelectionModel().selectFirst();        
        }
    }    
    /***************************************************************************/
    /***************************** PROCEDIMIENTOS ******************************/
    /***************************************************************************/
    /**
     * 
     * @param cbox
     * @return 
     */
    private boolean isComboBoxEmpty(ChoiceBox cbox){
        return cbox.getItems().isEmpty();
    }
    /**
     * Metodo encargado de Habilitar/Deshabilitar distintos componentes segun el 
     * parametro del reporte seleccionado
     * @param reporte valor del reporte seleccionado
     */
    private void DisableFields(int reporte){
        //Se habilitan o deshabilitan los campos correspondites segun el tipo de reporte seleccionado
        switch(reporte){
            case 1: //REPORTE 1
                disableInfoEmpleado(false);
                busquedasPorEmpleados(true);
                cb_mes.setDisable(false);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(false);
                cb_proceso.setVisible(false);
                lb_concepto.setVisible(false);
                cb_concepto.setVisible(false);
                cb_periodos.setDisable(false);
                break;
            case 2: //REPORTE 2
                disableInfoEmpleado(false);
                busquedasPorEmpleados(true);
                cb_mes.setDisable(false);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(false);
                cb_proceso.setVisible(false);
                lb_concepto.setVisible(false);
                cb_concepto.setVisible(false);
                cb_periodos.setDisable(true);
                break;
            case 3: ////REPORTE 3
                disableInfoEmpleado(false);
                busquedasPorEmpleados(true);
                cb_mes.setDisable(true);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(false);
                cb_proceso.setVisible(false);
                lb_concepto.setVisible(false);
                cb_concepto.setVisible(false);
                cb_periodos.setDisable(true);
                break;
            case 4: //REPORTE 4
                disableInfoEmpleado(true);
                busquedasPorEmpleados(false);
                cb_mes.setDisable(true);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(true);
                cb_proceso.setVisible(true);
                lb_concepto.setVisible(false);
                cb_concepto.setVisible(false);
                cb_periodos.setDisable(true);
                break;
            case 5: //REPORTE 5
                disableInfoEmpleado(true);
                busquedasPorEmpleados(false);
                cb_mes.setDisable(false);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(true);
                cb_proceso.setVisible(true);
                lb_concepto.setVisible(false);
                cb_concepto.setVisible(false);
                cb_periodos.setDisable(true);
                break;
            case 6: //REPORTE 6
                disableInfoEmpleado(true);
                busquedasPorEmpleados(false);
                cb_mes.setDisable(false);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(true);
                cb_proceso.setVisible(true);
                lb_concepto.setVisible(true);
                cb_concepto.setVisible(true);
                cb_periodos.setDisable(true);
                break;
            case 7: //REPORTE 7
                disableInfoEmpleado(true);      
                busquedasPorEmpleados(false);
                cb_mes.setDisable(false);
                cb_ano.setDisable(false);
                lb_proceso.setVisible(true);
                cb_proceso.setVisible(true);
                lb_concepto.setVisible(true);
                cb_concepto.setVisible(true);
                cb_periodos.setDisable(true);
                break;
        }
    }
    /**
     * Metodo que ejecuta los procesos de modificacion del formulario y otros, 
     * correspondientes al tipo de operacion que se este ejecutando
     */
    private void setCurrentOperation(){     
        lb_Title.setText("");       //Se deja en blanco la etiqueta del Titulo        
        //SE PERMITE: 
        Integer[] disables = new Integer[]{1,2,3,4,5,6,7,8,9,10,11};
        disableAllToolBar(disables); 
        //Gui.getInstance().setTipoOperacion(tipoOperacion);
    } 
    /**
     * Habilita/Deshabilita los HBox responsables de mostrar los datos de la ficha 
     * del empleado o de los parametros de busqueda por empresa
     * @param value valor logico para habilitar/deshabilitar los HBox
     */
    private void disableInfoEmpleado(boolean value){       
        hb_2.setVisible(!value);
        hb_3.setVisible(!value);
        hb_4.setVisible(value);
    }
    /**
     * Habilita/Deshabilita los campos de datos segun el tipo de reporte seleccionado
     * @param value valor logico de busqueda por reportes de Empleados o Empresas
     */
    private void busquedasPorEmpleados(boolean value){
        if(value){  //SI la busqueda es por empleados
            //Eliminar del HBox el campo de empresas
            hb_1.getChildren().remove(cb_empresa);                
            //SI HBox NO contiene el campo tf_cedula    
            if(!hb_1.getChildren().contains(tf_cedula)){    
                //Agregar el campo tf_cedula en el HBox
                hb_1.getChildren().add(tf_cedula);
            }
            //Cambia el texto de la Etiqueta
            lb_param1.setText("Cedula:");
            //SI HBox contiene el campo de seleccion
            if(!hb_1.getChildren().contains(cb_ficha)){           
                //Agregar el campo en el HBox
                hb_1.getChildren().add(cb_ficha);
            }
            //Elimina del VBox el organizdor Horiz.
            vb_1.getChildren().remove(hb_4);
            //SI NO contiene alguno de los HBox lo agrega
            if(!vb_1.getChildren().contains(hb_2)) 
                vb_1.getChildren().add(hb_2);
            if(!vb_1.getChildren().contains(hb_3)) 
                vb_1.getChildren().add(hb_3);
            
        }else{      //SI la busqueda es por empresa
            //Eliminar del HBox los campos de empleados
            hb_1.getChildren().remove(tf_cedula);
            hb_1.getChildren().remove(cb_ficha);
            //SI NO contiene el campo de seleccion
            if(!hb_1.getChildren().contains(cb_empresa)){ 
                //Agrega el campo al HBox
                hb_1.getChildren().add(cb_empresa);                
            }
            //Cambia el texto del campo
            tf_cedula.setText("");
            //Elimina los Items previamente cargados en el campo
            cb_ficha.getSelectionModel().clearSelection();
            cb_ficha.getItems().clear();
            //Cambia el texto de la Etiqueta
            lb_param1.setText("Empresa:");
            //Elimina los HBox de Busquedas por Persona
            vb_1.getChildren().remove(hb_2);
            vb_1.getChildren().remove(hb_3);
            //SI NO contiene el HBox
            if(!vb_1.getChildren().contains(hb_4)){
                //Agrega el Hbox 
                vb_1.getChildren().add(hb_4);                
            }
            //obtiene el valor del reporte seleccionado
            int reporte = cb_reporte.getSelectionModel().getSelectedItem().getId();
            //SI es Reportes 6 o 7 
            if(reporte > 5){
                //Se activan los campos de CONCEPTO
                lb_concepto.setVisible(true);
                cb_concepto.setVisible(true);
            }else{
                //Se desactivan los campos de CONCEPTO
                lb_concepto.setVisible(false);
                cb_concepto.setVisible(false);
            }
        }
    }    
    /***************************************************************************/
    /***************************** LOAD DATA ***********************************/
    /***************************************************************************/
    /**
     * Establece los datos del empleado seleccionado en sus campos graficos
     * @param value valor del empleado
     */
    private void showInfoEmpleado(Empleado value){
        if(value != null){  //SI el valor NO es nulo
            lb1.setText(value.getCompania());
            lb2.setText(value.getNomina());
            lb3.setText(value.getIngreso());
            lb4.setText(value.getNombre()+" "+value.getApellido());
            lb5.setText(value.getFicha());
            lb6.setText(value.getRetiro());
        }else{      //SI el valor es nulo 
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            lb4.setText("");
            lb5.setText("");
            lb6.setText("");
        }
    }
    /**
     * Obtiene los parametros de busqueda necesarios segun el reporte que haya sido seleccionado
     */
    private void searchData(){
        if(cont == 1){
            //
            tb_table1.getItems().clear();
            tb_table2.getItems().clear();
            //Valor del reporte seleccionado
            Reporte reporte = cb_reporte.getSelectionModel().getSelectedItem();
            //Valor de los parametros mes y año
            int mes = cb_mes.getSelectionModel().getSelectedItem().getNum();
            int ano = cb_ano.getSelectionModel().getSelectedItem();
            //Segun el reporte Seleccionado
            switch(reporte.getId()){
                case 1:     //Reporte #1 por Cedula y Periodo
                    //SI el campo NO es nulo
                    if(!tf_cedula.getText().isEmpty()){                    
                        if(!isComboBoxEmpty(cb_periodos)){
                            //Valor de los parametros periodo y Ficha seleccionado
                            int periodo = cb_periodos.getSelectionModel().getSelectedItem();
                            Empleado ficha = cb_ficha.getSelectionModel().getSelectedItem();
                            //Solicitud del reporte
                            reporte1(ficha,periodo,mes,ano);
                        }
                    }
                    break;
                case 2:     //Reporte #2 por Cedula y Mes
                    //SI el campo NO es nulo
                    if(!tf_cedula.getText().isEmpty()){
                        if(!isComboBoxEmpty(cb_ficha)){
                            //Valor del parametro Ficha seleccionado
                            Empleado ficha = cb_ficha.getSelectionModel().getSelectedItem();
                            //Solicitud del reporte
                            reporte2(ficha,mes,ano);
                        }
                    }
                    break;
                case 3:     //Reporte #3 por Cedula y Año
                    //SI el campo NO es nulo
                    if(!tf_cedula.getText().isEmpty()){
                        if(!isComboBoxEmpty(cb_ficha)){
                            //Valor del parametro Ficha seleccionado
                            Empleado ficha = cb_ficha.getSelectionModel().getSelectedItem();
                            //Solicitud del reporte
                            reporte3(ficha,ano);
                        }
                    }
                    break;
                case 4:     //Reporte #4 por Empresa y Año
                    if(!isComboBoxEmpty(cb_proceso) && !isComboBoxEmpty(cb_nomina)){
                        //Solicitud del reporte
                        reporte4(ano);
                    }
                    break;
                case 5:     //Reporte #5 por Empresa y Mes
                    if(!isComboBoxEmpty(cb_proceso) && !isComboBoxEmpty(cb_nomina)){
                        //Solicitud del reporte
                        reporte5(mes,ano);
                    }
                    break;
                case 6:     //Reporte #6 Asignaciones por Concepto y Mes
                    if(!isComboBoxEmpty(cb_proceso) && !isComboBoxEmpty(cb_nomina) && !isComboBoxEmpty(cb_concepto)){
                        //Solicitud del reporte
                        reporte6(mes,ano);
                    }
                    break; 
                case 7:     //Reporte #7 Deducciones por Concepto y Mes
                    if(!isComboBoxEmpty(cb_proceso) && !isComboBoxEmpty(cb_nomina) && !isComboBoxEmpty(cb_concepto)){
                        //Solicitud del reporte 
                        reporte7(mes,ano);
                    }
                    break;             
            }
        }
    }
    /**
     * Reporte #1, establece los datos informativos del empleado y obtiene los
     * resultados de las asignaciones y deducciones
     * @param ficha datos de la ficha de RRHH del empleado 
     * @param periodo valor de un periodo de tiempo en el año (Semana del año,Quincena del Año)
     * @param mes valor del mes del año
     * @param ano valor del año
     */
    private void reporte1(Empleado ficha,int periodo,int mes,int ano){                    
        //Establece el cuadro informativo del Empleado
        showInfoEmpleado(ficha);
        //Obtiene y llena las tablas con los resultados        
        Asignacion[] asigs = Ln.getInstance().loadAsignacionesXPeriodo(ficha, periodo, mes, ano);            
        if(asigs != null){  
            final ObservableList<Asignacion> data1 = FXCollections.observableArrayList();
            data1.addAll(Arrays.asList(asigs)); 
            tb_table1.setItems(data1); 
        }
        //Obtiene y llena las tablas con los resultados
        Deduccion[]  dedus = Ln.getInstance().loadDeduccionesXPeriodo(ficha, periodo, mes, ano);
        if(dedus != null){ 
            final ObservableList<Deduccion> data2 = FXCollections.observableArrayList();
            data2.addAll(Arrays.asList(dedus)); 
            tb_table2.setItems(data2); 
        }   
    }
    /**
     * Reporte #2, establece los datos informativos del empleado y obtiene los
     * resultados de las asignaciones y deducciones
     * @param ficha datos de la ficha de RRHH del empleado 
     * @param mes valor del mes del año
     * @param ano valor del año
     */
    private void reporte2(Empleado ficha,int mes,int ano){                    
        //Establece el cuadro informativo del Empleado
        showInfoEmpleado(ficha);        
        //Obtiene y llena las tablas con los resultados        
        Asignacion[] asigs = Ln.getInstance().loadAsignacionesXMes(ficha, mes, ano);    
        if(asigs != null){  
            final ObservableList<Asignacion> data1 = FXCollections.observableArrayList();
            data1.addAll(Arrays.asList(asigs)); 
            tb_table1.setItems(data1); 
        }
        //Obtiene y llena las tablas con los resultados
        Deduccion[]  dedus = Ln.getInstance().loadDeduccionesXMes(ficha, mes, ano);
        if(dedus != null){ 
            final ObservableList<Deduccion> data2 = FXCollections.observableArrayList();
            data2.addAll(Arrays.asList(dedus)); 
            tb_table2.setItems(data2); 
        }
    }
    /**
     * Reporte #3, establece los datos informativos del empleado y obtiene los
     * resultados de las asignaciones y deducciones
     * @param ficha datos de la ficha de RRHH del empleado 
     * @param ano valor del año
     */
    private void reporte3(Empleado ficha,int ano){                    
        //Establece el cuadro informativo del Empleado
        showInfoEmpleado(ficha);
        //Obtiene y llena las tablas con los resultados
        Asignacion[] asigs = Ln.getInstance().loadAsignacionesXAno(ficha, ano);      
        if(asigs != null){  
            final ObservableList<Asignacion> data1 = FXCollections.observableArrayList();
            data1.addAll(Arrays.asList(asigs)); 
            tb_table1.setItems(data1); 
        }
        //Obtiene y llena las tablas con los resultados
        Deduccion[]  dedus = Ln.getInstance().loadDeduccionesXAno(ficha, ano);
        if(dedus != null){ 
            final ObservableList<Deduccion> data2 = FXCollections.observableArrayList();
            data2.addAll(Arrays.asList(dedus)); 
            tb_table2.setItems(data2);         
        }
    }
    /**
     * Reporte #4, establece los datos informativos de la empresa y obtiene los
     * resultados de las asignaciones y deducciones
     * @param mes valor del mes del año
     * @param ano valor del año
     */
    private void reporte4(int ano){                    
        //Obtiene las variables seleccionadas
        Empresa empresa = cb_empresa.getSelectionModel().getSelectedItem();
        String  nomina  = cb_nomina.getSelectionModel().getSelectedItem();
        int     tipo    = cb_proceso.getSelectionModel().getSelectedItem();
        //Obtiene y llena las tablas con los resultados
//        Asignacion[] asigs = Ln.getInstance().loadAsignacionesEmpresaXAno(empresa,nomina, ano, tipo);          
//        if(asigs != null){    
//            final ObservableList<Asignacion> data1 = FXCollections.observableArrayList();
//            data1.addAll(Arrays.asList(asigs)); 
//            tb_table1.setItems(data1); 
//        }
//        //Obtiene y llena las tablas con los resultados
//        Deduccion[]  dedus = Ln.getInstance().loadDeduccionesEmpresaXAno(empresa,nomina, ano, tipo);
//        if(dedus != null){    
//            final ObservableList<Deduccion> data2 = FXCollections.observableArrayList();
//            data2.addAll(Arrays.asList(dedus)); 
//            tb_table2.setItems(data2);            
//        }
    }
    /**
     * Reporte #5, establece los datos informativos de la empresa y obtiene los
     * resultados de las asignaciones y deducciones
     * @param mes valor del mes del año
     * @param ano valor del año
     */
    private void reporte5(int mes, int ano){                    
        //Obtiene las variables seleccionadas     
        Empresa empresa = cb_empresa.getSelectionModel().getSelectedItem();
        String  nomina  = cb_nomina.getSelectionModel().getSelectedItem();
        int     tipo    = cb_proceso.getSelectionModel().getSelectedItem();
        //Obtiene y llena las tablas con los resultados
//        Asignacion[] asigs = Ln.getInstance().loadAsignacionesEmpresaXMes(empresa,nomina,mes, ano, tipo);           
//        if(asigs != null){  
//            final ObservableList<Asignacion> data1 = FXCollections.observableArrayList();
//            data1.addAll(Arrays.asList(asigs)); 
//            tb_table1.setItems(data1); 
//        }
//        //Obtiene y llena las tablas con los resultados
//        Deduccion[]  dedus = Ln.getInstance().loadDeduccionesEmpresaXMes(empresa,nomina,mes, ano, tipo);
//        if(dedus != null){ 
//            final ObservableList<Deduccion> data2 = FXCollections.observableArrayList();
//            data2.addAll(Arrays.asList(dedus)); 
//            tb_table2.setItems(data2);            
//        }
    }
    /**
     * Reporte #6, establece los datos informativos de la empresa y obtiene los
     * resultados de las asignaciones y deducciones
     * @param mes valor del mes del año
     * @param ano valor del año
     */
    private void reporte6(int mes, int ano){                    
        //Obtiene las variables seleccionadas        
        Empresa empresa = cb_empresa.getSelectionModel().getSelectedItem();
        String  nomina  = cb_nomina.getSelectionModel().getSelectedItem();
        int     tipo    = cb_proceso.getSelectionModel().getSelectedItem();
        Concepto  concepto   = cb_concepto.getSelectionModel().getSelectedItem();
        //Obtiene y llena las tablas con los resultados
        Asignacion[] asigs = Ln.getInstance().loadAsignacionesConceptosXMes(empresa,nomina, mes, ano, tipo, concepto);   
        if(asigs != null){  
            final ObservableList<Asignacion> data1 = FXCollections.observableArrayList();
            data1.addAll(Arrays.asList(asigs)); 
            tb_table1.setItems(data1);
        }
    }
    /**
     * Reporte #7, establece los datos informativos de la empresa y obtiene los
     * resultados de las asignaciones y deducciones
     * @param mes valor del mes del año
     * @param ano valor del año
     */
    private void reporte7(int mes, int ano){                    
        //Obtiene las variables seleccionadas       
        Empresa empresa = cb_empresa.getSelectionModel().getSelectedItem();
        String  nomina  = cb_nomina.getSelectionModel().getSelectedItem();
        int     tipo    = cb_proceso.getSelectionModel().getSelectedItem();
        Concepto  concepto   = cb_concepto.getSelectionModel().getSelectedItem();
        //Obtiene y llena las tablas con los resultados
        Deduccion[]  dedus = Ln.getInstance().loadDeduccionesConceptosXMes(empresa,nomina, mes, ano, tipo, concepto); 
        if(dedus != null){     
            final ObservableList<Deduccion> data2 = FXCollections.observableArrayList();
            data2.addAll(Arrays.asList(dedus)); 
            tb_table2.setItems(data2);            
        }
    }
    /***************************************************************************/
    /***************************** LOAD TABLES *********************************/
    /***************************************************************************/
    /**
     * Solicita la definicion de cada tabla que sera utilizada en esta pantalla 
     */
    private void loadTables(){
        defineTable(tb_table1);
        defineTable(tb_table2);
    }
    /**
     * Se define las columnas y caracteristicas de la tabla y el comportamiento especial
     * de los datos en caso de requerirlo
     * @param tb_table 
     */
    private void defineTable(TableView tb_table){
        //Se crean y definen las columnas de la Tabla              
        TableColumn col_nomina        = new TableColumn("Nomina");
        TableColumn col_concepto      = new TableColumn("Concepto");  
        TableColumn col_descto        = new TableColumn("Descripcion");        
        TableColumn col_tipo          = new TableColumn("Tipo");
        TableColumn col_proceso       = new TableColumn("Proceso");
        TableColumn col_num           = new TableColumn("Num");        
        TableColumn col_cantidad      = new TableColumn("Cantidad");
        TableColumn col_monto         = new TableColumn("Monto");
        TableColumn col_saldo         = new TableColumn("Saldo");
        int size = 60;
        //Se establece el ancho de cada columna
        this.objectWidth(col_concepto ,size  , size);
        this.objectWidth(col_nomina   ,size  , size);
        this.objectWidth(col_descto   ,size*3, size*3);
        this.objectWidth(col_tipo     ,size  , size);
        this.objectWidth(col_proceso  ,size*3, size*3);
        this.objectWidth(col_num      ,size  , size);        
        this.objectWidth(col_cantidad ,size  , size);
        this.objectWidth(col_monto    ,size*2, size*2);
        this.objectWidth(col_saldo    ,size  , size);
        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente        
        col_nomina.setCellValueFactory(  new PropertyValueFactory<>("nomina") );
        col_concepto.setCellValueFactory(new PropertyValueFactory<>("concepto") );
        col_descto.setCellValueFactory(  new PropertyValueFactory<>("descto") );
        col_tipo.setCellValueFactory(    new PropertyValueFactory<>("tipo") );
        col_proceso.setCellValueFactory( new PropertyValueFactory<>("proceso") );        
        col_num.setCellValueFactory(     new PropertyValueFactory<>("num") );
        col_cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad") );
        col_monto.setCellValueFactory(   new PropertyValueFactory<>("monto") );
        col_saldo.setCellValueFactory(   new PropertyValueFactory<>("saldo") );
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
            col_nomina,col_concepto, col_descto, col_tipo, col_proceso, col_num, col_cantidad, col_monto, col_saldo
        );       
        //
        tb_table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<InfocentTableData>() {                
            @Override
            public void changed(ObservableValue<? extends InfocentTableData> observable, InfocentTableData oldValue, InfocentTableData newValue) {
                //Datos.setFichaEmpleado(ano);
            }
        });        
    } 
}
