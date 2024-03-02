import java.net.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Q07 {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URI uri = new URI("http://baeldung.com/guidelines.txt");
        URL url = uri.toURL();
	URLConnection connection = url.openConnection();
		
	try(InputStream inputStream = connection.getInputStream()){
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	String line;
	
	while((line = reader.readLine()) != null) {
	System.out.println(line);
	}
	}
    }
}

