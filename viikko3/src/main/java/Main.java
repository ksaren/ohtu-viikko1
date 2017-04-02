
import java.util.*;
import ohtu.Multiplier;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Who are you?");
        //String name = scanner.nextLine();
        //System.out.println("Hello "+name);
        //Multiplier three = new Multiplier(3); //commented out because there was a magic number...
        System.out.println("Anna luku: ");
        int number1 = scanner.nextInt();
        Multiplier multi = new Multiplier(number1);
        System.out.println("Anna toinen luku: ");
        int number2 = scanner.nextInt();

        System.out.println(number1 + " kertaa " + number2 + "on " + multi.multipliedBy(number2));

//        for (int i = 0; i < 1; i++) {
//            for (int j = 0; i < j; j++) {
//                System.out.println("virhe");
//            }
//        }
    }

}
