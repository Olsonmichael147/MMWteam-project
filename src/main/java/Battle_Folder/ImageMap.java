package Battle_Folder;

import java.util.HashMap;
import java.util.Map;

public class ImageMap {
    private final HashMap<String, String> nameToImage = new HashMap<String, String>(Map.ofEntries(
            Map.entry("Flint, the Fire Archer", "INPUT"),







    ));



    public String getImageFromName(String name){
        if (nameToImage.get(name) == null){
            throw new IllegalArgumentException("No such card with this name exists");
        }
        else{
            return nameToImage.get(name);
        }
    }

}
