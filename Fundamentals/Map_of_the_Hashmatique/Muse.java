import java.util.HashMap;
import java.util.Set;

public class Muse {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Uprising", "Lyrics");

        trackList.put("Pressure", "Lyrics");

        trackList.put("Starlight", "Lyrics");

        trackList.put("Madness", "Lyrics");

        String name = trackList.get("Madness");
        System.out.println(name);

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}
