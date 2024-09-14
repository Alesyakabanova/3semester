//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("this is test");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
            boolean flag = false;
            try {
                double d = Double.parseDouble(token);

                if (token.indexOf('.') != -1) {
                    flag = true;
                    int index = token.indexOf('.');
                    token = token.substring(0,index+3);
                }
        } catch (NumberFormatException e) {}
            System.out.println(token+" "+flag);

        }

    }
}