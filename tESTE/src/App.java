import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int N = Scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if(N % 2 > 0) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }

        Scanner.close();
    }
}
