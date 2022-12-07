package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.ProjectManagement.model.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findRoleById(Long id);

    @Query(value = "SELECT u FROM Role u WHERE u.role_id = :role_id")
    Role findRoleByRole_id(@Param("role_id") String role_id);
}
