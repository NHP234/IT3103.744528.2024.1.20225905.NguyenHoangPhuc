import javax.swing.JOptionPane;

public class LinearSystem {

    public static void main(String[] args) {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nguyen Hoang Phuc 20225905 \nEnter coefficient a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter constant b1:"));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter constant b2:"));

        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Unique Solution:\n x1 = " + x1 + "\n x2 = " + x2);
        } else if (D == 0 && D1 == 0 && D2 == 0) {
            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
        } else {
            JOptionPane.showMessageDialog(null, "The system has no solution.");
        }
    }
}
