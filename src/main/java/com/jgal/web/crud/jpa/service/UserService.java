package com.jgal.web.crud.jpa.service;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
 
import com.jgal.web.crud.jpa.da.UserDAO;
import com.jgal.web.crud.jpa.model.User;
 
@Service("userService")
public class UserService implements ServiceFacade {
 
    @Autowired
    private UserDAO userDAO;
 
    public Object doService(Object... args) throws Exception {
        Assert.notNull(args[0]);
        /*if (args[0].equals("insertBatch")) {
            userDAO.save(userData());
            return true;
        } else*/
        if (args[0].equals("insert")) {
            userDAO.save((User) args[1]);
            return 1;
        } else if (args[0].equals("update")) {
            userDAO.save((User) args[1]);
            return 1;
        } else if (args[0].equals("delete")) {
            long id = Long.parseLong((String) args[1]);
            userDAO.delete(id);
            return 1;
        } else if (args[0].equals("getAll")) {
            return userDAO.findAll();
        }
        return null;
    }
 
    /*private List<User> userData() {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", "Doe", "25", "M"));
        users.add(new User("Jane", "Doe", "23", "F"));
        users.add(new User("Sarah", "Bosch", "34", "F"));
        users.add(new User("Michael", "Murray", "20", "M"));
        users.add(new User("Barry", "Coy", "19", "M"));
        users.add(new User("Daisy", "Chen", "19", "F"));
        users.add(new User("May", "Williams", "15", "F"));
        users.add(new User("Alex", "Johnson", "40", "M"));
        users.add(new User("Ceasar", "McCoy", "39", "M"));
        users.add(new User("Paula", "May", "22", "F"));
        return users;
    }*/
}