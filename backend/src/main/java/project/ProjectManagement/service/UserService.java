package project.ProjectManagement.service;

import aj.org.objectweb.asm.ConstantDynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.ProjectManagement.exception.UserNotFoundException;
import project.ProjectManagement.model.ProjectPIC;
import project.ProjectManagement.model.Role;
import project.ProjectManagement.model.User;
import project.ProjectManagement.repo.ProjectPICRepo;
import project.ProjectManagement.repo.RoleRepo;
import project.ProjectManagement.repo.UserRepo;
import project.ProjectManagement.util.PasswordUtil;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepo userRepo;
    private final RoleService roleService;

//    PasswordEncoder passwordEncoder;

    //COMMENT


    @Autowired
    public UserService(UserRepo userRepo, RoleService roleService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User addUser(User user){

        String toLower = user.getUser_id().toLowerCase();
        String password = PasswordUtil.getPasswordHash(toLower); //untuk hash password
        user.setCreated_date(new Date());
        user.setPassword(password);
        Boolean y = true;
        user.setEnabled(y);
        return userRepo.save(user);
    }

    public User getUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User getUserByUserID(String userID){
        return userRepo.findByUserID(userID).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User updateUser(User user, Long id){

        User updatedUser = userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        updatedUser.setUser_id(user.getUser_id());
        String toLower = user.getUser_id().toLowerCase();
        String password = PasswordUtil.getPasswordHash(toLower);
        updatedUser.setPassword(password);
        updatedUser.setUser_name(user.getUser_name());
        updatedUser.setRole(user.getRole());
        updatedUser.setModify_date(new Date());
//        updatedUser.setModify_by(this.getUserIdFromContext());
        return userRepo.save(updatedUser);
    }

    public void deleteUser(Long id){
        User deletedUser = userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userRepo.delete(deletedUser);
    }

    public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setCreated_date(new Date());
        return userRepo.save(user);
    }

//    public User getUserID(String userid){
//        return userRepo.findUserID(userid);
//    }
//
//    public User save(User user) {
//        String password = PasswordUtil.getPasswordHash(user.getPassword());
//        user.setPassword(password);
//        user.setCreated_date(new Date());
//        return userRepo.save(user);
//    }

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepo.findUserID(username);
//        return new org.springframework.security.core.userdetails.User(user.getUser_id(), user.getPassword(), new ArrayList<>());
//    }
}
