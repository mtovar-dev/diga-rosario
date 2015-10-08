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
    public void startOrders_new(){
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
        Gui.setAp_center(gui.loadFxml("Screens/Orders/Fxml_PurchaseOrder_New.fxml"));
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
    public void startOrders_open(){
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
        Gui.setAp_center(gui.loadFxml("Screens/Orders/Fxml_PurchaseOrder_Open.fxml"));
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
    public void startOrders_closed(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("orders_closed");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Orders/Fxml_PurchaseOrder_Closed.fxml"));
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
    public void startGuide_branch(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_branch");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Guide_Branch.fxml"));
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
    public void startGuide_main(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_main");
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
        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Guide_Main.fxml"));
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
    public void startGuide_recovery(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("guide_recovery");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Guide_Recovery.fxml"));
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
    public void startFleet_staff(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("fleet_staff");
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
        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Personal.fxml"));
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
    public void startFleet_vehicle(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("fleet_vehicle");
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
        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Vehiculos.fxml"));
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
    public void startReport_Missingload(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("report_missingload");
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
        Gui.setAp_center(gui.loadFxml("Reports/Fxml_FaltCarga.fxml"));
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
    public void startReport_Invoicebranch(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("report_invoicebranch");
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
        Gui.setAp_center(gui.loadFxml("Indicators/Fxml_FanulSucursales.fxml"));
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
    public void startIndicators_Invoicesmade(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("indicators_invoicesmade");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Indicators/Fxml_FanulSucursales.fxml"));
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
    public void startIndicators_Guidemade(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("indicators_guidemade");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Indicators/Fxml_Guidemade.fxml"));
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
    public void startIndicators_Guideloaded(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("indicators_guideloaded");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Indicators/Fxml_Ind_Guideloaded.fxml"));
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
    public void startIndicators_Guidepending(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("indicators_guidepending");
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
        Gui.setAp_center(gui.loadFxml("Screens/Indicators/Fxml_Guidepending.fxml"));
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
     public void startRelation_Guidepaydesk(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("relation_guidepaydesk");
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
        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Guide_Paydesk.fxml"));
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
    public void startRelation_Guideinvglomar(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("relation_guideinvglomar");
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
        Gui.setAp_center(gui.loadFxml("Screens/Guide/Main/Fxml_Guide_Invglomar.fxml"));
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
    public void startSeniat_Qryrif(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("seniat_qryrif");
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
//        Gui.setAp_center(gui.loadFxml("Screens/Seniat/Fxml_UpFile_Retenciones.fxml"));
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
    public void startSeniat_Upfileretenciones(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("seniat_upfileretenciones");
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
    public void startSeniat_Qryretenciones(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("seniat_qryretenciones");
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
        Gui.setAp_center(gui.loadFxml("Screens/Seniat/Fxml_Qry_Retenciones.fxml"));
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
    public void startHhrr_Audconcepto(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("hhrr_audconcepto");
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
    public void startHhrr_Audempleado(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("hhrr_audempleado");
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
    public void startHhrr_Audempresa(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("hhrr_audempresa");
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
    public void startConfig_Insurance(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("config_insurance");
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
        Gui.setAp_center(gui.loadFxml("Screens/Setup/Fxml_Insurance.fxml"));
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
    public void startConfig_Available(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("config_available");
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
        Gui.setAp_center(gui.loadFxml("Screens/Setup/Fxml_Available.fxml"));
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
    public void startConfig_Groupsupplier(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("config_groupsupplier");
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
    public void startConfig_Measure(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("config_measure");
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
    public void startConfig_Reason(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("config_reason");
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
    public void startConfig_Unit(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("config_unit");
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
    public void startSystem_User(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("system_user");
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
    public void startSystem_Role(){
        String id =  java.util.ResourceBundle.getBundle("GUI/Screens/Screens").getString("system_role");
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
