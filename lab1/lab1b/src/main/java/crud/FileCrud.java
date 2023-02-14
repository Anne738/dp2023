package crud;

import Elements.Element;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fileIO.FileIO;
import fileIO.fileIOInterface;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FileCrud implements Lab2CrudInterface {
    fileIOInterface fio;
    public FileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public Element readEntity() {
        return (Element) fio.loadFromFile();
    }

    @Override
    public void updateEntity(Element el) {
        fio.savetoFile(el);
    }

    public JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch ( IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }
    @Override
    public Element Parse(HttpServletRequest request) {
        Element ent = new Element();
        JsonElement jsonElement = bodyParse(request);
        System.out.println(jsonElement);
        ent.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        ent.setImages(jsonElement.getAsJsonObject().get("images").getAsString());
        ent.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        ent.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        return ent;
    }

    @Override
    public int getIndexById(int id, List<Element> list) {
        int listId = id;

        Iterator<Element> iterator = list.iterator();
        while(((Iterator<?>) iterator).hasNext()) {
            Element temp = iterator.next();
            if(temp.getId() == listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
    @Override
    public int getNextId(List<Element> list) {
        int maxId = 0;

        Iterator<Element> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}
