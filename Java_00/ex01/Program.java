import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num <= 1)
            {
                System.err.println("IllegalArgument");
                System.exit(1);
            }
            int iter = 1;

            for (int i = 2; i * i <= num; i++)
            {
                if (num % i == 0)
                {
                    System.out.println("false " + iter);
                    return;
                }
                iter++;
            }
            System.out.println("true " + iter);
        } else {
            System.err.println("IllegalArgument");
            System.exit(1);
        }

    }
}
