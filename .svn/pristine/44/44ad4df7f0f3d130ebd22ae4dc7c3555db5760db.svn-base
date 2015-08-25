/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listeners;

import Objects.log_TPersonal;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Personal
 */
public class CbTPersonalKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<log_TPersonal> log_tpersonal;        
        private String                          s;

        public CbTPersonalKeyHandler(ObservableList<log_TPersonal> _log_tpersonal) {            
            log_tpersonal = _log_tpersonal;
            s = "";
        }
        /**
         * 
         * @param event 
         */
        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbSex().getSelectionModel().selectFirst();
                return;
            }            
            for( log_TPersonal item: log_tpersonal ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbTPersonal().getSelectionModel().select( item );
                }
            }            
        }
        
    
}
