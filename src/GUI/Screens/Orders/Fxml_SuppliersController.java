/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.Orders;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Listeners.SelectKeyComboBoxListener;
import Objects.Setup.City;
import Objects.Setup.Country;
import Objects.Setup.GroupSupplier;
import Objects.Setup.Municipality;
import Objects.Setup.Parish;
import Objects.Setup.State;
import Objects.Orders.Supplier;
import Objects.Seniat.ValidateRif;
import Tools.Datos;
import Tools.HttpSeniat;
import Tools.ValidateTextFieldRif;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
public class Fxml_SuppliersController implements Initializable {

    @FXML 
    private AnchorPane ap_root; 
    
    @FXML 
    private ComboBox<State> cb_estado; 

    @FXML 
    private ComboBox<GroupSupplier> cb_grupo; 

    @FXML 
    private ComboBox<City> cb_localidad; 

    @FXML 
    private ComboBox<Municipality> cb_municipio; 

    @FXML 
    private ComboBox<Country> cb_pais; 

    @FXML 
    private ComboBox<Parish> cb_parroquia; 
    
    @FXML 
    private CheckBox ch_IvaAgent; 

    @FXML 
    private CheckBox ch_IvaCont; 

    @FXML 
    private CheckBox ch_t100; 

    @FXML 
    private CheckBox ch_t75; 
    
    @FXML 
    private HBox hb_1;

    @FXML 
    private HBox hb_2; 

    @FXML 
    private HBox hb_3; 

    @FXML 
    private HBox hb_4; 

    @FXML 
    private HBox hb_5; 

    @FXML 
    private HBox hb_7; 

    @FXML 
    private HBox hbox_toolbar; 

    @FXML 
    private ImageView im_check; 

    @FXML 
    private ImageView im_val; 
    
    @FXML 
    private ImageView im_tool1; 

    @FXML 
    private ImageView im_tool10; 

    @FXML 
    private ImageView im_tool11; 

    @FXML 
    private ImageView im_tool12; 

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
    private Label lb_Title; 

    @FXML 
    private Label lb_ocultar; 

    @FXML 
    private Label lb_cod; 

    @FXML 
    private TableView<Supplier> tb_table; 

    @FXML 
    private TextField tf_buscar; 

    @FXML 
    private TextField tf_celular; 

    @FXML 
    private TextField tf_contacto; 

    @FXML 
    private TextField tf_correo1; 
    
    @FXML 
    private TextField tf_correo2; 
    
    @FXML 
    private TextField tf_direccion; 

    @FXML 
    private TextField tf_fax; 

    @FXML 
    private TextField tf_firma; 

    @FXML 
    private TextField tf_nombre; 

    @FXML 
    private ValidateTextFieldRif tf_rif; 

    @FXML 
    private TextField tf_telefonos; 

    @FXML 
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
    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
    private static Integer[] toolsConfig;    
    private static String[] tooltips;
    
    private static final String ScreenName = "Proveedor";

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */     
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert cb_estado != null : "fx:id=\"cb_estado\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert cb_grupo != null : "fx:id=\"cb_grupo\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert cb_localidad != null : "fx:id=\"cb_localidad\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert cb_municipio != null : "fx:id=\"cb_municipio\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert cb_pais != null : "fx:id=\"cb_pais\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert cb_parroquia != null : "fx:id=\"cb_parroquia\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert ch_IvaAgent != null : "fx:id=\"ch_IvaAgent\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert ch_IvaCont != null : "fx:id=\"ch_IvaCont\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert ch_t100 != null : "fx:id=\"ch_t100\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert ch_t75 != null : "fx:id=\"ch_t75\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hb_1 != null : "fx:id=\"hb_1\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hb_2 != null : "fx:id=\"hb_2\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hb_3 != null : "fx:id=\"hb_3\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hb_4 != null : "fx:id=\"hb_4\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hb_5 != null : "fx:id=\"hb_5\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hb_7 != null : "fx:id=\"hb_7\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_check != null : "fx:id=\"im_check\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_val != null : "fx:id=\"im_val\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert lb_ocultar != null : "fx:id=\"lb_ocultar\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert lb_cod != null : "fx:id=\"lb_cod\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tb_table != null : "fx:id=\"tb_table\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_buscar != null : "fx:id=\"tf_buscar\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_celular != null : "fx:id=\"tf_celular\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_contacto != null : "fx:id=\"tf_contacto\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_correo1 != null : "fx:id=\"tf_correo1\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_correo2 != null : "fx:id=\"tf_correo2\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_direccion != null : "fx:id=\"tf_direccion\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_fax != null : "fx:id=\"tf_fax\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_firma != null : "fx:id=\"tf_firma\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_nombre != null : "fx:id=\"tf_nombre\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_rif != null : "fx:id=\"tf_rif\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert tf_telefonos != null : "fx:id=\"tf_telefonos\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert vb_form != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";
        assert vb_table != null : "fx:id=\"vb_table\" was not injected: check your FXML file 'Fxml_Supplier.fxml'.";

        //Inicializa la Barra de Herramientas y comportamiento del Boton de Busqueda
        defineToolBar();         
        defineBotonBuscar();    
        init_buttons();     //Establece los comportamientos de los botones
        botonInicio();      //Se imprime la pantalla Inicio
        
        //
        loadGroupSupplier();
        loadCountry();
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
        TableColumn col_status      = new TableColumn("Act");
        TableColumn col_rif_val     = new TableColumn("Sen");             
        TableColumn col_rif         = new TableColumn("Rif");                
        TableColumn col_nombre      = new TableColumn("Nombre Fiscal");        
        TableColumn col_firma       = new TableColumn("Firma");        
        TableColumn col_grupo       = new TableColumn("Grupo");
        TableColumn col_direccion   = new TableColumn("Dirección");        
        TableColumn col_ciudad      = new TableColumn("Ciudad");        
        TableColumn col_parroquia   = new TableColumn("Parroquia");        
        TableColumn col_municipio   = new TableColumn("Municipio");        
        TableColumn col_estado      = new TableColumn("Estado");        
        TableColumn col_pais        = new TableColumn("Pais");        
        TableColumn col_telefonos   = new TableColumn("Teléfonos");        
        TableColumn col_fax         = new TableColumn("Fax");        
        TableColumn col_contacto    = new TableColumn("Contacto");        
        TableColumn col_celular     = new TableColumn("Celular");        
        TableColumn col_correo      = new TableColumn("Correo");        
        TableColumn col_rlegal      = new TableColumn("Representante");        
        
        //Se establece el ancho de cada columna
        this.objectWidth(col_status     , 30 , 30);
        this.objectWidth(col_rif_val    , 30 , 30);   
        this.objectWidth(col_rif        , 80, 80);
        this.objectWidth(col_nombre     , 200, 350);
        this.objectWidth(col_grupo      , 100, 100);
        this.objectWidth(col_direccion  , 180, 350);
        this.objectWidth(col_ciudad     , 130, 200);
        this.objectWidth(col_parroquia  , 130, 200);
        this.objectWidth(col_municipio  , 130, 200);
        this.objectWidth(col_estado     , 130, 200);
        this.objectWidth(col_pais       , 130, 200);
        this.objectWidth(col_telefonos  , 100, 150);
        this.objectWidth(col_fax        , 100, 150);
        this.objectWidth(col_contacto   , 150, 200);
        this.objectWidth(col_celular    , 100, 150);
        this.objectWidth(col_correo     , 200, 250);
        this.objectWidth(col_rlegal     , 100, 150);
        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_status.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Supplier, Object>() {
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

        col_rif_val.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Supplier, Object>() {
                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        //Tipo de alineacion de la columna
                        //Si el valor NO esta vacio
                        if (!isEmpty()) {
                            int value = (Integer) item;     //Se obtiene el valor
                            switch(value){  
                                case 200:     //VALIDADO WEB SENIAT
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Images/img57.png"), 15, 15, false,false))); 
                                    break;
                                default:     //ERROR AL VALIDAR WEB SENIAT
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

        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_status.setCellValueFactory( 
                new PropertyValueFactory<>("status") );
        col_rif_val.setCellValueFactory( 
                new PropertyValueFactory<>("rif_val") );
        col_rif.setCellValueFactory( 
                new PropertyValueFactory<>("rif") );
        col_nombre.setCellValueFactory( 
                new PropertyValueFactory<>("nombre") );
        col_firma.setCellValueFactory( 
                new PropertyValueFactory<>("firma") );
        col_grupo.setCellValueFactory( 
                new PropertyValueFactory<>("groupsupplier") );
        col_direccion.setCellValueFactory( 
                new PropertyValueFactory<>("direccion") );
        col_ciudad.setCellValueFactory( 
                new PropertyValueFactory<>("city") );
        col_parroquia.setCellValueFactory( 
                new PropertyValueFactory<>("parish") );
        col_municipio.setCellValueFactory( 
                new PropertyValueFactory<>("municipality") );
        col_estado.setCellValueFactory( 
                new PropertyValueFactory<>("state") );
        col_pais.setCellValueFactory( 
                new PropertyValueFactory<>("country") );
        col_telefonos.setCellValueFactory( 
                new PropertyValueFactory<>("telefonos") );
        col_fax.setCellValueFactory( 
                new PropertyValueFactory<>("fax") );
        col_contacto.setCellValueFactory( 
                new PropertyValueFactory<>("contacto") );
        col_celular.setCellValueFactory( 
                new PropertyValueFactory<>("celular") );
        col_correo.setCellValueFactory( 
                new PropertyValueFactory<>("correo1") );
        col_rlegal.setCellValueFactory( 
                new PropertyValueFactory<>("rlegal") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(
                col_status, col_rif_val, col_rif, col_nombre, col_firma, col_grupo, 
                col_direccion, col_ciudad, col_parroquia, col_municipio, col_estado, 
                col_pais, col_telefonos, col_fax, col_contacto, col_celular, col_correo
                );                
        
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
    private boolean saveSupplier() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es un NUEVO proveedor 
        // 2 si es un proveedor MODIFICADO
        int proceso = tipoOperacion;
        
        //Se obtiene el rif y nombre del proveedor
        String supplierrif = tf_rif.getText();
        String suppliername = tf_nombre.getText();
        //Si el nombre de usuario no esta en blanco
        if((supplierrif != null && !supplierrif.equals("")) &&
           (suppliername != null && !suppliername.equals(""))){
            //Ejecuta los procesos predeterminados para el guardado del proveedor
            setCurrentOperation();
            //Se asignan los valores del objeto 
            Supplier supplier = new Supplier();
            supplier.setRif(tf_rif.getText().toUpperCase());
            if(proceso == 1){
                supplier.setRif_val(Datos.getStSeniat());
            }
            else{
                supplier.setRif_val(Datos.getSupplier().getRif_val());
            }
            if (ch_IvaAgent.isSelected()){
                supplier.setSen_areten(1);
            }
            else{
                supplier.setSen_areten(0);
            }
            if (ch_IvaCont.isSelected()){
                supplier.setSen_civa(1);
            }
            else{
                supplier.setSen_civa(0);
            }
            if (ch_t75.isSelected()){
                supplier.setSen_preten(75);
            }
            if (ch_t100.isSelected()){
                supplier.setSen_preten(100);
            }
            supplier.setNombre(tf_nombre.getText().toUpperCase());
            if (tf_firma.getText() != null){
                supplier.setFirma(tf_firma.getText().toUpperCase());
            }
            supplier.setDireccion(tf_direccion.getText());
            supplier.setTelefonos(tf_telefonos.getText());
            supplier.setFax(tf_fax.getText());
            supplier.setContacto(tf_contacto.getText());
            supplier.setCelular(tf_celular.getText());
            if (tf_correo1.getText() != null){
                supplier.setCorreo1(tf_correo1.getText().toLowerCase());
            }
            if (tf_correo2.getText() != null){
                supplier.setCorreo2(tf_correo2.getText().toLowerCase());
            }
            supplier.setStatus(Datos.getSupplier().getStatus());      //Se asigna el STATUS del proveedor

            //Se obtiene el Grupo del proveedor
            GroupSupplier groupsupplier = (GroupSupplier) cb_grupo.getValue();            
            if(groupsupplier == null){             //Si no existe un GroupSupplier seleccionado
                supplier.setGroupsupplier(null);   //Se establece la ScreenNameiable como NULA
            }
            else{  
                supplier.setGroupsupplier(groupsupplier);
            }            

            //Se obtiene el Pais 
            Country country = (Country) cb_pais.getValue();            
            if(country == null){             //Si no existe un Pais seleccionado
                supplier.setCountry(null);   //Se establece la ScreenNameiable como NULA
            }
            else{  
                supplier.setCountry(country);
            }            
            
            //Se obtiene el Estado 
            State state = (State) cb_estado.getValue();            
            if(state == null){             //Si no existe un Estado seleccionado
                supplier.setState(null);   //Se establece la ScreenNameiable como NULA
            }
            else{  
                supplier.setState(state);
            }            
            
            //Se obtiene la Ciudad
            City city = (City) cb_localidad.getValue();            
            if(city == null){             //Si no existe una Ciudad seleccionada
                supplier.setCity(null);   //Se establece la ScreenNameiable como NULA
            }
            else{  
                supplier.setCity(city);
            }            

            //Se obtiene el Municipio 
            Municipality municipality = (Municipality) cb_municipio.getValue();            
            if(municipality == null){             //Si no existe un Municipio seleccionado
                supplier.setMunicipality(null);   //Se establece la ScreenNameiable como NULA
            }
            else{  
                supplier.setMunicipality(municipality);
            }            
            
            //Se obtiene la Parroquia 
            Parish parish = (Parish) cb_parroquia.getValue();            
            if(parish == null){             //Si no existe una Parroquia seleccionada
                supplier.setParish(null);   //Se establece la ScreenNameiable como NULA
            }
            else{  
                supplier.setParish(parish);
            }            
            
            //Se llama al proceso de Guardado
            boolean result = 
                    Ln.getInstance().save_Supplier(supplier, proceso, ScreenName);
            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                Gui.getInstance().showMessage("El Proveeedor se ha Guardado Correctamente!", "I");
                loadSuppliers();            //Se Recarga la tabla de usuarios existentes
                return true;
            }     
        }else{                            
            Gui.getInstance().showMessage("No Existe ningun Proveeedor para ser Guardada!", "A");
        }
        return false;
    }
    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){   
        lb_cod.setText("ID Prov. " + String.valueOf(Datos.getSupplier().getIdSupplier()).trim());
        tf_rif.setText(Datos.getSupplier().getRif());
        tf_nombre.setText(Datos.getSupplier().getNombre());
        tf_firma.setText(Datos.getSupplier().getFirma());
        tf_direccion.setText(Datos.getSupplier().getDireccion());
        tf_telefonos.setText(Datos.getSupplier().getTelefonos());
        tf_fax.setText(Datos.getSupplier().getFax());
        tf_contacto.setText(Datos.getSupplier().getContacto());
        tf_celular.setText(Datos.getSupplier().getCelular());
        tf_correo1.setText(Datos.getSupplier().getCorreo1());
        tf_correo2.setText(Datos.getSupplier().getCorreo2());
        cb_grupo.setValue(Datos.getSupplier().getGroupsupplier());
        cb_pais.setValue(Datos.getSupplier().getCountry());
        cb_estado.setValue(Datos.getSupplier().getState());
        cb_localidad.setValue(Datos.getSupplier().getCity());
        cb_municipio.setValue(Datos.getSupplier().getMunicipality());
        cb_parroquia.setValue(Datos.getSupplier().getParish());
        
        if (Datos.getSupplier().getSen_areten() == 1){
            ch_IvaAgent.setSelected(true);
        }
        else{
            ch_IvaAgent.setSelected(false);
        }
        if (Datos.getSupplier().getSen_civa()== 1){
            ch_IvaCont.setSelected(true);
        }
        else{
            ch_IvaCont.setSelected(false);
        }
        switch (Datos.getSupplier().getSen_preten()){
            case 75:
                ch_t75.setSelected(true);
                ch_t100.setSelected(false);
                break;
            case 100:
                ch_t75.setSelected(false);
                ch_t100.setSelected(true);
                break;
        }
            
        
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
                tf_rif.setEditable(false);
                tf_nombre.setEditable(false);
                tf_direccion.setEditable(false);
                tf_telefonos.setEditable(false);
                tf_fax.setEditable(false);
                tf_contacto.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo1.setEditable(false);

                //  CheckBox con datos del ValidateRif
                ch_IvaAgent.setDisable(true);
                ch_IvaCont.setDisable(true);
                ch_t100.setDisable(true);
                ch_t75.setDisable(true);
                
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
                tf_rif.setEditable(true);
                tf_nombre.setEditable(true);
                tf_direccion.setEditable(true);
                tf_telefonos.setEditable(true);
                tf_fax.setEditable(true);
                tf_contacto.setEditable(true);
                tf_celular.setEditable(true);
                tf_correo1.setEditable(true);

                im_check.setVisible(true);
                im_val.setVisible(true);

                //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);                            
                break;
            case 2:  //EDITAR
//                lb_Title.setText(Tools.verticalText("EDITAR"));
                lb_Title.setText("EDITAR");
                tf_rif.setEditable(false);
                tf_nombre.setEditable(true);
                tf_direccion.setEditable(true);
                tf_telefonos.setEditable(true);
                tf_fax.setEditable(true);
                tf_contacto.setEditable(true);
                tf_celular.setEditable(true);
                tf_correo1.setEditable(true);

                im_check.setVisible(true);
                im_val.setVisible(true);
                
                //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);            
                break;
            case 3:  //GUARDAR
                tf_rif.setEditable(false);
                tf_nombre.setEditable(false);
                tf_direccion.setEditable(false);
                tf_telefonos.setEditable(false);
                tf_fax.setEditable(false);
                tf_contacto.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo1.setEditable(false);

                im_check.setVisible(false);
                im_val.setVisible(false);

                //SE PERMITE: GUARDAR Y CANCELAR
                disables = new Integer[]{0,1,3,4,6,7,8,9,10,11};
                disableAllToolBar(disables);   
                break;
            case 4:  //CAMBIAR STATUS         
                tf_rif.setEditable(false);
                tf_nombre.setEditable(false);
                tf_direccion.setEditable(false);
                tf_telefonos.setEditable(false);
                tf_fax.setEditable(false);
                tf_contacto.setEditable(false);
                tf_celular.setEditable(false);
                tf_correo1.setEditable(false);

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
    private void loadSuppliers(){        
        Datos.setRep_supplier(Ln.getInstance().load_Supplier());
        loadTable(Datos.getRep_supplier());    
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(Supplier[] suppliers){    
        if(suppliers != null){
            ObservableList<Supplier> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(suppliers));   
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
        Supplier supplier = tb_table.getSelectionModel().getSelectedItem();          
        if(supplier != null){
            Datos.setSupplier(supplier);          //Asigno el Usuario a la Clase de Datos Globales
            change_im_val(supplier.getRif_val(), im_val); 
            change_im_tool4(supplier.getStatus());   //Se define el valor del Boton de Cambio se Status
            refreshForm();                      //Refresca el Formulario
            setFormVisible(true);               //Coloca Visible el formulario
        }
    }
    /**
     * Procedimiento que obtiene los Distintos Tipo de Proveedor de la BD
     * y los carga en el COMBOBOX
     */
    private void loadGroupSupplier(){        
        GroupSupplier[] groupsupplier = Ln.getInstance().load_GroupSupplier();        
        final ObservableList<GroupSupplier> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(groupsupplier));          
        cb_grupo.setItems(data); 
//        CbGroupSupplierKeyHandler cbkh = new CbGroupSupplierKeyHandler(data);
//        cb_grupo.setOnKeyReleased(cbkh);
        Datos.setCbGroupSupplier(cb_grupo);                       
        new SelectKeyComboBoxListener(cb_grupo); 
    }  
    /**
     * Procedimiento que obtiene los Distintos Paises de la BD
     * y los carga en el COMBOBOX
     */
    private void loadCountry(){        
        //Se solicitan los roles en la BD
        Country[] country = Ln.getInstance().load_Country();        
        final ObservableList<Country> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(country));          
        cb_pais.setItems(data); 
        //Instancia el manejador de eventos para el acceso rapido de los datos
//        CbCountryKeyHandler cbkh = new CbCountryKeyHandler(data);   
//        cb_pais.setOnKeyReleased(cbkh);   //Asigno el manejador al COMBOBOX
        Datos.setCbCountry(cb_pais);          //Asigna los valores en la clase de Datos Global             
        new SelectKeyComboBoxListener(cb_pais); 
    }     
    /**
     * Procedimiento que obtiene los Distintos Estados de la BD
     * y los carga en el COMBOBOX
     * param: nombre del pais
     */
    private void loadState(){ 
        State[] state = Ln.getInstance().find_State(cb_pais.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<State> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(state));          
        cb_estado.setItems(data); 
//        CbStateKeyHandler cbkh = new CbStateKeyHandler(data);
//        cb_estado.setOnKeyReleased(cbkh);
        Datos.setCbState(cb_estado);                       
        new SelectKeyComboBoxListener(cb_estado); 
    }    
    /**
     * Procedimiento que obtiene las Distintas Ciudades de la BD
     * y los carga en el COMBOBOX
     * param: nombre del estado
     */
    private void loadCity(){        
        City[] city = Ln.getInstance().find_City(cb_estado.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<City> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(city));          
        cb_localidad.setItems(data); 
//        CbCityKeyHandler cbkh = new CbCityKeyHandler(data);
//        cb_localidad.setOnKeyReleased(cbkh);
        Datos.setCbCity(cb_localidad);                       
        new SelectKeyComboBoxListener(cb_localidad); 
    }    
    /**
     * Procedimiento que obtiene los Distintos Municipios de la BD
     * y los carga en el COMBOBOX
     * param: nombre de la ciudad
     */
    private void loadMunicipality(){        
        Municipality[] municipality = Ln.getInstance().find_Municipality(cb_localidad.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<Municipality> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(municipality));          
        cb_municipio.setItems(data); 
//        CbMunicipalityKeyHandler cbkh = new CbMunicipalityKeyHandler(data);
//        cb_municipio.setOnKeyReleased(cbkh);
        Datos.setCbMunicipality(cb_municipio);                       
        new SelectKeyComboBoxListener(cb_municipio); 
    }    
    /**
     * Procedimiento que obtiene las Distintas Parroquias de la BD
     * y los carga en el COMBOBOX
     * param: nombre de la ciudad
     */
    private void loadParish(){        
        Parish[] parish = Ln.getInstance().find_Parish(
                cb_municipio.getSelectionModel().getSelectedItem().toString(),
                cb_estado.getSelectionModel().getSelectedItem().toString());        
        final ObservableList<Parish> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(parish));          
        cb_parroquia.setItems(data); 
//        CbParishKeyHandler cbkh = new CbParishKeyHandler(data);
//        cb_parroquia.setOnKeyReleased(cbkh);
        Datos.setCbParish(cb_parroquia);                       
        new SelectKeyComboBoxListener(cb_parroquia); 
    } 
    /**
     * Procedimiento de validación Rif
     */
    private void loadSeniatRif(){        
        ValidateRif seniat = null;
        try {
            /**
             * conexion al servidor de seniat
             * param: nro de Rif
             * 200: Rif valido
             * 404: URL no encontrado
             * 450: Rif no es valido
             * 452: Rif no esta registrado
             */
            seniat = HttpSeniat.getHttpSeniat(tf_rif.getText());
            Datos.setStSeniat(seniat.getStatus());

            tf_nombre.setText("");
            ch_IvaAgent.setSelected(false);
            ch_IvaCont.setSelected(false);
            ch_t100.setSelected(false);
            ch_t75.setSelected(false);

            change_im_check(true);
            change_im_val(Datos.getStSeniat(), im_val);  //Se define el valor del Boton de Cambio se Status

            switch (Datos.getStSeniat()){
                case 200:
                    tf_nombre.setText(seniat.getNombre());
                    tf_nombre.setDisable(true);

                    if(seniat.getIva_agen().equals("SI"))
                        ch_IvaAgent.setSelected(true);

                    if(seniat.getIva_cont().equals("SI"))
                        ch_IvaCont.setSelected(true);

                    switch (seniat.getTasa()){
                        case 100:
                            ch_t100.setSelected(true);
                            break;
                        case 75:
                            ch_t75.setSelected(true);
                            break;
                    }
                    cb_grupo.requestFocus();
                    break;
                case 450:
                    tf_nombre.setDisable(false);
                    break;
                case 452:
                    tf_nombre.setDisable(false);
                    break;

            }
        } catch (Exception e) {
            Gui.getInstance().showMessage("Error en conexion: \n"+e.getMessage(), "E");                    
        }
    } 
    /**
     * Procedimiento de validación de telefonos
     * @param phoneNumber
     * @return 
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;

        String expression = "^[0]{1}[0-9]{3}[-][0-9]{7}";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    /**
     * Procedimiento de validación de correo
     * @param email
     * @return 
     */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
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
                    tf_rif, cb_grupo, tf_nombre, tf_firma, tf_direccion, cb_pais, 
                    cb_estado, cb_localidad, cb_municipio, cb_parroquia, 
                    tf_telefonos, tf_fax, tf_celular, tf_contacto, tf_correo1,
                    tf_correo2};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_rif, cb_grupo, tf_nombre, tf_firma, tf_direccion, 
                    cb_pais, cb_estado, cb_localidad, cb_municipio, cb_parroquia, 
                    tf_telefonos, tf_fax, tf_celular, tf_contacto, tf_correo1,
                    tf_correo2};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_rif, cb_grupo, tf_nombre, tf_firma, tf_direccion, 
                    cb_pais, cb_estado, cb_localidad, cb_municipio, cb_parroquia, 
                    tf_telefonos, tf_fax, tf_celular, tf_contacto, tf_correo1,
                    tf_correo2};
                break;
        }             
        switch (opc){
            case 1: 
            case 2: 
            case 3:
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
                            Datos.setRep_supplier(Ln.getInstance().find_Supplier(tf_buscar.getText()));
                            loadTable(Datos.getRep_supplier());     
                        } catch(Exception e){
                            Gui.getInstance().showMessage("El Proveedor NO existe!", "A");
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
        Datos.setSupplier(new Supplier());                           
        refreshForm();                      
        Datos.setSupplier(null);             //RESET DE LA VARIABLE
        setFormVisible(false);               //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadSuppliers();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            change_im_check(false);
            loadSuppliers();
            Datos.setSupplier(new Supplier());
            refreshForm();
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        if(Datos.getSupplier()!= null && toolsConfig[3]==1){
            tipoOperacion = 2;
            if(Datos.getSupplier().getRif_val() == 200)
                change_im_check(true); 
            else 
                change_im_check(false); 
            //changeIcon4(Datos.getSupplier().getStatus());
            refreshForm();
            setFormVisible(true);     
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonGuardar(){        
        if(Datos.getSupplier() != null && toolsConfig[4]==1){
            boolean result = saveSupplier();
            if (result)
                botonInicio();
        }
    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getSupplier()!= null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            change_im_check(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL SUPPLIER                   
            refreshForm();         
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getSupplier().getStatus() == 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " el " + ScreenName + " " + Datos.getSupplier().getRif() + " ?";
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
            Datos.setSupplier(new Supplier());                           
            refreshForm();                      
            Datos.setSupplier(null);             //RESET DE LA VARIABLE
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
        Datos.setSupplier(new Supplier());                           
        refreshForm();                      
        Datos.setSupplier(new Supplier());    //RESET DE LA VARIABLE
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
                if((mouseEvent.getClickCount() < 2) && (tipoOperacion != 0)){
                    boolean boo = Ln.getInstance().check_Supplier(tf_rif.getText());
                    //Si el resultado el rif del proveedor ya Existe
                    if(Datos.getStSeniat() != 200)
                        boo = false;
                    
                    if(boo){
                        Gui.getInstance().showMessage("Ya existe el Proveedor, no puede ser Guardado!", "A");
                        botonInicio();
                    }else{                                  //Si el nombre de usuario no existe
                        loadSeniatRif();
                    }
                }        
            }
        });                
        /**
         * metodo para mostrar el item (pais) seleccionado y cargar los estados
         * param: nombre del pais
         */
        cb_pais.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Country> arg0, Country arg1, Country arg2) -> {
            if (arg2 != null)
                loadState();
        });        
        new SelectKeyComboBoxListener(cb_pais); 
        /**
         * metodo para mostrar el item (estado) seleccionado y cargar las ciudades
         * param: nombre del estado
         */
        cb_estado.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends State> arg0, State arg1, State arg2) -> {
            if (arg2 != null)
                loadCity();
        });
        new SelectKeyComboBoxListener(cb_estado); 
        /**
         * metodo para mostrar el item (localidad) seleccionado y cargar los municipios
         * param: nombre de la ciudad
         */
        cb_localidad.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends City> arg0, City arg1, City arg2) -> {
            if (arg2 != null)
                loadMunicipality();
        });
        new SelectKeyComboBoxListener(cb_localidad); 
        /**
         * metodo para mostrar el item (municipio) seleccionado y cargar las parroquias
         * param: nombre de la ciudadd
         */
        cb_municipio.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Municipality> arg0, Municipality arg1, Municipality arg2) -> {
            if (arg2 != null)
                loadParish();
        });
        new SelectKeyComboBoxListener(cb_municipio); 
        /**
         * metodo para mostrar buscar el nro de RIF
         * param: ENTER O TAB
         */
        tf_rif.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_rif.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_rif") &&
                            (tf_rif.getText().length() > 1)){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = Ln.getInstance().check_Supplier(tf_rif.getText());
                        //Si el resultado el rif del proveedor ya Existe
                        if(Datos.getStSeniat() != 200)
                            boo = false;

                        if(boo){
                            Gui.getInstance().showMessage("Ya existe el Proveedor, no puede ser Guardado!", "A");
                            botonInicio();
                        }else{                                  //Si el nombre de usuario no existe
                            if(!tf_rif.getText().toUpperCase().substring(0, 1).equals("I"))
                                loadSeniatRif();
                        }
                    }
                }
                else{
                    Gui.getInstance().showMessage("Indicar el Rif del Proveedor!", "A");
                    tf_rif.requestFocus();
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_telefonos.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_telefonos.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_telefonos") &&
                            (tf_telefonos.getText().length() > 1) && 
                            (!tf_rif.getText().toUpperCase().substring(0, 1).equals("I"))){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = isPhoneNumberValid(tf_telefonos.getText());
                        
                        if(!boo){
                            Gui.getInstance().showMessage("El nro. de Telefono no cumple el formato (0000-0000000)!", "A");
                            tf_telefonos.requestFocus();
                        }
                    }
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_fax.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_fax.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_fax") &&
                            (tf_fax.getText().length() > 1) && 
                            (!tf_rif.getText().toUpperCase().substring(0, 1).equals("I"))){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = isPhoneNumberValid(tf_fax.getText());
                        
                        if(!boo){
                            Gui.getInstance().showMessage("El nro. de Telefono no cumple el formato (0000-0000000)!", "A");
                            tf_fax.requestFocus();
                        }
                    }
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_celular.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_celular.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_celular") &&
                            (tf_celular.getText().length() > 1) && 
                            (!tf_rif.getText().toUpperCase().substring(0, 1).equals("I"))){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = isPhoneNumberValid(tf_celular.getText());
                        
                        if(!boo){
                            Gui.getInstance().showMessage("El nro. de Telefono no cumple el formato (0000-0000000)!", "A");
                            tf_celular.requestFocus();
                        }
                    }
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_correo1.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_correo1.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_correo1") &&
                            (tf_correo1.getText().length() > 1)){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = isEmailValid(tf_correo1.getText());
                        
                        if(!boo){
                            Gui.getInstance().showMessage("El Correo Electrónico no cumple el formato (usuario@dominio.com)!", "A");
                            tf_correo1.requestFocus();
                        }
                    }
                }
            }
        });
        /**
         * metodo para mostrar buscar el nro de ci
         * param: ENTER O TAB
         */
        tf_correo2.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.TAB)){
                if (!tf_correo2.getText().isEmpty()){
                    if(((Node)ke.getSource()).getId().equals("tf_correo2") &&
                            (tf_correo2.getText().length() > 1)){
                        //Solicita los datos y envia la Respuesta a imprimirse en la Pantalla
                        boolean boo = isEmailValid(tf_correo2.getText());
                        
                        if(!boo){
                            Gui.getInstance().showMessage("El Correo Electrónico no cumple el formato (usuario@dominio.com)!", "A");
                            tf_correo2.requestFocus();
                        }
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
     * @param boo TRUE si el MEASURE esta validado
     */
    private void change_im_check(boolean boo){
        if(boo){    //IMAGEN SI EL MEASURE ES CORRECTO
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN MEASURE
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton CheckUserSupplier
     * @param boo TRUE si el VEHICULO esta validado
     */
    private void change_im_val(int boo, ImageView im_obj){
        if(boo == 200){    //IMAGEN SI EL VEHICULO ES CORRECTO
            im_obj.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN VEHICULO
            im_obj.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen del boton Cambio de Status
     * @param boo 0 si esta DESHABILITADO, 1 si esta HABILITADO 
     */
    private void change_im_tool4(int boo){
        if(boo == 0){   //IMAGEN SI EL USUARIO ESTA INHABILITADO
            im_tool4.setImage(new Image(getClass().getResourceAsStream("/Images/img07.png")));
        }else{          //IMAGEN PARA HABILITAR AL USUARIO
            im_tool4.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }
    }
    /**
     * Metodo que permite cambiar la imagen Status por la Fecha del documento
     * @param sta si esta VENCIDO, 1 si esta X VENCER 
     * @param dia si esta <46 alerta al usuario
     * @param ima si esta OBJETO
     */
    private void changeIconDate(String sta, Integer dia, ImageView ima){
        switch (sta){
            case "vencido":
                ima.setImage(new Image(getClass().getResourceAsStream("/Images/img61a.png")));
                break;
            case "x vencer":
                if (dia < 46)
                    ima.setImage(new Image(getClass().getResourceAsStream("/Images/img59a.png")));
                else
                    ima.setImage(new Image(getClass().getResourceAsStream("/Images/img57a.png")));
                break;
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
            vb_table.relocate(30, 429); //389
            vb_table.setPrefHeight(138); //178
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

    /**
     * 
     */
    public static void refreshIdBusqueda(){
        //tf_chofer.setText(Gui.getIdBusqueda());
    }
}
