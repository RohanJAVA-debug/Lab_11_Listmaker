import java.util.Scanner;

public class SafeInput
{
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input;

        do
        {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();

            if(input.matches(regEx))
            {
                return input;
            }

            System.out.println("Invalid input.");
        }
        while(true);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value;

        do
        {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();

                if(value >= low && value <= high)
                {
                    return value;
                }
            }
            else
            {
                pipe.nextLine();
            }

            System.out.println("Invalid input.");
        }
        while(true);
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String input;

        do
        {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim().toUpperCase();

            if(input.equals("Y"))
            {
                return true;
            }

            if(input.equals("N"))
            {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
        while(true);
    }
}