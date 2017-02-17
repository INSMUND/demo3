import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Valute {
    @XStreamAsAttribute
    private String ID;
    private char[] NumCode;
    private char[] CharCode;
    private Integer Nominal;
    private String Name;
    private Double Value;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public char[] getCharCode() {
        return CharCode;
    }

    public char[] getNumCode() {
        return NumCode;
    }

    public void setNumCode(char[] numCode) {
        NumCode = numCode;
    }



    public void setCharCode(char[] charCode) {
        CharCode = charCode;
    }

    public int getNominal() {
        return Nominal;
    }

    public void setNominal(Integer nominal) {
        Nominal = nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }
}
