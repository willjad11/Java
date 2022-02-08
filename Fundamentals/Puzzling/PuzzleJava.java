import java.util.Random;
import java.util.Arrays;

public class PuzzleJava {
    Random randMachine = new Random();
    public int[] getTenRolls() {
        int[] output;
        output = new int[10];
        for (int i = 0; i < 10; i++) {
            output[i] = randMachine.ints(1, 25).findFirst().getAsInt();
        }
        return output;
    }

    public char getRandomLetter() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char output = letters[randMachine.ints(0, 25).findFirst().getAsInt()];
        return output;
    }

    public String generatePassword() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += letters[randMachine.ints(0, 25).findFirst().getAsInt()];
        }
        return password;
    }
    
    public String[] getNewPasswordSet(int length) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String[] output;
        output = new String[length];
        for (int i = 0; i < length; i++) {
            output[i] = generatePassword();
        }
        return output;
    }
}