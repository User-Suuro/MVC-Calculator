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
            try{
                // -- 0-9 BUTTONS -- //
                for (int i = 0; i < view.numberButtons.length; i++){
                    if (e.getSource() == view.numberButtons[i]){
                        model.setTextField(view.getTextField().concat(String.valueOf(i)));
                        view.setTextField(model.getTextField());
                    }
                }

                // -- DECIMAL BUTTON -- //
                if(e.getSource() == view.decButton){
                    model.setTextField(view.getTextField().concat("."));
                    view.setTextField(model.getTextField());
                }
                
                // -- ADD BUTTON -- //
                if(e.getSource() == view.addButton){
                    if (!model.getHasResult()){
                        model.setNum01(Double.parseDouble(model.getTextField()));
                    }else{
                        model.setNum02(Double.parseDouble(model.getTextField()));
                    }

                    model.setOperator('+');
                    model.setTextField("");
                    view.setTextField(model.getTextField());                   
                }

                // -- SUBTRACTION BUTTON -- //
                if(e.getSource() == view.subButton){
                    if (!model.getHasResult()){
                        model.setNum01(Double.parseDouble(model.getTextField()));
                    }else{
                        model.setNum02(Double.parseDouble(model.getTextField()));
                    }
                    
                    model.setOperator('-');
                    model.setTextField("");
                    view.setTextField(model.getTextField());
                }
                
                // -- MULTIPLICATION BUTTON -- //
                if(e.getSource() == view.mulButton){
                    if (!model.getHasResult()){
                        model.setNum01(Double.parseDouble(model.getTextField()));
                    }else{
                        model.setNum02(Double.parseDouble(model.getTextField()));
                    }
                   
                    model.setOperator('*');
                    model.setTextField("");
                    view.setTextField(model.getTextField());
                }
                
                // -- DIVIDE BUTTON -- //
                if(e.getSource() == view.divButton){
                    if (!model.getHasResult()){
                        model.setNum01(Double.parseDouble(model.getTextField()));
                    }else{
                        model.setNum02(Double.parseDouble(model.getTextField()));
                    }
                    model.setOperator('/');
                    model.setTextField("");
                    view.setTextField(model.getTextField());
                }
                
                // -- EQUAL BUTTON -- //
                if (e.getSource() == view.equalButton){
                    if (!model.getHasResult()){
                        model.setNum02(Double.parseDouble(model.getTextField()));
                    }else{
                        model.setNum02(Double.parseDouble(model.getTextField()));
                    }
                   
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
                    
                    model.setHasResult(true);
                    view.setTextField(String.valueOf(model.getResult()));
                    model.setNum01(model.getResult());
                }
                
                // -- CLEAR BUTTON -- //
                if (e.getSource() == view.clrButton){
                    model.setHasResult(false);
                    model.setTextField("");
                    model.setNum01(0);
                    model.setNum02(0);
                    view.setTextField(model.getTextField());
                }

                // -- DELETE BUTTON -- //
                if (e.getSource() == view.delButton){
                    String temp = view.getTextField();
                    view.setTextField("");
                    for(int i = 0; i < temp.length() - 1; i++){
                        view.setTextField(view.getTextField() + temp.charAt(i));
                        model.setTextField(view.getTextField());
                    }
                    
                }

                 // -- NEGATIVE BUTTON -- //
                 if (e.getSource() == view.negativeButton){
                    if (Double.parseDouble(view.getTextField()) > 0){
                        double temp = Double.parseDouble(view.getTextField());
                        temp = temp * -1;
                        view.setTextField(String.valueOf(temp));
                        model.setTextField(view.getTextField());
                        
                    }
                }


            }catch(Exception error){}
    
        }
    }


}
