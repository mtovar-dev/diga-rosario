/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listeners;

import Objects.log_TMarca;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbTMarcaKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<log_TMarca> log_tmarca;        
        private String                          s;

        public CbTMarcaKeyHandler(ObservableList<log_TMarca> _log_tmarca) {            
            log_tmarca = _log_tmarca;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbMarca().getSelectionModel().selectFirst();
                return;
            }            
            for( log_TMarca item: log_tmarca ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbMarca().getSelectionModel().select( item );
                }
            }            
        }
        
    
}
