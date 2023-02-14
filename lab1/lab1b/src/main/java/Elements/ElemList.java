package Elements;

import java.util.ArrayList;
import java.util.List;

public class ElemList {
    private List<Element> elemlist = new ArrayList<>();

    public ElemList () {
        this.elemlist.add(new Element( 1, "assets/ja.jpeg", 178000, "JAVELIN" ));
        this.elemlist.add(new Element( 2,"assets/st.png", 20000, "STUPNA-P" ));
        this.elemlist.add(new Element( 3,"assets/kor.png", 120000, "KORSAR" ));
        this.elemlist.add(new Element( 4,"assets/nlaw.jpeg", 27000, "NLAW" ));
    }
    public List<Element> getElemlist() {
        return elemlist;
    }

    public void setElemlist(List<Element> elemlist) {
        this.elemlist = elemlist;
    }

}
