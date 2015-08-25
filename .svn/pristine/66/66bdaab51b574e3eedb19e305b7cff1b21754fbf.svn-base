/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Objects.Setup.State;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbStateKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<State> state;        
        private String                          s;

        public CbStateKeyHandler(ObservableList<State> _state) {            
            state = _state;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbState().getSelectionModel().selectFirst();
                return;
            }            
            for( State item: state ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbState().getSelectionModel().select( item );
                }
            }            
        }
    
}
