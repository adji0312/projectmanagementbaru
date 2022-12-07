package project.ProjectManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.ProjectManagement.domain.Response;
import project.ProjectManagement.model.User;
import project.ProjectManagement.service.UserService;

@RestController
public class PreLoginController{

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public ResponseEntity<Response> registration(@RequestBody User user){
        User dbUser = userService.addUser(user);
        if(dbUser != null){
            return new ResponseEntity<Response>(new Response("User is saves successfully"), HttpStatus.OK);
        }
        return null;
    }
}
