package View;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class CalculatorView{
    JTextField textField;
    public JButton[] numberButtons = new JButton[10];
    public JButton[] functionButtons = new JButton[9];
    public JButton addButton, subButton, mulButton, divButton;
    public JButton decButton, equalButton, delButton, clrButton, negativeButton;

    JFrame frame;
    JPanel panel;

    Font poppinsLG = new Font("Poppins", Font.BOLD, 30);
    Font poppinsSM = new Font("Poppins", Font.PLAIN, 18);
   
    public CalculatorView(){
        // -- INIT -- //
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(poppinsLG);
        textField.setEditable(false);
        
        // -- FUNCTIONALITY BUTTONS -- //
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negativeButton;
        for (int i = 0; i < functionButtons.length; i++){
            functionButtons[i].setFont(poppinsSM);
            functionButtons[i].setFocusable(false);
        }

        // -- NUMBER BUTTONS -- //
        for (int i = 0; i < numberButtons.length; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(poppinsSM);
            numberButtons[i].setFocusable(false);
          
        };

        delButton.setBounds(290, 90, 60, 30);
        clrButton.setBounds(220, 90, 60, 30);
        negativeButton.setBounds(150, 90, 60, 30);

        // -- PANEL -- //
        panel = new JPanel(new BorderLayout());
        panel.setBounds(50, 135, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEtchedBorder(), 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        // -- ADD TO FRAME -- //
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(negativeButton);

        frame.setVisible(true);
    }

    // -- ADD EVENT LISTENER TO BUTTONS -- // 
    public void addNumbersListener(ActionListener listener){
        for (int i = 0; i < numberButtons.length; i++){
            numberButtons[i].addActionListener(listener);
        }

        for (int i = 0; i < functionButtons.length; i++){
            functionButtons[i].addActionListener(listener);
        }
    }

    // -- TEXT FIELD VALUE GETTER -- //
    public String getTextField() {
        return textField.getText();
    }

    // -- TEXT FIELD VALUE SETTER -- //
    public void setTextField(String value){
        textField.setText(value);
    }
}
