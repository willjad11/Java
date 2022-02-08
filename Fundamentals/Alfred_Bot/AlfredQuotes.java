import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String output = String.format("Hello, %s. Lovely to see you.", name);
        return output;
    }
    
    public String dateAnnouncement() {
        String output = String.format("It is currently ");
        return output + new Date();
    }
    
    public String respondBeforeAlexis(String conversation) {
        String output = "";
        if (conversation.indexOf("Alexis") != -1) {
            output = "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (conversation.indexOf("Alfred") != -1) {
            output = "At your service. As you wish, naturally.";
        }
        else {
            output = "Right. And with that I shall retire." ;
        }
        return output;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

