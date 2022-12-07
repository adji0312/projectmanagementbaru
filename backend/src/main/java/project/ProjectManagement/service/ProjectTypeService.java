package project.ProjectManagement.service;

import org.springframework.stereotype.Service;
import project.ProjectManagement.exception.ProjectTypeException;
import project.ProjectManagement.model.ProjectType;
import project.ProjectManagement.repo.ProjectTypeRepo;

import java.util.Date;
import java.util.List;

@Service
public class ProjectTypeService {

    private final ProjectTypeRepo projectTypeRepo;

    public ProjectTypeService(ProjectTypeRepo projectTypeRepo) {
        this.projectTypeRepo = projectTypeRepo;
    }

    public List<ProjectType> getAllProjectType(){
        return projectTypeRepo.findAll();
    }

    public ProjectType getProjectTypeById(Long id) throws Exception{
        return projectTypeRepo.findProjectTypeById(id).orElseThrow(() -> new ProjectTypeException("Project Type Not Found"));
    }

    public ProjectType addProjectType(ProjectType projectType){
        projectType.setCreated_date(new Date());
        return projectTypeRepo.save(projectType);
    }

    public ProjectType updateProjectType(Long id, ProjectType projectType){
        ProjectType updatedProjectType = projectTypeRepo.findProjectTypeById(id).orElseThrow(() -> new ProjectTypeException("Project Type Not Found"));
        updatedProjectType.setProject_type(projectType.getProject_type());
        updatedProjectType.setProject_desc(projectType.getProject_desc());
        updatedProjectType.setModify_date(new Date());
        return projectTypeRepo.save(updatedProjectType);
    }

    public void deleteProjectType(Long id){
        ProjectType deletedProjectType = projectTypeRepo.findProjectTypeById(id).orElseThrow(() -> new ProjectTypeException("Project Type Not Found"));
        projectTypeRepo.delete(deletedProjectType);
    }
}
