import javax.swing.JOptionPane;
public class LinearEquation {
    public static void main(String[] args) {
        String str_a = JOptionPane.showInputDialog(null, "Nguyen Hoang Phuc 20225905\nEnter coefficient a: ");
        double a = Double.parseDouble(str_a);
        String str_b = JOptionPane.showInputDialog(null, "Enter coefficient b: ");
        double b = Double.parseDouble(str_b);
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution.");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "x = " + x);
        }
    }
}
