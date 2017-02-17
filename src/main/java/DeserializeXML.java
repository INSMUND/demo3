import com.thoughtworks.xstream.XStream;


public class DeserializeXML {
    public ValCurs convert(String s){
        XStream xstream = new XStream();
        xstream.addImplicitCollection(ValCurs.class, "Valutes");
        xstream.processAnnotations(ValCurs.class);
        ValCurs ValCurs = (ValCurs) xstream.fromXML(s);
        return ValCurs;

    }
}
