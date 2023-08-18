package GUI;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BinaryCalculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[3];
    JButton delButton, eqButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD,30);
    
    double num1=0, num2=0, result=0;
    char operator;

    BinaryCalculator() {
        frame = new JFrame("BinaryCalculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setResizable(false);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(55, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);


        eqButton = new JButton("Enter");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");


        functionButtons[0] = clrButton;
        functionButtons[1] = delButton;
        functionButtons[2] = eqButton;

        for (int i = 0; i < 3; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 10; i ++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

          
        }   
        delButton.setBounds(10, 430, 135, 50);
        clrButton.setBounds(135, 430, 135, 50);
        eqButton.setBounds(280, 430, 135, 50);


        panel = new JPanel();
        panel.setBounds(55, 100, 300, 250);
        panel.setLayout(new GridLayout(4,4, 10, 10));
        panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        //panel.add(numberButtons[2]);
        //panel.add(numberButtons[3]);
        panel.add(numberButtons[0]);
        panel.add(delButton);
        //panel.add(numberButtons[4]);
        //panel.add(numberButtons[5]);
       // panel.add(numberButtons[6]);
      
        panel.add(eqButton);
       // panel.add(numberButtons[7]);
       //panel.add(numberButtons[8]);
        //panel.add(numberButtons[9]);
        
        
        frame.add(panel);
        frame.add(clrButton);
        //frame.add(eqButton);
        //frame.add(delButton);
        //frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    /*NÆSTE IDÉ! :
    GØR DET MULIGT AT LAVE DECIMAL TIL BINÆR!!*/


    @Override
    public void actionPerformed(ActionEvent e) {
     
        for(int i = 0; i < 2; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i))); 

                }
            }
            //Sletter alt
            if(e.getSource()== clrButton) {
                textField.setText(""); 
            }
            //Fremkalder klassen BinaryToDecimal
            if(e.getSource()== eqButton) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(BinaryToDecimal.getDecimal(Integer.valueOf(textField.getText())))); 
            }
            //Sletter enkelte chars. Her kræves loop
            if (e.getSource()==delButton) {
                String string = textField.getText();
                textField.setText("");
                for (int i =0; i<string.length()-1; i++) {
                    textField.setText(textField.getText()+string.charAt(i));

                }
            }
        
    }

       public static void main(String[] args) {
        BinaryCalculator binCalc = new BinaryCalculator();

       

    }
}