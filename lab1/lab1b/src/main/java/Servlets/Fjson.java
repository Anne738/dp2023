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

public class Fjson {
    public JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }


    public Element Parse(HttpServletRequest request) {
        Element el = new Element();
        JsonElement jsonElement = bodyParse(request);
        el.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        el.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        el.setImages(jsonElement.getAsJsonObject().get("img").getAsString());
        el.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return el;
    }

    public int getNextId(List<Element> list) {
        int maxId = 0;

        Iterator<Element> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
    public int getIndexById(int id, List<Element> list) {
        int listId = id;

        Iterator<Element> iterator = list.iterator();
        while(iterator.hasNext()) {
            Element el = iterator.next();
            if(el.getId()==listId) {
                listId=list.indexOf(el);
                break;
            }
        }
        return listId;
    }



}
