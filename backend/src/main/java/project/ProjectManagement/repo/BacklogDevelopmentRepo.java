package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.ProjectManagement.model.BacklogDevelopment;
import project.ProjectManagement.model.Project;

import java.util.List;
import java.util.Optional;

public interface BacklogDevelopmentRepo extends JpaRepository<BacklogDevelopment, Long> {
    Optional<BacklogDevelopment> findBacklogDevelopmentById(Long id);

    @Query(value = "SELECT u FROM BacklogDevelopment u WHERE u.backlog_code = :backlog_code")
    Optional<BacklogDevelopment> findByBacklog_code(@Param("backlog_code") String backlog_code);

    @Override
    @Query("SELECT u FROM BacklogDevelopment u WHERE u.backlog_status = 'KIC' OR u.backlog_status = 'DEV'  ")
    List<BacklogDevelopment> findAll();

    @Modifying
    @Query("DELETE FROM BacklogDevelopment WHERE backlog_code = :backlog_code")
    void deleteBacklogDevelopmentByBacklog_code(@Param("backlog_code") String backlog_code);
}
