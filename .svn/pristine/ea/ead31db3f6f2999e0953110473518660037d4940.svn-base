/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Screens;

import GUI.Gui;
import GUI.TopBar.TopBarController;
import Tools.Datos;
import Tools.Tools;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ARMGARCES
 */
public class Screens {
    private static final Gui gui = Gui.getInstance();
    private static double xOffset = 0;
    private static double yOffset = 0;
    
    
    private Screens() {
    }
    
    /**
     * 
     * @param primaryStage
     */
    public void startIndex(Stage primaryStage){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("index");
        Datos.setIdScreen(Integer.parseInt(id));
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR        
        Gui.setAp_topbar(gui.loadFxml("TopBar/Fxml_TopBar.fxml"));
        Node node = Tools.getNode(Gui.getAp_topbar(),"#hbox");        
        HBox hbox = (HBox) node;        
        hbox.getChildren().remove(0);
        root.setTop(Gui.getAp_topbar());        
        
        //LEFT BAR                     
        Gui.setAp_leftbar(gui.loadFxml("LeftBar/Fxml_LeftBar.fxml"));   
        root.setLeft(Gui.getAp_leftbar());         
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Fxml_Index.fxml"));
        root.setCenter(Gui.getAp_center());
        
        
        //Capturador de eventos de Teclado en toda la pantalla         
        scene.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent ke) -> {
            if (ke.isAltDown() && ke.getCode().equals(KeyCode.S)){
                TopBarController.botonLogIn();
            }
        });
        //GENERAL                
        gui.setTipoOperacion(0);
        gui.setStage(primaryStage);
        gui.getStage().initStyle(StageStyle.UNDECORATED);
        gui.getStage().setResizable(false);
        gui.getStage().setScene(scene);
        gui.getStage().show();    

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startUser(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("user");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/System/Fxml_User.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * 
     * @author MITM
     */
    public void startAud_Gh_Concepto(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("aud_gh_concepto");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Rrhh/Fxml_Aud_Gh_Concepto.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * 
     * @author MITM
     */
    public void startAud_Gh_Empleado(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("aud_gh_empleado");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Rrhh/Fxml_Aud_Gh_Empleado.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * 
     * @author MITM
     */
    public void startAud_Gh_Empresa(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("aud_gh_empresa");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Rrhh/Fxml_Aud_Gh_Empresa.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * 
     * @author MITM
     */
    public void startRole(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("role");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/System/Fxml_Role.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * 
     * @author MITM
     */
    public void startSupplier(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("supplier");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Orders/Fxml_Suppliers.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startGroupSupplier(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("groupsupplier");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Setup/Fxml_GroupSupplier.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startOrdersNew(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("orders_new");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Orders/Fxml_PurchaseOrderNew.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startOrdersOpen(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("orders_open");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Orders/Fxml_PurchaseOrderOpen.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startGuide_data(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_data");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Fxml_Guide.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startGuide_print(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_print");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Reports/Fxml_Guide_rep.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startGuide_paydesk(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_paydesk");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Fxml_Guide_paydesk.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startGuide_InvoiceGlomar(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_invoiceglomar");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Fxml_Guide_InvoiceGlomar.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startPersonal(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("personal");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Fxml_Personal.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startVehicles(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("vehiculos");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Fxml_Vehiculos.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startMeasure(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("measure");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Setup/Fxml_Measure.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startUnit(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("unit");
        Datos.setIdScreen(Integer.parseInt(id));

        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Setup/Fxml_Unit.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startReason(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("reason");
        Datos.setIdScreen(Integer.parseInt(id));

        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Setup/Fxml_Reason.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL   
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
    
    /**
     * 
     * @author MITM
     */
    public void startSeniat_UpFile_Reten(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("seniat_upfile_retenciones");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Seniat/Fxml_UpFile_Retenciones.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * 
     * @author MITM
     */
    public void startSeniat_Query_Reten(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("seniat_query_retenciones");
        Datos.setIdScreen(Integer.parseInt(id));
        
        Stage stage = new Stage();
        //GENERAL
        BorderPane root = new BorderPane();       
        Scene scene = new Scene(root, 1024, 700,Color.BEIGE);
        scene.getStylesheets().addAll("GUI/Css.css");
        
        //TOP BAR                
        root.setTop(Gui.getAp_topbar());       
        //LEFT BAR                     
        root.setLeft(Gui.getAp_leftbar());
        
        //RIGHT BAR
        root.setRight(null);
        
        // CENTER
        Gui.setAp_center(gui.loadFxml("Screens/Seniat/Fxml_Query_Retenciones.fxml"));
        root.setCenter(Gui.getAp_center());
        
        //GENERAL           
        Stage aux = gui.getStage();
        gui.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
        aux.close();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /***************************************************************************/
    /******************************* SINGLETON *********************************/
    /***************************************************************************/

    private static class ScreensHolder {

        private static final Screens INSTANCE = new Screens();
    }
    
    public static Screens getInstance() {
        return ScreensHolder.INSTANCE;
    }
    
    
}
