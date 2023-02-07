package crud;

import Elements.Element;
import fileIO.FileIO;
import fileIO.fileIOInterface;

public class FileCrud implements Lab2CrudInterface {

    fileIOInterface fio;

    public FileCrud(){
        this.fio = new FileIO();
    }

    @Override
    public Element readElement() {
        return (Element) fio.loadFromFile();
    }

    @Override
    public void updateElement(Element element) {
        fio.saveToFile(element);
    }
}
