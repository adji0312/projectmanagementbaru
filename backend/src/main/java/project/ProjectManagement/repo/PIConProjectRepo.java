package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.ProjectManagement.model.PIConProject;
import project.ProjectManagement.model.ProjectPIC;
import project.ProjectManagement.model.User;

import java.util.List;
import java.util.Optional;

public interface PIConProjectRepo extends JpaRepository<PIConProject, Long> {

    @Query(value = "SELECT u FROM PIConProject u WHERE u.pic_id = :PIConProject")
    Optional<PIConProject> findByPICId(@Param("PIConProject") String PIConProject);

    @Modifying
    @Query(value = "DELETE FROM PIConProject where pic_id = :pic_id")
    void deletePIConProjectByPic_id(@Param("pic_id") String pic_id);
}
