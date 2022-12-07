package project.ProjectManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.ProjectManagement.exception.ProjectPICNotFoundException;
import project.ProjectManagement.exception.UserNotFoundException;
import project.ProjectManagement.model.PIConProject;
import project.ProjectManagement.model.ProjectPIC;
import project.ProjectManagement.model.User;
import project.ProjectManagement.repo.PIConProjectRepo;
import project.ProjectManagement.repo.ProjectPICRepo;
import project.ProjectManagement.repo.UserRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectPICService {

    private final ProjectPICRepo projectPICRepo;
    private final PIConProjectRepo picOnProjectRepo;
    private final UserRepo userRepo;

    @Autowired
    public ProjectPICService(ProjectPICRepo projectPICRepo, PIConProjectRepo picOnProjectRepo, UserRepo userRepo) {
        this.projectPICRepo = projectPICRepo;
        this.picOnProjectRepo = picOnProjectRepo;
        this.userRepo = userRepo;
    }

    public ProjectPIC getProjectPIC(String project_code, String user_id){
        return projectPICRepo.findProjectPICByPICId( project_code, user_id).orElseThrow( () -> new ProjectPICNotFoundException("Project PIC Not Found"));
    }

    public ProjectPIC addPIC(String project_code, String user_id) {

        Optional<ProjectPIC> projectPIC = projectPICRepo.findProjectPICByPICId(project_code, user_id);
        User findUser = userRepo.findByUserID(user_id).orElseThrow(() -> new UserNotFoundException("User Not Found"));


        if(projectPIC.isEmpty()){
            //Create PIC
            ProjectPIC newPIC = new ProjectPIC();
            newPIC.setPic_name(findUser.getUser_name());
            newPIC.setPic_id(findUser.getUser_id());
            newPIC.setProject_code(project_code);
            newPIC.setCreated_date(new Date());

            Optional<PIConProject> findPIConProject = picOnProjectRepo.findByPICId(user_id);

           if(findPIConProject.isEmpty()){
                PIConProject newPIConProject = new PIConProject();
                newPIConProject.setPic_flag(true);
                newPIConProject.setPic_id(user_id);
                newPIConProject.setCreated_date(new Date());
                picOnProjectRepo.save(newPIConProject);
           }else{
               PIConProject updatePIConProject = picOnProjectRepo.findByPICId(user_id).orElseThrow(() -> new ProjectPICNotFoundException("PIC Not Found"));

               if(updatePIConProject.getPic_flag() == false){
                   // PIC Available
                   updatePIConProject.setPic_flag(true);
                   updatePIConProject.setModify_date(new Date());
                   picOnProjectRepo.save(updatePIConProject);
               }else{
                   //PIC Not Available
                   return null;
               }
           }

            return projectPICRepo.save(newPIC);

        }else{
            //Update PIC
            ProjectPIC updatedPIC = projectPICRepo.findProjectPICByPICId(project_code, user_id).orElseThrow();

            updatedPIC.setPic_name(findUser.getUser_name());
            updatedPIC.setModify_date(new Date());

            return projectPICRepo.save(updatedPIC);
        }

    }


    public List<ProjectPIC> getProjectPICDev(String project_code){
        return projectPICRepo.findProjectPICByProjectCode(project_code);
    }

    public void deletePIC(String project_code, String user_id){
        picOnProjectRepo.deletePIConProjectByPic_id(user_id);
        projectPICRepo.deleteProjectPICByPic_id(project_code,user_id);
    }

}
