import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordCrack {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList <Character> arrayCharacters = new ArrayList<Character>();
    private static String result = "";
    private static boolean loopBoolean = true;
    private static int min = 33;
    private static int max = 127;

    //Password to check
    private static String password = "/$a";

    //Method to set array list toString
    public static String setResult(){
        result = "";
        for (char i : arrayCharacters) {
            result += i;
        }
        return result;
    }


    //Main method
    public static void main(String[] args) {

        System.out.println("Password :");
        password = input.nextLine();


        while(loopBoolean){
            //Add one char
            arrayCharacters.add((char) min);
            //arrayCharacters.size()-1 to get one more char in array on start ...
            for (int i = 0; i < arrayCharacters.size()-1; i++) {
                if(!loopBoolean) break;

                for (int j = min; j <max ; j++) {
                    arrayCharacters.set(i, (char) j);


                    if(arrayCharacters.get(0).toString().equals(password)){
                        loopBoolean = false;
                        System.out.println("Erraten: " + arrayCharacters.get(0).toString());
                    }

                    extraLoop(i+1);
                }

            }
        }
    }

    //Method for extra loop
    public static void extraLoop(int number){

        for (int i = min; i < max; i++) {
            arrayCharacters.set(number,(char) i);

            //If first (one) letter is a passwod...
            if(setResult().equals(password)){
                loopBoolean = false;
                System.out.println("Erraten: " + setResult());
                break;
            }

            //if number is smaller from array.length -1 the call callback for one more loop...
            if(number<arrayCharacters.size()-1){
                extraLoop(number+1);
            }
        }

    }
}