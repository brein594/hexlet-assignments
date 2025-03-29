package exercise;

import java.util.Map;
import java.util.HashMap;
// BEGIN

public class FileKV implements KeyValueStorage  {
    private String pathToFile;
    //private HashMap<String, String> storage;

    public FileKV(String pathToFile, Map<String, String> map) {
        String jsonWriteFile = Utils.serialize(map);
        this.pathToFile = pathToFile;
        Utils.writeFile(pathToFile, jsonWriteFile);
        /*
        this.pathToFile = pathToFile;
        storage = new HashMap<String, String>();
        var entries = map.entrySet();
        for (var entry : entries) {
            storage.put(entry.getKey(), entry.getValue());
        }
        */
    }

    public void set(String key, String value) {
        Map<String, String> rewriteFile = Utils.deserialize(Utils.readFile(pathToFile));
        rewriteFile.put(key, value);
        String jsonWriteFile = Utils.serialize(rewriteFile);
        Utils.writeFile(pathToFile, jsonWriteFile);
    }

    public void unset(String key) {
        Map<String, String> rewriteFile = Utils.deserialize(Utils.readFile(pathToFile));
        rewriteFile.remove(key);
        String jsonWriteFile = Utils.serialize(rewriteFile);
        Utils.writeFile(pathToFile, jsonWriteFile);
    }

    public String get(String key, String defaultValue) {
        Map<String, String> rewriteFile = Utils.deserialize(Utils.readFile(pathToFile));
        return rewriteFile.getOrDefault(key, defaultValue);
    }

   public Map<String, String> toMap(){
        /*
        HashMap<String, String> newStorage = new HashMap<>();
        var entries = storage.entrySet();
        for (var entry : entries) {
            newStorage.put(entry.getKey(), entry.getValue());
        }
        return newStorage;

         */
       return Utils.deserialize(Utils.readFile(pathToFile));
   }



}


// END
