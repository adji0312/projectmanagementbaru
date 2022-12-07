package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.ProjectManagement.model.Project;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Optional<Project> findProjectById(Long id);

    @Query("SELECT u FROM Project u WHERE u.project_code = :code")
    Optional<Project> findByProject_code(@Param("code") String code);
}
