
// -- IMPORTED COMPONENTS -- //
import Model.CalculatorData;
import View.CalculatorView;
import Controller.CalculatorController;

public class Main {
    public static void main(String[] args) {

        CalculatorData model = new CalculatorData();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view, model);
    }
}