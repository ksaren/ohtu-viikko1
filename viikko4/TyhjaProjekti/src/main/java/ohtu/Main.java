package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "013467313";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";
        String verrokkiUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";
                
        int tehtavia = 0;
        int tunteja = 0;
        
        try {
            String verrokkiBody = Request.Get(verrokkiUrl).execute().returnContent().asString();
            System.out.println("json-muotoinen data:");
            System.out.println(verrokkiBody);

            Gson verrokkiMapper = new Gson();
            Course verrokki = verrokkiMapper.fromJson(verrokkiBody, Course.class);

            String bodyText = Request.Get(url).execute().returnContent().asString();
            System.out.println("json-muotoinen data:");
            System.out.println(bodyText);

            Gson mapper = new Gson();
            Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

            System.out.println("opiskelijanumero: "+studentNr);
            System.out.println("");
            System.out.println("Kurssi: "+verrokki.getName()+", "+verrokki.getTerm());
            System.out.println("");
            for (Submission submission : subs) {
                switch (submission.getWeek()) {
                    case 1: submission.setMaxPoints(verrokki.getWeek1());
                            break;
                    case 2: submission.setMaxPoints(verrokki.getWeek2());
                            break;
                    case 3: submission.setMaxPoints(verrokki.getWeek3());
                            break;
                    case 4: submission.setMaxPoints(verrokki.getWeek4());
                            break;
                    case 5: submission.setMaxPoints(verrokki.getWeek5());
                            break;
                    case 6: submission.setMaxPoints(verrokki.getWeek6());
                            break;
//                    case 7: submission.setMaxPoints(verrokki.getWeek7());
//                    case 8: submission.setMaxPoints(verrokki.getWeek8());
//                    case 9: submission.setMaxPoints(verrokki.getWeek9());
//                    case 10: submission.setMaxPoints(verrokki.getWeek10());
//                    case 11: submission.setMaxPoints(verrokki.getWeek11());
//                    case 12: submission.setMaxPoints(verrokki.getWeek12());
         
                }
                System.out.println(submission);
                tehtavia+=submission.getPoints();
                tunteja+=submission.getHours();
            }
            System.out.println("");
            System.out.println("yhteensä: "+tehtavia+" tehtävää "+tunteja+" tuntia");

        } catch (ClientProtocolException cpe) {
            System.err.println("Protokollapoikkeus: " + cpe);
        } catch (IOException ioe) {
            System.err.println("IO-poikkeus: "+ioe);
        }

//    
    }
}
