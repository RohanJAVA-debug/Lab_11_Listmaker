import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        String choice;

        do
        {
            System.out.println("\nCurrent List:");

            if(list.size() == 0)
            {
                System.out.println("[List is Empty]");
            }
            else
            {
                for(int i = 0; i < list.size(); i++)
                {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
            }

            System.out.println("\nMenu");
            System.out.println("A - Add");
            System.out.println("D - Delete");
            System.out.println("I - Insert");
            System.out.println("P - Print");
            System.out.println("Q - Quit");

            choice = SafeInput.getRegExString(in,
                    "Enter choice",
                    "[AaDdIiPpQq]").toUpperCase();

            switch(choice)
            {
                case "A":

                    System.out.print("Enter item to add: ");
                    String addItem = in.nextLine();

                    list.add(addItem);

                    break;

                case "D":

                    if(list.size() > 0)
                    {
                        int deletePos =
                                SafeInput.getRangedInt(
                                        in,
                                        "Enter item number to delete",
                                        1,
                                        list.size());

                        list.remove(deletePos - 1);
                    }
                    else
                    {
                        System.out.println("List is empty.");
                    }

                    break;

                case "I":

                    int insertPos =
                            SafeInput.getRangedInt(
                                    in,
                                    "Enter insertion position",
                                    1,
                                    list.size() + 1);

                    System.out.print("Enter item to insert: ");
                    String insertItem = in.nextLine();

                    list.add(insertPos - 1, insertItem);

                    break;

                case "P":

                    System.out.println("\nCurrent List:");

                    if(list.size() == 0)
                    {
                        System.out.println("[List is Empty]");
                    }
                    else
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            System.out.println((i + 1) + ". " + list.get(i));
                        }
                    }

                    break;

                case "Q":

                    if(SafeInput.getYNConfirm(in,
                            "Are you sure you want to quit?"))
                    {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }

                    break;
            }

        } while(true);
    }
}
