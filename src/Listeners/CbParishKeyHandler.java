/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Objects.Setup.Parish;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbParishKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<Parish> parish;        
        private String                          s;

        public CbParishKeyHandler(ObservableList<Parish> _parish) {            
            parish = _parish;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbParish().getSelectionModel().selectFirst();
                return;
            }            
            for( Parish item: parish ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbParish().getSelectionModel().select( item );
                }
            }            
        }
    
}
