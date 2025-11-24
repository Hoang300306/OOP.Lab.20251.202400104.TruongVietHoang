
import javax.swing.JOptionPane;
public class Calculate {
    public static void main (String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, 
            "Please enter first number:", "Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        
        strNum2 = JOptionPane.showInputDialog(null, 
            "Please enter second number:", "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
       
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        String strResult = "The sum is: " + (num1 + num2) + "\n"
            + "The difference is: " + (num1 - num2) + "\n"
            + "The product is: " + (num1 * num2) + "\n"
            + "The quotient is: " + (num1 / num2) + "\n";
        
        JOptionPane.showMessageDialog(null, strResult, "Show results",
            JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
        
    
    }

}
