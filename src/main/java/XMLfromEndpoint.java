import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class XMLfromEndpoint {
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String result = "";
    public String importing(String dateURL) {

        try
        {
            URL url = new URL(dateURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;


            while ((line = reader.readLine()) != null) {
                {
                    buffer.append(line);
                }
            }
            result = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
