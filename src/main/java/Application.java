import java.util.Locale;
import java.util.ResourceBundle;

public class Application {

    public static void main(String[] args) {


        new Client().start();


//        Locale locale = new Locale("en", "US");
//        System.out.println(locale.getDisplayCountry());
//
//        Locale locale1 = new Locale("ru", "RU");
//        System.out.println(locale1.getDisplayCountry());
//
//        ResourceBundle resourceBundle =  ResourceBundle.getBundle("localization", locale1);
//        System.out.println("resourceBundle.getString(\"name\") = " + resourceBundle.getString("name"));

    }
}