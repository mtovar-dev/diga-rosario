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
public class ValidateTextFieldPhone extends TextField {  
    private int maxlength;
    String pattern = "[0-9-]*";

    public ValidateTextFieldPhone() {
        this.maxlength = 12;
        this.setPromptText("0000-0000000");
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
