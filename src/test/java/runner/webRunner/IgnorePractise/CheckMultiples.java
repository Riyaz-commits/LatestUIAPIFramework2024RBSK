package runner.webRunner.IgnorePractise;

public class CheckMultiples {

    public static void main(String[] args) {
        for (int i =1; i<=10;i++)
        {
            if(i%2==0 && i%5==0)
            {
                System.out.println(i);
            }
        }
    }
}
