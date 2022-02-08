import java.util.ArrayList;

public class ExceptionCatcher {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Successfully casted " + myList.get(i));
            }
            catch (Exception e){
                System.out.println("Unable to cast " + myList.get(i) + " at index " + i);
                System.out.println("Got error: " + e);
            }
        }
    }
}
