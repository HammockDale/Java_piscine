
import java.util.Scanner;

public class Program {

    public static class diary{
        int week;
        int grade;
        diary next;

        public diary(int week, int grade)
        {
            this.week = week;
            this.grade = grade;
            this.next = null;
        }
    }

    public static void wrong()
    {
        System.out.println("Wrong argument");
        System.exit(1);
    }

    public static void end( diary firstWeek)
    {
        for ( ; ; firstWeek = firstWeek.next)
        {
            System.out.print(firstWeek.week + " ");
            for (int i = 0 ; i < firstWeek.grade; i++)
                System.out.print("=");
            System.out.println(">");
            if (firstWeek.next == null)
                System.exit(0);
        }
    }

    public static int minGrade(Scanner sc)
    {
        int grade = 9;
        for (int i = 0 ; i < 5 ; ++i)
        {
            if (!sc.hasNextInt())
                wrong();
            int b = sc.nextInt();
            if (b > 0 && b <= 9) {
                if (b < grade) {
                    grade = b;
                }
            }
            else
                wrong();
        }
        return grade;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            diary firstWeek = null;
            diary lastWeek = null;
            String str;
            int iter = 0;
            while((str = sc.next()).equals("week"))
            {
                if (iter == 18)
                    end(firstWeek);
                iter++;
                if (!sc.hasNextInt())
                    wrong();
                int week = sc.nextInt();
                if (week < 1 || week > 18)
                    wrong();
                int grade = minGrade(sc);
                diary newWeek = new diary(week, grade);
                if (firstWeek == null) {
                    firstWeek = newWeek;
                    lastWeek = firstWeek;
                }
                else
                {
                    lastWeek.next = newWeek;
                    lastWeek = lastWeek.next;
                }
            }
            if (str.equals("42"))
                end(firstWeek);
            wrong();
        }
    }
}
