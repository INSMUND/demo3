
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;



public class ValCurs {
    @XStreamAsAttribute
    private String Date;
    @XStreamAsAttribute
    private String name;
    @XStreamImplicit

    private List<Valute> Valutes =new ArrayList<Valute>();

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Valute> getValutes() {
        return Valutes;
    }

    public void setValutes(List<Valute> valutes) {
        Valutes = valutes;
    }
}
