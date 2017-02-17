import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class GetEndpointProperty {
    public Properties load(
            final String filePathAndName)
    {
        final Properties properties = new Properties();
        try
        {
            final FileInputStream in = new FileInputStream(filePathAndName);
            properties.load(in);
            in.close();
        }
        catch (FileNotFoundException fnfEx)
        {
            System.err.println("Could not read properties from file " + filePathAndName);
        }
        catch (IOException ioEx)
        {
            System.err.println(
                    "IOException encountered while reading from " + filePathAndName);
        }
        return properties;
    }
}
