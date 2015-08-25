/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import javafx.scene.control.TextField;

/**
 *
 * @author MITM
 */
public class ValidateTextFieldRif extends TextField {
    private int maxlength;
    String pattern = "[CVEPJGIcvepjgi0-9]*";

    public ValidateTextFieldRif() {
        this.maxlength = 10;
        this.setPromptText("J000000000");
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if(text.matches(pattern) || text.isEmpty()){
            super.replaceText(start, end, text); 
            verify();
        }
    }

    @Override
    public void replaceSelection(String text) {
        super.replaceSelection(text); 
        verify();
    }

    private void verify() {
        if (getText().length() > maxlength) {
            setText(getText().substring(0, maxlength));
        }
    }
    
}
