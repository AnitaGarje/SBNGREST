package com.jgal.web.crud.jpa.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.jgal.web.crud.jpa.model.ResponseObject;
import com.jgal.web.crud.jpa.model.User;
import com.jgal.web.crud.jpa.service.ServiceFacade;
 
@RestController
public class UserController {
     
    @Autowired
    private ServiceFacade userService;
     
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> userInfo() throws Exception {
        return (List<User>) userService.doService("getAll");
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject createUser(@RequestBody User user) throws Exception {
        return getResponseObject((Integer) userService.doService("insert", user));
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject updateUser(@RequestBody User user) throws Exception {
        return getResponseObject((Integer) userService.doService("update", user));
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject deleteUser(@RequestBody String id) throws Exception {
        return getResponseObject((Integer) userService.doService("delete", id));
    }
     
    private ResponseObject getResponseObject(Integer output){
        return new ResponseObject(output == 1 ? true : false, output == 1 ? "successful" : "failed");
    }
}