package project.ProjectManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ProjectManagement.model.BacklogDevelopment;
import project.ProjectManagement.service.BacklogDevelopmentService;

import java.util.List;

@RestController
@RequestMapping("/backlogDevelopment")
public class BacklogDevelopmentController {

    private final BacklogDevelopmentService backlogDevelopmentService;

    public BacklogDevelopmentController(BacklogDevelopmentService backlogDevelopmentService) {
        this.backlogDevelopmentService = backlogDevelopmentService;
    }

    @GetMapping("/all")
    public List<BacklogDevelopment> backlogDevelopmentList(){
        return backlogDevelopmentService.getAllBacklogDevelopment();
    }

    @GetMapping("/get/{code}")
    public BacklogDevelopment getBacklogDev(@PathVariable("code") String code){
        return backlogDevelopmentService.getBacklogDevelopment(code);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BacklogDevelopment> updateBacklogDevelopment(@PathVariable("id") Long id, @RequestBody BacklogDevelopment backlogDev){
        BacklogDevelopment backlogDevelopment = backlogDevelopmentService.updateBacklogDevelopment(id, backlogDev);
        return new ResponseEntity<>(backlogDevelopment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{backlog_code}")
    public ResponseEntity<BacklogDevelopment> deleteBacklogDevelopment(@PathVariable("backlog_code") String backlog_code){
        backlogDevelopmentService.deleteBacklogDevelopment(backlog_code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
