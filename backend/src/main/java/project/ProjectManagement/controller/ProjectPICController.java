package project.ProjectManagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ProjectManagement.model.ProjectPIC;
import project.ProjectManagement.model.User;
import project.ProjectManagement.service.ProjectPICService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pic")
public class ProjectPICController {

    private final ProjectPICService projectPICService;

    public ProjectPICController(ProjectPICService projectPICService) {
        this.projectPICService = projectPICService;
    }

    @PostMapping("/add/{project_code}/{user_id}")
    public ResponseEntity<ProjectPIC> addProjectPIC(@PathVariable("project_code") String project_code, @PathVariable("user_id") String user_id){
        ProjectPIC newProjectPIC = projectPICService.addPIC(project_code, user_id);
//        System.out.println(newProjectPIC);
        if(newProjectPIC == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newProjectPIC,HttpStatus.CREATED);
    }

    @GetMapping("/get/{project_code}/{user_id}")
    public ResponseEntity<ProjectPIC> getProjectPIC(@PathVariable("project_code") String project_code, @PathVariable("user_id") String user_id){
        ProjectPIC findProjectPIC = projectPICService.getProjectPIC(project_code, user_id);
        return new ResponseEntity<>(findProjectPIC, HttpStatus.OK);
    }

    @GetMapping("/getPICDev/{project_code}")
    public List<ProjectPIC> getProjectPICByProjectCode(@PathVariable("project_code") String project_code){
        return projectPICService.getProjectPICDev(project_code);
    }

    @DeleteMapping("/delete/{project_code}/{user_id}")
    public ResponseEntity<ProjectPIC> deleteProjectPIC(@PathVariable("project_code") String project_code, @PathVariable("user_id") String user_id){
        projectPICService.deletePIC(project_code, user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
