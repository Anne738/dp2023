package Servlets;

import Elements.Element;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public static JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static Element Parse(HttpServletRequest request){
        Element elem = new Element();
        JsonElement jsonElement = bodyParse(request);
        elem.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        elem.setImages(jsonElement.getAsJsonObject().get("images").getAsString());
        elem.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        elem.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        return elem;
    }

    public static int getNextId(List<Element> list) {
        int maxId = 0;

        Iterator<Element> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByWatchId(int id, List<Element> list) {
        int listId = id;

        Iterator<Element> iterator = list.iterator();
        while(iterator.hasNext()) {
            Element temp = iterator.next();
            if(temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}