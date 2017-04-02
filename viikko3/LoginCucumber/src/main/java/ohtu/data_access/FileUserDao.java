/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kaisa
 */
@Component
public class FileUserDao implements UserDao {

    private FileWriter writer;
    private File file;
    private Scanner reader;
    private String filename;

    public FileUserDao(String filename) {
        this.filename = filename;
    }

    @Override
    public List<User> listAll() {
        ArrayList<User> list = new ArrayList();
        file = new File(filename);
        try {
        reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String[] details = reader.nextLine().split(",");

            list.add(new User(details[0], details[1]));
        }
        reader.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }

    @Override
    public User findByName(String name) {
        User user = null;
        file = new File(filename);
        try {
        reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] details = line.split(",");
            if (details[0].equals(name)) {
                user = new User(details[0], details[1]);
                break;
            }
        }
        reader.close();
        } catch (Exception e) {
            System.err.print(e);
        }
        return user;
    }

    @Override
    public void add(User user) {
        //file = new File(filename);
        try {
            writer = new FileWriter(filename, true);    //append
            writer.append(user.getUsername() + "," + user.getPassword() + "\n");
            writer.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        
    }
    

}
