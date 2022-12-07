package project.ProjectManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ProjectManagement.model.ProjectType;
import project.ProjectManagement.service.ProjectTypeService;
import project.ProjectManagement.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/projectType")
public class ProjectTypeController {

    private final ProjectTypeService projectTypeService;

    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping("/all")
    public List<ProjectType> projectTypeList(){
        return projectTypeService.getAllProjectType();
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectType> addProjectType(@RequestBody ProjectType projectType){
        ProjectType newProjectType = projectTypeService.addProjectType(projectType);
        return new ResponseEntity<>(newProjectType, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectType> updateProjectType(@PathVariable("id") Long id, @RequestBody ProjectType projectType){
        ProjectType updateProjectType = projectTypeService.updateProjectType(id,projectType);
        return new ResponseEntity<>(updateProjectType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProjectType> deleteProjectType(@PathVariable("id") Long id){
        projectTypeService.deleteProjectType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
