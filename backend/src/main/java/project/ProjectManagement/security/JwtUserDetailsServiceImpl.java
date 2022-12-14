package project.ProjectManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.ProjectManagement.model.User;
import project.ProjectManagement.repo.UserRepo;

import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User user = userRepo.findUserID(userid);
        if(user == null){
            throw new UsernameNotFoundException(String.format("No User Found with USERID '%s'.", userid));
        }else{
            return JwtUserFactory.create(user);
        }
    }
}
