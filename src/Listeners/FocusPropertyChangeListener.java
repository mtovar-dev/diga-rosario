/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import GUI.Gui;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

/**
 *
 * @author ARMGARCES
 */
public class FocusPropertyChangeListener implements ChangeListener<Boolean> {
    private final Node node;
    private int pos;
    
    public FocusPropertyChangeListener(Node _node,int _pos) {
        node = _node;
        pos  = _pos;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> ov,Boolean oldb, Boolean newb) {                
        if(node.isFocused()){
            Gui.setFieldFocused(pos);
        }
    }

}
