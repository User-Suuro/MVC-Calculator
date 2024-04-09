package Controller;

import View.CalculatorView;
import Model.CalculatorData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    
    private CalculatorView view;
    private CalculatorData model;
    
    public CalculatorController(CalculatorView view, CalculatorData model) {
        this.view = view;
        this.model = model;
        view.addNumbersListener(new NumbersListener());
    }

    class NumbersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < view.numberButtons.length; i++){
                if (e.getSource() == view.numberButtons[i]){
                    model.setTextField(view.getTextField().concat(String.valueOf(i)));
                    view.setTextField(model.getTextField());
                }
            }

            if(e.getSource() == view.decButton){
                model.setTextField(view.getTextField().concat("."));
                view.setTextField(model.getTextField());
            }

            if(e.getSource() == view.addButton){
                model.setNum01(Double.parseDouble(model.getTextField()));
                model.setOperator('+');
                model.setTextField("");
                view.setTextField(model.getTextField());
            }

            if(e.getSource() == view.subButton){
                model.setNum01(Double.parseDouble(model.getTextField()));
                model.setOperator('-');
                model.setTextField("");
                view.setTextField(model.getTextField());
            }

            if(e.getSource() == view.mulButton){
                model.setNum01(Double.parseDouble(model.getTextField()));
                model.setOperator('*');
                model.setTextField("");
                view.setTextField(model.getTextField());
            }

            if(e.getSource() == view.divButton){
                model.setNum01(Double.parseDouble(model.getTextField()));
                model.setOperator('/');
                model.setTextField("");
                view.setTextField(model.getTextField());
            }

            if (e.getSource() == view.equalButton){
                model.setNum02(Double.parseDouble(view.getTextField()));

                switch (model.getOperator()) {
                    case '+':
                        model.setResult(model.getNum01() + model.getNum02());
                        break;
                    case '-':
                        model.setResult(model.getNum01() - model.getNum02());
                        break;
                    case '*':
                        model.setResult(model.getNum01() * model.getNum02());
                        break;
                    case '/':
                        model.setResult(model.getNum01() / model.getNum02());
                        break;
                    default:
                        break;
                }

                view.setTextField(String.valueOf(model.getResult()));
                model.setNum01(model.getResult());
            }
        }
    }


}
