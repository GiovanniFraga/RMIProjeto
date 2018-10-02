import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.rmi.RemoteException;


public class CalcVisual extends JFrame {


    //private CalculatorClient calc;
    static Calculator calc = null;
    private JButton Button1;
    private JButton Button5;
    private JButton Button6;
    private JButton Button7;
    private JButton Button8;
    private JButton Button9;
    private JButton Button0;
    private JButton buttonAdd;
    private JButton buttonSub;
    private JButton buttonIgual;
    private JButton buttonDiv;
    private JButton buttonMult;
    private JButton CEButton;
    private JButton Button4;
    private JButton Button3;
    private JButton Button2;
    private JTextField visorCalc;
    private JButton buttonVirgula;
    private JPanel panelMain;
    private JPanel panelSecundario;
    private String valor;
    private String oper;
    private Float valor1, valor2;
    private Float result;

    public CalcVisual(Calculator c) {

        calc = c;

        this.setSize(400, 300);
        add(panelMain);

        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "1");
            }
        });

        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "2");
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "3");
            }
        });
        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "4");
            }
        });
        Button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "5");
            }
        });
        Button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "6");
            }
        });
        Button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "7");
            }
        });
        Button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "8");
            }
        });
        Button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "9");
            }
        });
        Button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + "0");
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "+";
                valor1 = Float.parseFloat(visorCalc.getText());
                visorCalc.setText("");
                //buttonAdd.setBackground(Color.BLUE);
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "-";
                valor1 = Float.parseFloat(visorCalc.getText());
                visorCalc.setText("");
                //  buttonSub.setBackground(Color.BLUE);
            }
        });
        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "*";
                valor1 = Float.parseFloat(visorCalc.getText());
                visorCalc.setText("");
                //  buttonMult.setBackground(Color.BLUE);
            }
        });
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oper = "/";
                valor1 = Float.parseFloat(visorCalc.getText());
                visorCalc.setText("");
                // buttonDiv.setBackground(Color.BLUE);
            }
        });
        buttonIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                valor2 = Float.parseFloat(visorCalc.getText());
                visorCalc.setText("");
                Calcular(valor1, valor2, oper);
                System.out.println("Result = [" + result + "]");
                visorCalc.setText(String.valueOf(valor1+oper+valor2+"="+result));
            }
        });
        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText("");
            }
        });
        buttonVirgula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = visorCalc.getText();
                visorCalc.setText(valor + ",");
            }
        });

        panelMain.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }


    public void Calcular(Float Value1, Float Value2, String oper) {
        try {
            switch (oper) {
                case ("+"):
                    result = calc.add(Value1, Value2);
                    break;
                case ("-"):
                    result = calc.sub(Value1, Value2);
                    break;
                case ("*"):
                    result = calc.mult(Value1, Value2);
                    break;
                case ("/"):
                    result = calc.div(Value1, Value2);
                    break;
                default:
                    result = null;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}