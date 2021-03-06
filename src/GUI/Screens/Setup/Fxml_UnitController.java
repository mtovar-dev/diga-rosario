/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Setup;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Objects.Setup.Unit;
import Tools.Datos;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author MITM
 */
public class Fxml_UnitController implements Initializable {

    @FXML //  fx:id="ap_root"
    private AnchorPane ap_root; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_1"
    private HBox hb_1;

    @FXML //  fx:id="hb_2"
    private HBox hb_2; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_3"
    private HBox hb_3; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_7"
    private HBox hb_7; // Value injected by FXMLLoader

    @FXML //  fx:id="hbox_toolbar"
    private HBox hbox_toolbar; // Value injected by FXMLLoader

    @FXML //  fx:id="im_check"
    private ImageView im_check; // Value injected by FXMLLoader

    @FXML //  fx:id="im_val"
    private ImageView im_val; // Value injected by FXMLLoader
    
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
    private TableView<Unit> tb_table; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_abrev"
    private TextField tf_abrev; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_buscar"
    private TextField tf_buscar; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_id"
    private TextField tf_id; // Value injected by FXMLLoader

    @FXML //  fx:id="tf_nombre"
    private TextField tf_nombre; // Value injected by FXMLLoader

    @FXML //  fx:id="vb_form"
    private VBox vb_form; // Value injected by FXMLLoader

    @FXML //  fx:id="vb_table"
    private VBox vb_table; // Value injected by FXMLLoader


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

    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig; 
    private static String[] tooltips;
    
    private static final String ScreenName = "Unidad";

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert hb_2 != null : "fx:id=\"hb_2\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert hb_3 != null : "fx:id=\"hb_3\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert hb_7 != null : "fx:id=\"hb_7\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_val != null : "fx:id=\"im_val\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert lb_ocultar != null : "fx:id=\"lb_ocultar\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert tf_abrev != null : "fx:id=\"tf_abrev\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert tf_id != null : "fx:id=\"tf_id\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert tf_nombre != null : "fx:id=\"tf_nombre\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";
        assert vb_table != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Unit.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons();     //Establece los comportamientos de los botones
        botonInicio();      //Se imprime la pantalla Inicio
        
        //
        createTable();  //Crea e Inicializa la Tabla de Datos                    

        //Capturador de eventos de Teclado en toda la pantalla 
        ap_root.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
               if (ke.getCode().equals(KeyCode.ENTER)){                     
                   nextFocusedField(ke);    //Traslado el ENFOQUE al siguiente Campo                         
               }                
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT1)){                     
//                   botonNuevo();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT2)){                     
//                   botonEditar();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT4)){                     
//                   botonEliminar();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT5)){                     
//                   //IMPRIMIR
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT6)){                     
//                   //CANCELAR
//                   botonInicio();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.B)){                     
//                   botonBuscar();
//               }
        });
    }    
    
    /***************************************************************************/
    /***************************** PROCEDIMIENTOS ******************************/
    /***************************************************************************/
    
    /**
    * Metodo encargado de Crear e inicializar la Tabla de Datos
    */
    private void createTable(){
        //Se crean y definen las columnas de la Tabla
        TableColumn col_status      = new TableColumn("");
        TableColumn col_unidad      = new TableColumn("Unidad");                
        TableColumn col_nombre      = new TableColumn("Nombre");        
        TableColumn col_abrev       = new TableColumn("Abreviatura");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_status     , 25 , 25);
        this.objectWidth(col_unidad     , 80, 120);
        this.objectWidth(col_nombre     , 320, 400);
        this.objectWidth(col_abrev      , 90, 120);
        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_status.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Unit, Object>() {
                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        if(!empty){
                            switch(item.toString()){  
                                case "0":     //DESHABILITADO
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img57.png"), 15, 15, false,false))); 
                                    break;
                                case "1":     //HABILITADO
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img61.png"), 15, 15, false,false))); 
                                    break;   
                            }                            
                            setAlignment(Pos.CENTER);
                        }
                        else
                            setGraphic(null);
                    }
                };
            }
        });        
        //Se define la columna de la tabla con el nombre del atributo del objeto UNIT correspondiente
        col_status.setCellValueFactory( 
                new PropertyValueFactory<>("status") );
        col_unidad.setCellValueFactory( 
                new PropertyValueFactory<>("idUnit") );
        col_nombre.setCellValueFactory( 
                new PropertyValueFactory<>("nombre") );
        col_abrev.setCellValueFactory( 
                new PropertyValueFactory<>("abrev") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
                col_status, col_unidad, col_nombre, col_abrev);                
        
        //Se Asigna tamaño del VBox para que lo tome el TableView
        vb_table.relocate(30, 64);
        vb_table.setPrefWidth(712);
        vb_table.setPrefHeight(508);

        //Se define el comportamiento de las teclas ARRIBA y ABAJO en la tabla
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                //Si fue presionado la tecla ARRIBA o ABAJO
                if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)){     
                    //Selecciona la FILA enfocada
                    selectedRow();
                }
            }
        };
        //Se Asigna el comportamiento para que se ejecute cuando se suelta una tecla
        tb_table.setOnKeyReleased(eh);
    }  
    /**
     * Metodo encargado de guardar los datos de un nuevo usuario o de un 
     * usuario modificado
     */
    private boolean saveUnit() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es un NUEVO usuario - 2 si es un usuario MODIFICADO
        int proceso = tipoOperacion;    
        //Se obtiene el nombre de usuario
        String unitname = tf_nombre.getText();
        //Si el nombre de usuario no esta en blanco
        if(unitname != null && !unitname.equals("")){
            //Si existe un rol seleccionado
            //Se establece la operacion de guardado
            tipoOperacion = 3;
            //Ejecuta los procesos predeterminados para el guardado del usuario
            setCurrentOperation();
            //Se asignan los valores del objeto 
            Unit unit = new Unit();
            unit.setIdUnit(Integer.parseInt(tf_id.getText()));
            unit.setNombre(tf_nombre.getText());
            unit.setAbrev(tf_abrev.getText());
            unit.setStatus(Datos.getUnit().getStatus());      //Se asigna el STATUS del usuario
            //Se llama al proceso de Guardado
            boolean result = 
                    Ln.getInstance().save_Unit(unit, proceso, ScreenName);
            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                Gui.getInstance().showMessage("La " + ScreenName + " se ha Guardado Correctamente!", "I");
                loadUnits();            //Se Recarga la tabla de usuarios existentes
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ninguna " + ScreenName + " para ser Guardado!", "A");
        }
        return false;
    }
    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){        
        tf_id.setText(String.valueOf(Datos.getUnit().getIdUnit()));
        tf_nombre.setText(Datos.getUnit().getNombre());
        tf_abrev.setText(Datos.getUnit().getAbrev());
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
        hb_7.setVisible(false);          //Se oculta el NODO que contiene el link de ocultar formulario
        loadToolBar();                   //Se Refresca la barra de Herramientas
        lb_Title.setText("");            //Se deja en blanco la etiqueta del Titulo
        //Se evalua el tipo de Operacion
        switch(tipoOperacion){
            case 0:  //SOLO LECTURA                    
                tf_id.setEditable(false);
                tf_nombre.setEditable(false);
                tf_abrev.setEditable(false);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
                disables = new Integer[]{2,6,7,8,9,10};
                disableAllToolBar(disables); 
                hb_7.setVisible(true);
                break;
            case 1:  //NUEVO
//                lb_Title.setText(Tools.verticalText("NUEVO"));
                lb_Title.setText("NUEVO");
                tf_id.setEditable(false);
                tf_nombre.setEditable(true);
                tf_abrev.setEditable(true);

                im_check.setVisible(true);
                im_val.setVisible(false);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText(Tools.verticalText("EDITAR"));
                lb_Title.setText("EDITAR");
                tf_id.setEditable(false);
                tf_nombre.setEditable(true);
                tf_abrev.setEditable(true);

                im_check.setVisible(true);
                im_val.setVisible(false);
                
                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_id.setEditable(false);
                tf_nombre.setEditable(false);
                tf_abrev.setEditable(false);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS 
                tf_id.setEditable(false);
                tf_nombre.setEditable(false);
                tf_abrev.setEditable(false);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
                disables = new Integer[]{0,1,2,4,6,7,8,9,10,11};
                disableAllToolBar(disables); 
                break;
        }        
        hb_2.setVisible(isNamesVisible);
        hb_3.setVisible(isNamesVisible);
        init_FocusArray(tipoOperacion);       
        Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento que busca en BD la lista de usuarios
     * y los envia a cargar en la tabla
     */
    private void loadUnits(){        
        Datos.setRep_unit(Ln.getInstance().load_Unit());
        loadTable( Datos.getRep_unit());     
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(Unit[] units){    
        if(units != null){
            ObservableList<Unit> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(units));        
            tb_table.setItems(data);        
        }
    } 
    /**
     * Metodo que selecciona y llena el formulario con los datos del usuario 
     * seleccionado en la tabla
     */
    private void selectedRow(){
        tipoOperacion = 0;      //SOLO LECTURA
        //Selecciona el usuario enfocado
        Unit unit = tb_table.getSelectionModel().getSelectedItem();          
        if(unit != null){
            Datos.setUnit(unit);          //Asigno el Usuario a la Clase de Datos Globales
            change_im_tool4(unit.getStatus());  //Se define el valor del Boton de Cambio se Status
            refreshForm();                      //Refresca el Formulario
            setFormVisible(true);               //Coloca Visible el formulario
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
                nodos = new Node[]{tf_id,tf_nombre,tf_abrev};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{tf_nombre,tf_abrev};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{tf_nombre,tf_abrev};
                break;
        }             
        switch (opc){
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
            //en caso de que se este creando un nuevo usuario
            switch(Gui.getFieldsType()){
                case 1: //NUEVO
                    //Si el campo enfocado esta en la posicion 1 o 3
                    if(Gui.getFieldFocused() == 1){
                        //si los campos de texto no son nulos
                        if(tf_nombre.getText() != null ){
                            if(tipoOperacion == 1){ //NUEVO
                                boolean boo = Ln.getInstance().check_Unit(tf_nombre.getText());    
                                if (boo){
                                    Gui.getInstance().showMessage("Ya existe la " + ScreenName + ", no puede ser Guardado!", "E");
                                    botonInicio();
                                }
                            }
                        }
                    }
                    break;
            }            
            //Se Enfoca el nuevo nodo correspondiente
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();            
        }else{  //Sino
            if(tipoOperacion > 0)
                botonGuardar();  //Guardar los datos
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
        //CARGA DE LA BD LA CONFIGURACION DE UNIT PARA LA PANTALLA
        toolsConfig = Ln.getInstance().loadToolBar();                        
        // arreglo con cada etiqueta, ordenado por boton
        tooltips = new String[]{
            "Nuevo " + ScreenName + " ",
            "Editar " + ScreenName + " ",
            "Guardar " + ScreenName + " ",
            "Cambiar Status de " + ScreenName + " ",
            "Imprimir " + ScreenName + " ",
            "Cancelar ",
            "Sin Asignar",
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

        im_tool7.setVisible(false);
        im_tool8.setVisible(false);
        im_tool9.setVisible(false);
        im_tool10.setVisible(false);
        im_tool11.setVisible(false);
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
                        try{
                            Datos.setRep_unit(Ln.getInstance().find_Unit(tf_buscar.getText()));
                            loadTable(Datos.getRep_unit());     
                        } catch(Exception e){
                            Gui.getInstance().showMessage("La " + ScreenName + " NO existe!", "A");
                        }
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
    private void botonInicio() {
        tipoOperacion = 0;                  //OPERACION SOLO LECTURA
        loadToolBar();
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setText("");
        tf_buscar.setVisible(false);
        Datos.setUnit(new Unit());                           
        refreshForm();                      
        Datos.setUnit(null);             //RESET DE LA VARIABLE
        setFormVisible(false);              //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadUnits();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            //changeIcon(false);
            loadUnits();
            Datos.setUnit(new Unit());
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        if(Datos.getUnit()!= null && toolsConfig[3]==1){
            tipoOperacion = 2;
            change_im_tool4(Datos.getUnit().getStatus());
            refreshForm();
            setFormVisible(true);     
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonGuardar(){        
        if(Datos.getUnit()!= null && toolsConfig[4]==1){
            boolean result = saveUnit();
            if (result)
                botonInicio();
        }
    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getUnit()!= null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            //changeIcon(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL UNIT                   
            refreshForm();         
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getUnit().getStatus() == 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " la " + ScreenName + " " + Datos.getUnit().getIdUnit() + " ?";
            Gui.getInstance().showConfirmar(mensj);  
        }
    }
    /**
     * 
     */
    private void botonBuscar(){
        if(toolsConfig[13]==1){
            tipoOperacion = 0;                  //OPERACION SOLO LECTURA
            //SE LIMPIA EL FORMULARIO
            tf_buscar.setVisible(true);
            Datos.setUnit(new Unit());                           
            refreshForm();                      
            Datos.setUnit(null);             //RESET DE LA VARIABLE
            setFormVisible(false);              //OCULTA EL FORMULARIO     
            tf_buscar.requestFocus();
        }
    }
    /**
     * 
     */
    private void botonOcultar(){
        tipoOperacion = 0;                  //OPERACION SOLO LECTURA
        //SE LIMPIA EL FORMULARIO
        tf_buscar.setVisible(false);
        Datos.setUnit(new Unit());                           
        refreshForm();                      
        Datos.setUnit(new Unit());    //RESET DE LA VARIABLE
        setFormVisible(false);              //OCULTA EL FORMULARIO
    }
    /**
     * 
     */
    private void botonImprimir(){
        tipoOperacion = 5;                  //OPERACION SOLO LECTURA
        Gui.getInstance().showPrint(ScreenName + " en Construcción");  
    }
    /**
     * Procedimiento que define los comportamientos en diversos Eventos 
     * de cada boton en la pantalla actual.
     */
    private void init_buttons(){
        /**
         * LINK PARA OCULTAR FORMULARIO
         */
        lb_ocultar.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){                        
                    botonOcultar();
                    
                }
            }
        });
        /**
         * SELECCION EN LA TABLA
         */
        tb_table.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() < 2){
                    selectedRow();
                }
            }
        });        
        /**
         * BOTON NUEVO
         */
        im_tool1.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonNuevo();
                }
            }
        });
        /**
         * BOTON EDITAR
         */
        im_tool2.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonEditar();
                }
            }
        });
        /**
         * BOTON GUARDAR
         */
        im_tool3.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonGuardar();
                }
            }
        });        
        /**
         * BOTON ELIMINAR
         */
        im_tool4.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonEliminar();
                }
            }
        });
        /**
         * BOTON IMPRIMIR
         */
        im_tool5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){   
                    botonImprimir();
                }
            }
        });
        /**
         * BOTON REGRESAR
         */
        im_tool6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonInicio();
                }
            }
        });
        /**
         * BOTON POR ASIGNAR
         */
        im_tool7.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON POR ASIGNAR
         */
        im_tool8.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON POR ASIGNAR
         */
        im_tool9.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //
                }
            }
        });
        /**
         * BOTON BUSCAR
         */
        im_tool12.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonBuscar();
                }
            }
        });
        /**
         * BOTON CHECK - Es utilizado para generar un nombre de usuario correcto, 
         * basado en los nombres y apellidos de la persona.
         */
        im_check.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    
                }
            }
        });                
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_nombre.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                //Valida que el evento se haya generado en el campo de busqueda
                if(((Node)ke.getSource()).getId().equals("tf_nombre")){
                    //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                    boolean boo = Ln.getInstance().check_Unit(tf_nombre.getText());
                    if(boo){
                        Gui.getInstance().showMessage("Ya existe la " + ScreenName + "!", "E");
                        botonInicio();
                    }
                }
            }
        });
    }   
    
    /***************************************************************************/
    /********************** METODOS DE INTERFAZ GRAFICA ************************/
    /***************************************************************************/
    
    /**
     * Metodo que permite cambiar la imagen del boton CheckUsername
     * @param boo TRUE si el UNIT esta validado
     */
    private void change_im_check(boolean boo){
        if(boo){    //IMAGEN SI EL UNIT ES CORRECTO
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN UNIT
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton CheckUserSupplier
     * @param boo TRUE si el UNIT esta validado
     */
    private void change_im_val(int boo){
        // 200 HTTP_request Ok
        if(boo == 200){    //IMAGEN SI EL UNIT ES CORRECTO
            im_val.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN UNIT
            im_val.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton Cambio de Status
     * @param boo 0 si esta DESHABILITADO, 1 si esta HABILITADO 
     */
    private void change_im_tool4(int boo){
        if(boo == 0){   //IMAGEN SI EL UNIT ESTA INHABILITADO
            im_tool4.setImage(new Image(getClass().getResourceAsStream("/Images/img07.png")));
        }else{          //IMAGEN PARA HABILITAR AL UNIT
            im_tool4.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }
    }
    /**
     * Metodo que establece el estado grafico del formulario, y mueve la tabla de datos
     * de posicion vertical
     * @param value TRUE si el formulario es Visible
     */
    private void setFormVisible(boolean value){
        vb_form.setVisible(value);  //Establece el estado grafico del formulario
        if(value){  //Si el estado es visible entonces 
            vb_table.relocate(30, 194);
            vb_table.setPrefHeight(388);
        }else{
            vb_table.relocate(30, 64);
            vb_table.setPrefHeight(508);
        }
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
