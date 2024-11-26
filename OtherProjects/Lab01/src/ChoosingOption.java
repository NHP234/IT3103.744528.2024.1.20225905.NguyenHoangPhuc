import javax.swing.*;
public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
                "Nguyen Hoang Phuc 20225905\nDo you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "Nguyen Hoang Phuc 20225905\nYou've chosen: "
        + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}
