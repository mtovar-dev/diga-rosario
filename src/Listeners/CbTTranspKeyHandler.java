/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listeners;

import Objects.log_TTransp;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbTTranspKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<log_TTransp> log_ttransp;        
        private String                          s;

        public CbTTranspKeyHandler(ObservableList<log_TTransp> _log_ttransp) {            
            log_ttransp = _log_ttransp;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbTTransp().getSelectionModel().selectFirst();
                return;
            }            
            for( log_TTransp item: log_ttransp ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbTTransp().getSelectionModel().select( item );
                }
            }            
        }
        
    
}
