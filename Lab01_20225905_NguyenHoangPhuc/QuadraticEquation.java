import javax.swing.JOptionPane;

public class QuadraticEquation {
    public static void main(String[] args) {
        String aStr = JOptionPane.showInputDialog("Nguyen Hoang Phuc 20225905\nEnter coefficient a:");
        double a = Double.parseDouble(aStr);

        String bStr = JOptionPane.showInputDialog("Enter coefficient b:");
        double b = Double.parseDouble(bStr);

        String cStr = JOptionPane.showInputDialog("Enter coefficient c:");
        double c = Double.parseDouble(cStr);

        String result;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution.");
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "x = " + x);
            }
        } else {
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has two distinct real roots: x1 = " + root1 + " and x2 = " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has one double root: x =" + root);
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no real roots.");
            }
        }
    }
}
