import java.util.Scanner;

public class Program {


    static boolean isPrime(int num)
    {
        for (int i = 2; i * i <= num; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    static int sumCif(int c)
    {
        int k = 0;
        while (c > 0)
        {
            k += c % 10;
            c = c / 10;
        }
        return k;
    }

    public static void main(String[] args) {
        int prime = 0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num == 42){
                System.out.println("Count of coffee-request – " + prime);
                return;
            }
            if (isPrime(sumCif(num)))
                prime++;
            if (num <= 1)
            {
                System.err.println("IllegalArgument");
                System.exit(1);
            }
        }
        if(sc.hasNext()){
        System.err.println("IllegalArgument");
        System.exit(1);
        }
    }
}
