import java.rmi.Naming;

public class CalculatorClient {
    static Calculator calc = null;

    private Float result;

    public static void main(String[] args) {
        try {
            calc = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");
            System.out.println("conectado");
            System.out.println("Calculadora criada por: Giovanni");
            System.out.println("Materia: Sistemas Distruidos");
            System.out.println("Professora: Carla");
        } catch (Exception e) {
            System.out.println(e);
        }

        CalcVisual a = new CalcVisual(calc);
        a.setVisible(true);

    }
}