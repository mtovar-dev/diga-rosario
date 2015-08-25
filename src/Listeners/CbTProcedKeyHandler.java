/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listeners;

import Objects.log_TProced;
import Tools.Datos;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MITM
 */
public class CbTProcedKeyHandler implements EventHandler< KeyEvent >{
        private static ObservableList<log_TProced> log_tproced;        
        private String                          s;

        public CbTProcedKeyHandler(ObservableList<log_TProced> _log_tproced) {            
            log_tproced = _log_tproced;
            s = "";
        }

        @Override
        public void handle( KeyEvent event ) {            
            // handle non alphanumeric keys like backspace, delete etc
            if( event.getCode() == KeyCode.BACK_SPACE && s.length()>0)
                s = s.substring( 0, s.length() - 1 );
            else s = event.getText();

            if( s.length() == 0 ) {
                Datos.getCbProced().getSelectionModel().selectFirst();
                return;
            }            
            for( log_TProced item: log_tproced ) {                
                if( item.getNombre().startsWith( s ) ){
                    Datos.getCbProced().getSelectionModel().select( item );
                }
            }            
        }
        
    
}
