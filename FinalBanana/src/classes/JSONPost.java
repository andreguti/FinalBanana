/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.google.gson.*;
import java.io.BufferedReader;

/**
 *
 * @author fjcorona
 */
public class JSONPost {
    
    public static JsonObject getJsonObject(BufferedReader reqReader) {
        StringBuilder jb = new StringBuilder();
        String line = null;
        
        try {
            BufferedReader reader = reqReader;
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
        }
        
        String jsonString = jb.toString();
        
        /*
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonString);
        return jsonObject;
        */
        
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        return jsonObject;
    }
    
}
