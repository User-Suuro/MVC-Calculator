package Controller;


import View.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        view.addNumbersListener(new NumbersListener());
    }

    class NumbersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < view.numberButtons.length; i++){
                if (e.getSource() == view.numberButtons[i]){
                    
                }
            }
            
           
        }
    }


}
