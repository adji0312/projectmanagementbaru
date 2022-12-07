package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ProjectManagement.model.Project;
import project.ProjectManagement.model.ProjectType;

import java.util.Optional;

public interface ProjectTypeRepo extends JpaRepository<ProjectType, Long> {

    Optional<ProjectType> findProjectTypeById(Long id);
}
