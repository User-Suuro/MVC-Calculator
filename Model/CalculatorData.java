package Model;

public class CalculatorData {
    private String textField;
    private char operator;
    private double num01;
    private double num02;
    private double result;
    private boolean hasResult = false;

    // TEXTFIELD
    public String getTextField(){
        return textField;
    }

    public void setTextField(String newVal){
        this.textField = newVal;
    }

    // NUM01
    public double getNum01(){
        return num01;
    }

    public void setNum01(double newValue){
        this.num01 = newValue;
    }

    // NUM02
    public double getNum02(){
        return num02;
    }

    public void setNum02(double newValue){
        this.num02 = newValue;
    }


    // OPERATOR
    public char getOperator(){
        return operator;
    }

    public void setOperator(char newOperator){
        this.operator = newOperator;
    }

    // RESULT
    public double getResult(){
        return result;
    }

    public void setResult(double newValue){
        this.result = newValue;
    }

    // HAS RESULT
    public boolean getHasResult(){
        return hasResult;
    }

    public void setHasResult(boolean newValue){
        this.hasResult = newValue;
    }
}
