import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;
    JButton deleteButton;
    JButton clearButton;
    JPanel panel;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[6];
    JButton addButton, subButton, multiButton, divideButton, equalButton, dotButton, modButton, sqrtButton;
    char operator;
    double num1 = 0, num2 = 0, result = 0;

    Calculator() {
        this.setTitle("GUI calculator with exception handling");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(407, 600); //542
        this.setLayout(null);
        Image img = new ImageIcon("src/main/resources/Calculatorapp.png").getImage();
        this.setIconImage(img);
        this.getContentPane().setBackground(new Color(0xBFDEF5));

        textField = new JTextField();
        textField.setEditable(true);
        textField.setBounds(50, 20, 300, 50);
        textField.setBorder(BorderFactory.createRaisedBevelBorder());
        textField.setCaretColor(Color.BLUE);


        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
            numbers[i].setBorder(BorderFactory.createRaisedBevelBorder());
            numbers[i].setFont(new Font("Arial", Font.BOLD, 20));
            numbers[i].setBackground(new Color(0x62A6D7));
            numbers[i].setOpaque(true);
        }
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divideButton = new JButton("/");
        modButton = new JButton("Mod");
        sqrtButton = new JButton("\u221A");

        functions[0] = addButton;
        functions[1] = subButton;
        functions[2] = multiButton;
        functions[3] = divideButton;
        functions[4] = modButton;
        functions[5] = sqrtButton;


        for (int i = 0; i < 6; i++) {
            functions[i].addActionListener(this);
            functions[i].setFocusable(false);
            functions[i].setFont(new Font("Arial", Font.BOLD, 20));
            functions[i].setBackground(new Color(0x62A6D7));
            functions[i].setBorder(BorderFactory.createRaisedBevelBorder());
            functions[i].setOpaque(true);
        }

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 20, 20));
        panel.setBounds(50, 150, 300, 300);
        panel.setBackground(new Color(0xBFDEF5));


        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(functions[0]);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(functions[1]);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(functions[2]);
        panel.add(numbers[0]);
        panel.add(functions[4]);
        panel.add(functions[5]);
        panel.add(functions[3]);


        deleteButton = new JButton("->Back");
        deleteButton.setBounds(230, 100, 120, 30);
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);
        deleteButton.setBorder(BorderFactory.createRaisedBevelBorder());
        deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteButton.setBackground(new Color(0x62A6D7));
        deleteButton.setOpaque(true);

        clearButton = new JButton("Clear");
        clearButton.setBounds(50, 100, 120, 30);
        clearButton.addActionListener(this);
        clearButton.setFocusable(false);
        clearButton.setBorder(BorderFactory.createRaisedBevelBorder());
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setBackground(new Color(0x62A6D7));
        clearButton.setOpaque(true);


        dotButton = new JButton(".");
        dotButton.setBounds(50, 460, 70, 50);
        dotButton.addActionListener(this);
        dotButton.setFocusable(false);
        dotButton.setBorder(BorderFactory.createRaisedBevelBorder());
        dotButton.setFont(new Font("Arial", Font.BOLD, 20));
        dotButton.setBackground(new Color(0x62A6D7));
        dotButton.setOpaque(true);

        equalButton = new JButton("=");
        equalButton.setBounds(150, 460, 200, 50);
        equalButton.addActionListener(this);
        equalButton.setFocusable(false);
        equalButton.setBorder(BorderFactory.createRaisedBevelBorder());
        equalButton.setFont(new Font("Arial", Font.BOLD, 20));
        equalButton.setBackground(new Color(0x62A6D7));
        equalButton.setOpaque(true);


        this.add(textField);
        this.add(deleteButton);
        this.add(clearButton);
        this.add(dotButton);
        this.add(equalButton);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clearButton) {
                textField.setText("");
            }
            if (e.getSource() == deleteButton) {
                String text = textField.getText();
                text = text.substring(0, text.length() - 1);
                textField.setText(text);
            }
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numbers[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == dotButton) {
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (e.getSource() == multiButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (e.getSource() == divideButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }

            if (e.getSource() == modButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText("");
            }

            if (e.getSource() == sqrtButton) {
                num1 = Double.parseDouble(textField.getText());
                num1 = Math.sqrt(num1);
                textField.setText(String.valueOf(num1));
                operator = 'S';
            }
            if (e.getSource() == equalButton) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = num1 / num2;
                        break;

                    case '%':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = num1 % num2;
                        break;

                }
                textField.setText(String.valueOf(result));
                num1 = result;

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Null Error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "ArrayIndexOutOfBounds", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    public static void main(String[] args) {
        new Calculator();
    }
}