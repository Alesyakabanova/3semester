//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
public class Main
{

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IOException("You need 2 arguments");
        }
        double x = 0;
        double prec = 0;
        try {
            prec = Double.parseDouble(args[0]);
        }catch(Exception e) {
           System.out.println("mistake");
      }
        try {
            x = Double.parseDouble(args[1]);
        }
        catch(Exception e) {
            System.out.println("mistake");
        }
        int k = 1;
        double curr=1;
        double sum = 0;
        curr = calculate(k, x, curr);
        while (Math.abs(curr) > prec) {

            sum +=curr;;
            k++;
            curr = calculate(k, x, curr);
        }
        System.out.println(sum);
    }
    public static double calculate(int k, double x, double curr) {
        curr *= (-1)*(k+1)*x/3/k;

        return curr;
    }
}