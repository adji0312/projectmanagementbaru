package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.ProjectManagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);

    @Query(value = "SELECT u FROM User u WHERE u.user_id = :userID")
    Optional<User> findByUserID(@Param("userID") String userID);

    @Query(value = "SELECT u FROM User u WHERE u.user_id = :userID")
    User findUserID(@Param("userID") String userID);

//    User findUserId(String username);

}
