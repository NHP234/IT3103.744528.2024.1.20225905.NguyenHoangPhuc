import javax.swing.*;
public class Calculate {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, "Nguyen Hoang Phuc 20225905\n" +
                "Enter the first number: ");
        String strNum2 = JOptionPane.showInputDialog(null, "Enter the second number: ");
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient;
        if(num2 == 0)
        {
            JOptionPane.showMessageDialog(null, "Error! Cannot divide by zero!");
        }
        else {
            quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, "Nguyen Hoang Phuc 20225905\nSum: " + sum + "\n"
            + "Difference: " + difference + "\n"
            + "Product: " + product + "\n"
            + "Quotient: " + quotient);
        }
    }
}
