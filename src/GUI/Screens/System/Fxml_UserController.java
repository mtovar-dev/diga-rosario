/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens.System;

import GUI.Gui;
import LN.Ln;
import Listeners.FocusPropertyChangeListener;
import Listeners.SelectKeyComboBoxListener;
import Objects.System.Rol;
import Objects.System.Usuario;
import Tools.Datos;
import Tools.Tools;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
 * FXML Controller class
 *
 * @author ARMGARCES
 */
public class Fxml_UserController implements Initializable{

    @FXML //  fx:id="ap_root"
    private AnchorPane ap_root; // Value injected by FXMLLoader
    
    @FXML //  fx:id="hb_2"
    private HBox hb_2; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_3"
    private HBox hb_3; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_4"
    private HBox hb_4; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_5"
    private HBox hb_5; // Value injected by FXMLLoader
    
    @FXML //  fx:id="hb_6"
    private HBox hb_6; // Value injected by FXMLLoader
    
    @FXML //  fx:id="hb_7"
    private HBox hb_7; // Value injected by FXMLLoader
    
    @FXML //  fx:id="hb_lastname"
    private HBox hb_lastname; // Value injected by FXMLLoader
    
    @FXML //  fx:id="hbox_toolbar"
    private HBox hbox_toolbar; // Value injected by FXMLLoader

    @FXML //  fx:id="im_tool1"
    private ImageView im_tool1; // Value injected by FXMLLoader

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
    
    @FXML //  fx:id="im_tool10"
    private ImageView im_tool10; // Value injected by FXMLLoader
    
    @FXML //  fx:id="im_tool11"
    private ImageView im_tool11; // Value injected by FXMLLoader
    
    @FXML //  fx:id="im_tool12"
    private ImageView im_tool12; // Value injected by FXMLLoader
    
    @FXML //  fx:id="im_check"
    private ImageView im_check; // Value injected by FXMLLoader
    
    @FXML //  fx:id="nomb01"
    private TextField tf_nomb01; // Value injected by FXMLLoader

    @FXML //  fx:id="nomb02"
    private TextField tf_nomb02; // Value injected by FXMLLoader

    @FXML //  fx:id="apel01"
    private TextField tf_apel01; // Value injected by FXMLLoader

    @FXML //  fx:id="apel02"
    private TextField tf_apel02; // Value injected by FXMLLoader
    
    @FXML //  fx:id="lb_Title"
    private Label lb_Title; // Value injected by FXMLLoader
    
    @FXML //  fx:id="lb_lastname"
    private Label lb_lastname; // Value injected by FXMLLoader
    
    @FXML //  fx:id="hb_pswd01"
    private HBox hb_pswd01; // Value injected by FXMLLoader

    @FXML //  fx:id="hb_pswd02"
    private HBox hb_pswd02; // Value injected by FXMLLoader
    
    @FXML //  fx:id="pswd01"
    private PasswordField pf_pswd01; // Value injected by FXMLLoader

    @FXML //  fx:id="pswd02"
    private PasswordField pf_pswd02; // Value injected by FXMLLoader

    @FXML //  fx:id="pf_old"
    private PasswordField pf_old; // Value injected by FXMLLoader
    
    @FXML //  fx:id="roles"
    private ComboBox<Rol> cb_roles; // Value injected by FXMLLoader

    @FXML //  fx:id="username"
    private TextField tf_username; // Value injected by FXMLLoader
    
    @FXML //  fx:id="tf_buscar"
    private TextField tf_buscar; // Value injected by FXMLLoader
        
    @FXML //  fx:id="tb_table"
    private TableView<Usuario> tb_table; // Value injected by FXMLLoader
    
    @FXML //  fx:id="lb_ocultar"
    private Label lb_ocultar; // Value injected by FXMLLoader
    
    @FXML //  fx:id="vb_form"
    private VBox vb_form; // Value injected by FXMLLoader

    @FXML //  fx:id="vb_table"
    private VBox vb_table; // Value injected by FXMLLoader
    
    private static int tipoOperacion;    
    private static ImageView[] tools;    
//    private ObservableList<Rol> roles;
    private static Integer[] toolsConfig; 
    private static String[] tooltips;
    
    private static final String ScreenName = "Usuario";

    /**
     * Initializes the controller class.
     * @param fxmlFileLocation
     * @param resources
     */ 
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {        
        // TODO
        assert ap_root != null : "fx:id=\"ap_root\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_2 != null : "fx:id=\"hb_2\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_3 != null : "fx:id=\"hb_3\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_4 != null : "fx:id=\"hb_4\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_5 != null : "fx:id=\"hb_5\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_6 != null : "fx:id=\"hb_6\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_7 != null : "fx:id=\"hb_7\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert lb_Title != null : "fx:id=\"lb_Title\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hb_lastname != null : "fx:id=\"hb_lastname\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert hbox_toolbar != null : "fx:id=\"hbox_toolbar\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool1 != null : "fx:id=\"im_tool1\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool2 != null : "fx:id=\"im_tool2\" was not injected: check your FXML file 'Fxml_User.fxml'.";     
        assert im_tool3 != null : "fx:id=\"im_tool3\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool4 != null : "fx:id=\"im_tool4\" was not injected: check your FXML file 'Fxml_User.fxml'.";  
        assert im_tool5 != null : "fx:id=\"im_tool5\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool6 != null : "fx:id=\"im_tool6\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool7 != null : "fx:id=\"im_tool7\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool8 != null : "fx:id=\"im_tool8\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool9 != null : "fx:id=\"im_tool9\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool10 != null : "fx:id=\"im_tool10\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool11 != null : "fx:id=\"im_tool11\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert im_tool12 != null : "fx:id=\"im_tool12\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert tf_nomb01 != null : "fx:id=\"nomb01\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert tf_nomb02 != null : "fx:id=\"nomb02\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert tf_apel01 != null : "fx:id=\"apel01\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert tf_apel02 != null : "fx:id=\"apel02\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert pf_pswd01 != null : "fx:id=\"pswd01\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert pf_pswd02 != null : "fx:id=\"pswd02\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert pf_old != null : "fx:id=\"pf_old\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert cb_roles != null : "fx:id=\"roles\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert tf_username != null : "fx:id=\"username\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        assert vb_table != null : "fx:id=\"vb_form\" was not injected: check your FXML file 'Fxml_User.fxml'.";
        
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
//                   botonUpdPswd();
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT6)){                     
//                   //IMPRIMIR
//               }
//               if (ke.isAltDown() && ke.getCode().equals(KeyCode.DIGIT7)){                     
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
        TableColumn col_usuario   = new TableColumn("Usuario");                
        TableColumn col_nombre1   = new TableColumn("Nombre");             
        TableColumn col_nombre2   = new TableColumn("2do Nombre");        
        TableColumn col_apellido1 = new TableColumn("Apellido");        
        TableColumn col_apellido2 = new TableColumn("2do Apellido");        
        TableColumn col_rol       = new TableColumn("Rol");
        TableColumn col_status    = new TableColumn("");
        //Se establece el ancho de cada columna
        this.objectWidth(col_usuario  , 100, 140);
        this.objectWidth(col_nombre1  , 100, 140);   
        this.objectWidth(col_nombre2  , 100, 140);
        this.objectWidth(col_apellido1, 100, 140);
        this.objectWidth(col_apellido2, 100, 140);
        this.objectWidth(col_rol      , 150, 150);
        this.objectWidth(col_status   , 25 , 25);
        /**
         * Sobreescritura de un metodo de la Columna, para sustituir el valor numerico 
         * del STATUS del usuario por una Imagen segun el valor
         * 1 - VERDE (HABILITADO)
         * 2 - ROJO  (DESHABILITADO)
         */
        col_status.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<Usuario, Object>() {
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
        //Se define la columna de la tabla con el nombre del atributo del objeto USUARIO correspondiente
        col_usuario.setCellValueFactory( 
                new PropertyValueFactory<>("username") );
        col_nombre1.setCellValueFactory( 
                new PropertyValueFactory<>("nombre1") );
        col_nombre2.setCellValueFactory( 
                new PropertyValueFactory<>("nombre2") );
        col_apellido1.setCellValueFactory( 
                new PropertyValueFactory<>("apellido1") );
        col_apellido2.setCellValueFactory( 
                new PropertyValueFactory<>("apellido2") );
        col_rol.setCellValueFactory( 
                new PropertyValueFactory<>("rol") );
        col_status.setCellValueFactory( 
                new PropertyValueFactory<>("status") );
        
        //Se Asigna ordenadamente las columnas de la tabla
        tb_table.getColumns().addAll(col_status, col_usuario, col_nombre1, col_nombre2, col_apellido1, col_apellido2, col_rol);      

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
     * Metodo que genera, verifica y consulta un nombre de usuario
     * para crear un NUEVO usuario
     */
    private void createUserName() {        
        //Obtiene la primera letra del nombre
        String username = tf_nomb01.getText().substring(0,1);
        //Si tiene segundo nombre entonces obtiene la primera letra del segundo nombre
        if(tf_nomb02.getText() != null){
            //Se concatena la letra del segundo nombre a la ScreenNameiable
            username += tf_nomb02.getText().substring(0,1);
        }
        //Se concatena el apellido completo a la ScreenNameiable
        username += tf_apel01.getText();        
        tf_username.setText(username);      //Se Asigna el valor resultado al Campo de Texto
        //Se llama al proceso de Verificacion
        boolean boo = Ln.getInstance().check_UserName(username);                
        boolean stop = true;        //Valor logico de parada
        //Si el resultado el nombre de usuario ya Existe
        if(boo){
            int j = 1;      //Se inicializa un contador
            do{
                //Se llama al proceso de Verificacion con el nuevo valor
                stop = Ln.getInstance().check_UserName(username+j);    
                //Si el valor tampoco existe entonces
                if(!stop){
                    username = username+j;      //Asigno el valor a la ScreenNameiable del resultado
                    change_im_check(!stop);          //Se cambia el icono de verificacion de nombre de usuario
                }
                j++;                            //aumento en 1 el contador
            }while(j < 3 && stop);              //Ejecutar el ciclo maximo 2 veces y para si se obtiene resultado
            //Si el ciclo se ejecuto mas de dos veces
            if(j > 3){
                //Levanta una ventana con mensaje de ERROR
                Gui.getInstance().showMessage("Por Favor Contacte a Sistemas!", "E");
            }
            //Se Asigna el valor resultado al Campo de Texto
            tf_username.setText(username);      
        }else{                                  //Si el nombre de usuario no existe
            change_im_check(!boo);                   //Se cambia el icono de verificacion de nombre de usuario
        }        
    }  
    /**
     * Metodo encargado de guardar los datos de un nuevo usuario o de un 
     * usuario modificado
     */
    private boolean saveUser() {
        //Se asigna el valor del tipo de procedimiento que viene de ser ejecutado,
        // 1 si es un NUEVO usuario 
        // 2 si es un usuario MODIFICADO
        int proceso = tipoOperacion;    
        //Se obtiene el nombre de usuario
        String username = tf_username.getText();
        //Si el nombre de usuario no esta en blanco
        if(username != null && !username.equals("")){
            //Si existe un rol seleccionado
            if(cb_roles.getSelectionModel().getSelectedItem() != null){
            //Se establece la operacion de guardado
            tipoOperacion = 3;
            //Ejecuta los procesos predeterminados para el guardado del usuario
            setCurrentOperation();
            //Se asignan los valores del objeto 
            Usuario usuario = new Usuario();
            usuario.setUsername(tf_username.getText());
            usuario.setNombre1(tf_nomb01.getText());
            if ((tf_nomb02.getText() != null) && (!tf_nomb02.getText().isEmpty()))
                usuario.setNombre2(tf_nomb02.getText());
            //usuario.setNombre2(tf_nomb02.getText());
            usuario.setApellido1(tf_apel01.getText());
            if ((tf_apel02.getText() != null) && (!tf_apel02.getText().isEmpty()))
                usuario.setApellido2(tf_apel02.getText());
            //usuario.setApellido2(tf_apel02.getText());
            String pswd = "";
            
            if(proceso == 1){   //Si es un Usuario NUEVO
                usuario.setPswd_old(pf_pswd01.getText());
                pswd = pf_pswd02.getText();
            }else{              //Si es un Usuario MODIFICADO                
                usuario.setPswd_old(Datos.getUsuario().getPswd_old());
                pswd = Datos.getUsuario().getPswd_old();
            }            
            //Se obtiene el ROL del usuario
            Rol rol = (Rol) cb_roles.getValue();            
            if(rol == null){            //Si no existe un ROL seleccionado
                usuario.setRol(null);   //Se establece la ScreenNameiable como NULA
            }else{  
                usuario.setRol(rol);
            }            
            usuario.setStatus(Datos.getUsuario().getStatus());      //Se asigna el STATUS del usuario
            //Se llama al proceso de Guardado
            boolean result = 
                    Ln.getInstance().save_Usuario(usuario, pswd, proceso, ScreenName);
            //Si el Resultado es correcto
            if(result){
                //Se Notifica al usuario
                Gui.getInstance().showMessage("El " + ScreenName + " se ha Guardado Correctamente!", "I");
                loadUsers();            //Se Recarga la tabla de usuarios existentes
                return true;
            }     
            }else{  
                Gui.getInstance().showMessage("Se debe asignar un " + ScreenName + " al Usuario!", "A");
            }
        }else{                            
            Gui.getInstance().showMessage("No Existe ningun " + ScreenName + " para ser Guardado!", "A");
        }
        return false;
    }
    /**
     * Procedimiento que manda a guardar el cambio de contraseña del usuario
     */
    private boolean updatePswd() {        
        String username = tf_username.getText();    //Se obtiene el nombre de usuario
        //Si el nombre de usuario no esta en blanco
        if(username != null && !username.equals("")){
            
            tipoOperacion = 3;      //GUARDAR
            //Ejecuta los procesos predeterminados para el guardado del cambio de contraseña
            setCurrentOperation();  
            //Se asignan los valores del objeto 
            Usuario usuario = new Usuario();
            usuario.setUsername(tf_username.getText());
            usuario.setPswd_old(pf_old.getText());
            usuario.setPswd_new(pf_pswd02.getText());
            //Se llama al procedimiento que almacena los datos
            boolean result = Ln.getInstance().update_UserPswd(usuario,pf_old.getText(),pf_pswd02.getText());
            //Si el resultado es correcto
            if(result){
                //Llamado a una Ventana de Mensaje
                Gui.getInstance().showMessage("La Nueva Contraseña se ha Guardado Correctamente!", "I");
                //Se cargan los Usuarios en la Tabla
                loadUsers();
                return true;
            }     
            
        }else{  //Si Existe algun error 
            //Se levanta una ventana de Error
            Gui.getInstance().showMessage("No Existe ningun " + ScreenName + " para ser Modificado!", "E");
        }
        return false;
    }   
    /**
     * Procedimiento encargado de refrescar el formulario de la pantalla,
     * establece nuevos valores a cada campo de Texto
     */
    private void refreshForm(){        
        tf_username.setText(Datos.getUsuario().getUsername());
        tf_nomb01.setText(Datos.getUsuario().getNombre1());
        tf_nomb02.setText(Datos.getUsuario().getNombre2());
        tf_apel01.setText(Datos.getUsuario().getApellido1());
        tf_apel02.setText(Datos.getUsuario().getApellido2());
        pf_pswd01.setText("");
        pf_pswd02.setText("");               
        pf_old.setText("");
        cb_roles.getSelectionModel().select(Datos.getUsuario().getRol());      
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
            tf_username.setEditable(false);
            tf_nomb01.setEditable(false);
            tf_nomb02.setEditable(false);
            tf_apel01.setEditable(false);
            tf_apel02.setEditable(false);
            cb_roles.setDisable(true);             
            //SE PERMITE: NUEVO, CANCELAR Y BUSCAR
            disables = new Integer[]{2,7,8,9,10};
            disableAllToolBar(disables); 
            hb_7.setTranslateY(-80);
            hb_7.setVisible(true);
            break;
        case 1:  //NUEVO
            lb_Title.setText(Tools.verticalText("NUEVO"));
            tf_username.setEditable(false);
            tf_nomb01.setEditable(true);
            tf_nomb02.setEditable(true);
            tf_apel01.setEditable(true);
            tf_apel02.setEditable(true);
            cb_roles.setDisable(false);
            //SE PERMITE: NUEVO,GUARDAR Y CANCELAR             
            disables = new Integer[]{0,1,3,4,5,7,8,9,10,11};
            disableAllToolBar(disables);                            
            break;
        case 2:  //EDITAR
            lb_Title.setText(Tools.verticalText("EDITAR"));
            tf_username.setEditable(false);
            tf_nomb01.setEditable(true);
            tf_nomb02.setEditable(true);
            tf_apel01.setEditable(true);
            tf_apel02.setEditable(true);
            cb_roles.setDisable(false);
            //SE PERMITE: EDITAR,GUARDAR Y CANCELAR
            disables = new Integer[]{0,1,3,4,5,7,8,9,10,11};
            disableAllToolBar(disables);            
            break;
        case 3:  //GUARDAR
            tf_username.setEditable(false);
            tf_nomb01.setEditable(false);
            tf_nomb02.setEditable(false);
            tf_apel01.setEditable(false);
            tf_apel02.setEditable(false);
            cb_roles.setDisable(true);
            //SE PERMITE: GUARDAR Y CANCELAR
            disables = new Integer[]{0,1,3,4,5,7,8,9,10,11};
            disableAllToolBar(disables);   
            break;
        case 4:  //CAMBIAR STATUS DEL USUARIO            
            tf_username.setEditable(false);
            tf_nomb01.setEditable(false);
            tf_nomb02.setEditable(false);
            tf_apel01.setEditable(false);
            tf_apel02.setEditable(false);
            cb_roles.setDisable(true);
            //SE PERMITE: GUARDAR,CAMBIO STATUS Y CANCELAR
            disables = new Integer[]{0,1,2,4,5,7,8,9,10,11};
            disableAllToolBar(disables); 
            break;
        case 5:  //EDITAR PSWD
            lb_Title.setText(Tools.verticalText("EDITAR CLAVE"));
            tf_username.setEditable(false);            
            isNamesVisible = false; 
            //SE PERMITE: GUARDAR,CAMBIO PSWD Y CANCELAR
            disables = new Integer[]{0,1,3,5,7,8,9,10,11};
            disableAllToolBar(disables);             
            break;
       }        
       hb_2.setVisible(isNamesVisible);
       hb_3.setVisible(isNamesVisible);
       hb_4.setVisible(isNamesVisible);  
       init_FocusArray(tipoOperacion);  
       Gui.getInstance().setTipoOperacion(tipoOperacion);
    }    
    /**
     * Procedimiento que obtiene los Distintos Roles de la BD
     * y los carga en el COMBOBOX
     */
    private void loadRols(){        
        //Se solicitan los roles en la BD
        Rol[] rols = Ln.getInstance().load_Rols();        
        final ObservableList<Rol> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(rols));          
        cb_roles.setItems(data); 
        //Instancia el manejador de eventos para el acceso rapido de los datos
//        CbRolKeyHandler cbkh = new CbRolKeyHandler(data);   
//        cb_roles.setOnKeyReleased(cbkh);   //Asigno el manejador al COMBOBOX
        Datos.setRoles(cb_roles);          //Asigna los valores en la clase de Datos Global             
        new SelectKeyComboBoxListener(cb_roles); 
    }     
    /**
     * Procedimiento que busca en BD la lista de usuarios
     * y los envia a cargar en la tabla
     */
    private void loadUsers(){        
        Usuario[] users = Ln.getInstance().load_Users();        
        loadTable(users);    
    }
    /**
     * Procedimiento de llenado de datos en la tabla de datos
     */
    private void loadTable(Usuario[] users){    
        if(users != null){
            ObservableList<Usuario> data = FXCollections.observableArrayList();        
            data.addAll(Arrays.asList(users));        
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
        Usuario user = tb_table.getSelectionModel().getSelectedItem();          
        if(user != null){
            Datos.setUsuario(user);         //Asigno el Usuario a la Clase de Datos Globales
            change_im_tool4(user.getStatus());  //Se define el valor del Boton de Cambio se Status
            refreshForm();                  //Refresca el Formulario
            setPswdVisible(false,false);    //Oculta los campos de contraseña
            setFormVisible(true);           //Coloca Visible el formulario
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
                    tf_nomb01, tf_nomb02, tf_apel01, tf_apel02, cb_roles, 
                    pf_pswd01, pf_pswd02};
                break;
            case 1:     //NUEVO
                nodos = new Node[]{
                    tf_nomb01, tf_nomb02, tf_apel01, tf_apel02, cb_roles, 
                    pf_pswd01, pf_pswd02};
                break;
            case 2:     //EDITAR
                nodos = new Node[]{
                    tf_nomb01, tf_nomb02, tf_apel01, tf_apel02, cb_roles};
                break;
            case 5:     //CAMBIO PSWD
                nodos = new Node[]{
                    pf_old, pf_pswd01, pf_pswd02};
                break;
        }             
        switch (opc){
            case 1: 
            case 2: 
            case 5:
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
                if(Gui.getFieldFocused() == 1 || Gui.getFieldFocused() == 3){
                    //si los campos de texto no son nulos
                    if(tf_nomb01.getText() != null && tf_apel01.getText() != null){
                        if(tipoOperacion == 1){ //NUEVO
                            createUserName();   
                        }
                    }
                }
            break;
         }            
        //Se Enfoca el nuevo nodo correspondiente
        Gui.getFields()[Gui.getFieldFocused()].requestFocus();            
        }else{  //Sino
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
            "Cambiar Contraseña de " + ScreenName + " ",
            "Imprimir " + ScreenName + " ",
            "Cancelar " + ScreenName + " ",
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
                        loadTable( Ln.getInstance().find_User(tf_buscar.getText()));     //Solicita los datos y envia la Respuesta a imprirse en la Pantalla
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
        Datos.setUsuario(new Usuario());                           
        refreshForm();                      
        Datos.setUsuario(null);             //RESET DE LA VARIABLE
        setPswdVisible(false,false);
        setFormVisible(false);              //OCULTA EL FORMULARIO
        //RECARGA LA TABLA ORIGINAL
        loadUsers();
    }
    /**
     * 
     */
    private void botonNuevo(){
        if(toolsConfig[2]==1){
            tipoOperacion = 1;
            change_im_check(false);
            loadRols();
            Datos.setUsuario(new Usuario());
            refreshForm();
            setPswdVisible(true,true);
            setFormVisible(true);
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonEditar(){
        tipoOperacion = 2;
        if(Datos.getUsuario() != null && toolsConfig[3]==1){
            change_im_check(true); 
            change_im_tool4(Datos.getUsuario().getStatus());
            refreshForm();
            setPswdVisible(false,false);
            setFormVisible(true);     
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();
        }
    }
    /**
     * 
     */
    private void botonGuardar(){        
        if(Datos.getUsuario() != null && toolsConfig[4]==1){
            boolean result; 
            if(tipoOperacion == 5 ){
                result = updatePswd();
            }else{           
                result = saveUser();
            }
            if (result)
                botonInicio();
        }

    }
    /**
     * 
     */
    private void botonEliminar() {
        if(Datos.getUsuario() != null && toolsConfig[5]==1){
            tipoOperacion = 4;      //OPERACION DE BORRADO
            change_im_check(true);       //SE CAMBIA EL ICONO DE VERIFICACION DEL USERNAME                   
            refreshForm();         
            setPswdVisible(false,false);
            setFormVisible(true);  
            String verbo = "desactivar";
            if(Datos.getUsuario().getStatus() == 1){
                verbo = "activar";
            }
            String mensj = 
                "¿Seguro que desea " + verbo + " el " + ScreenName + " " + Datos.getUsuario().getUsername()+ " ?";
            Gui.getInstance().showConfirmar(mensj);  
        }
    }
    /**
     * 
     */
    private void botonUpdPswd(){
        if(Datos.getUsuario() != null && toolsConfig[6]==1){
            tipoOperacion = 5;      //OPERACION DE MODIFICACION DE CLAVE                                      
            change_im_check(true);                             
            refreshForm();                            
            setPswdVisible(true,false);
            setFormVisible(true);   
            Gui.getFields()[Gui.getFieldFocused()].requestFocus();            
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
            Datos.setUsuario(new Usuario());                           
            refreshForm();                      
            Datos.setUsuario(null);             //RESET DE LA VARIABLE
            setPswdVisible(false,false);
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
        Datos.setUsuario(new Usuario());                           
        refreshForm();                      
        Datos.setUsuario(new Usuario());             //RESET DE LA VARIABLE
        setPswdVisible(false,false);
        setFormVisible(false);              //OCULTA EL FORMULARIO
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
         * BOTON CAMBIO CLAVE
         */
        im_tool5.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonUpdPswd();
                }
            }
        });
        /**
         * BOTON IMPRIMIR
         */
        im_tool6.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    //tipoOperacion = 5;      //OPERACION DE IMPRESION

                }
            }
        });
        /**
         * BOTON REGRESAR
         */
        im_tool7.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() > 0){
                    botonInicio();
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
                    if(tf_nomb01.getText() != null && tf_apel01.getText() != null){
                        if(tipoOperacion == 1){
                            createUserName();
                        }
                    }else{
                        Gui.getInstance().showMessage("1er Nombre y 1er Apellido no pueden estar en Blanco o Vacio!", "A");
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
     * @param boo TRUE si el USERNAME esta validado
     */
    private void change_im_check(boolean boo){
        if(boo){    //IMAGEN SI EL USERNAME ES CORRECTO
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img06.png")));
        }else{      //IMAGEN PARA LA BUSQUEDA DE UN USERNAME
            im_check.setImage(new Image(getClass().getResourceAsStream("/Images/img34.png")));
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
     * Metodo que establece el estado grafico del formulario, y mueve la tabla de datos
     * de posicion vertical
     * @param value TRUE si el formulario es Visible
     */
    private void setFormVisible(boolean value){
        vb_form.setVisible(value);  //Establece el estado grafico del formulario
        if(value){  //Si el estado es visible entonces 
            switch(tipoOperacion){
                case 0:  //SOLO LECTURA                    
                    vb_table.relocate(30, 244);
                    vb_table.setPrefHeight(328);
                    break;
                case 1:  //NUEVO
                    vb_table.relocate(30, 284);
                    vb_table.setPrefHeight(288);
                    break;
                case 2:  //EDITAR
                    vb_table.relocate(30, 214);
                    vb_table.setPrefHeight(358);
                    break;
                case 5:  //EDITAR PSWD
                    vb_table.relocate(30, 224);
                    vb_table.setPrefHeight(348);
                    break;
           }        

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
     * Procedimiento que modifica los campos de Contraseña del formulario,
     * colocandolos visible u ocultandolos segun los parametros 
     * @param value Variable que define si se muestran o no los campos de contraseña
     * @param isNew Variable que define si se esta creando un nuevo usuario
     */
    private void setPswdVisible(boolean value,boolean isNew){               
        hb_6.setVisible(value);
        
        if(value){      //Si seran visibles los campo de contraseña
            hb_5.setVisible(!isNew);    //Activo o Desactivo el campo de "Clave Actual"
            
            if(isNew){   //Si se esta creando un usuario NUEVO
                hb_6.setTranslateY(-25);    //Modifico la Posicion Vertical del campo       
            }else{      //Si se esta actualizando la contraseña
                hb_5.setTranslateY(-80);    //Modifico la Posicion Vertical del campo       
                hb_6.setTranslateY(-80);    //Modifico la Posicion Vertical del campo       
            }                    
        }else{          //Si NO seran visibles los campos de contraseña
            hb_5.setVisible(false);
            hb_5.setTranslateY(0);          //Regreso a la posicion vertical original del campo
        }
    }  
    
}
