package ohtu.io;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class StubIO implements IO {

    private List<String> lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }
    
    //@Autowired
    public StubIO(String command, String username, String pwd) {
        this.lines = new ArrayList();
        this.lines.add(command);
        this.lines.add(username);
        this.lines.add(pwd);
        prints = new ArrayList<>();
    }

    public StubIO() {
    }

    

    public void print(String toPrint) {
        prints.add(toPrint);
    }

    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(lines.get(i++));
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public String readLine(String prompt) {
        print(prompt);
        if (i < lines.size()) {
            return lines.get(i++);
        }
        return "";
    }
}
