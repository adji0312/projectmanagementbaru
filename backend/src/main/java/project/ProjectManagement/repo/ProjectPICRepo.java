package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.ProjectManagement.model.ProjectPIC;
import project.ProjectManagement.model.User;

import java.util.List;
import java.util.Optional;

public interface ProjectPICRepo extends JpaRepository<ProjectPIC, Long> {

    @Query(value = "SELECT u FROM ProjectPIC u WHERE u.pic_id = :picID AND u.project_code = :project_code")
    Optional<ProjectPIC> findProjectPICByPICId(@Param("project_code") String project_code, @Param("picID") String picID);

//    @Query(value = "SELECT u FROM ProjectPIC u WHERE u.pic_id = :picID")
//    Optional<ProjectPIC> findProjectPICByPICId(@Param("picID") String picID);

    @Query(value = "SELECT u FROM ProjectPIC u WHERE u.project_code = :project_code")
    List<ProjectPIC> findProjectPICByProjectCode(@Param("project_code") String project_code);

    @Modifying
    @Query(value = "DELETE FROM ProjectPIC u WHERE u.project_code = :project_code")
    void deleteProjectPICByProject_code(@Param("project_code") String project_code);

    @Modifying
    @Query (value = "DELETE FROM ProjectPIC u WHERE u.pic_id = :pic_id AND u.project_code = :project_code")
    void deleteProjectPICByPic_id(@Param("project_code") String project_code, @Param("pic_id") String pic_id);
}
