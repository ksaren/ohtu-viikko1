package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            System.out.println("nimi on käytössä!");
            return false;
        }

        if (invalid(username, password)) {
            System.out.println("Invalid nimi tai salasana!");
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        boolean noNumberFlag = true;
        boolean noSpecialFlag = true;
        if (username.length() < 3 || password.length() < 8) {
            System.out.println("pituusongelma! "+username+"= "+username.length()+password+"="+password.length());
            return true;    //is invalid
        }   
        for (char c : username.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return true;    //is invalid!
            }
        }

        for (char c : password.toCharArray()) {
        
                if (Character.isDigit(c)) { //numero löytyy
                    noNumberFlag = false;
                } else {                    //ei ole numero
                    if (!Character.isLetter(c)) { //eikä kirjain
                        noSpecialFlag = false;       //joten erikoismerkki löytyy   
                    }
                }
          
        }
        
        return (noNumberFlag||noSpecialFlag);
    }
}
