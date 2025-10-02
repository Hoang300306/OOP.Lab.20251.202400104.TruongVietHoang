import javax.swing.JOptionPane;
public class Solver {
    // ax + b = 0
    public static void linearEquationOneVar() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

        String result;
        if (a == 0) {
            if (b == 0) result = "The equation has infinitely many solutions.";
            else result = "The equation has no solution.";
        } else {
            double x = -b / a;
            result = "The solution is: x = " + x;
        }

        JOptionPane.showMessageDialog(null, result);
    }
    // two vars
    public static void linearSystemTwoVars() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

        double D  = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        String result;
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            result = "The system has a unique solution:\n x1 = " + x1 + ", x2 = " + x2;
        } else {
            if (D1 == 0 && D2 == 0) result = "The system has infinitely many solutions.";
            else result = "The system has no solution.";
        }

        JOptionPane.showMessageDialog(null, result);
    }
    // ax^2 + bx + c = 0
    public static void quadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        String result;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) result = "The equation has infinitely many solutions.";
                else result = "The equation has no solution.";
            } else {
                double x = -c / b;
                result = "This is a linear equation. Solution: x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                result = "The equation has no solution.";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "The equation has a double root: x = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "The equation has two distinct solutions:\n x1 = " + x1 + ", x2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, result);
    }

    public static void main(String[] args) {
        String menu = "Choose:\n"
                + "1. Linear equation in one variable\n"
                + "2. System of two linear equations in two variables\n"
                + "3. Quadratic equation in one variable\n"
                + "0. Exit";

        while (true) {
            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break; // user clicked Cancel
            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    linearEquationOneVar();
                    break;
                case 2:
                    linearSystemTwoVars();
                    break;
                case 3:
                    quadraticEquation();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
