import java.util.Scanner;
public class DrawingTriangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Nguyen Hoang Phuc 20225905\n Enter the height of the triangle: ");
        int n = keyboard.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        keyboard.close();
    }
}
