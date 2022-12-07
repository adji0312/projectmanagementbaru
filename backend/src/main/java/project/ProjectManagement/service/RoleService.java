package project.ProjectManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import project.UserManagement.exception.RoleNotFoundException;
import project.ProjectManagement.exception.RoleNotFoundException;
import project.ProjectManagement.model.Role;
import project.ProjectManagement.repo.RoleRepo;

//import javax.management.relation.RoleNotFoundException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    public List<Role> getAllRole(){
        return roleRepo.findAll();
    }

    public Role addRole(Role role){
        role.setCreated_date(new Date());
        return roleRepo.save(role);
    }

    public Role getRoleById(Long id) throws RoleNotFoundException {
        return roleRepo.findRoleById(id).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
    }

    public Role getRoleByRoleID(String role_id){
        return roleRepo.findRoleByRole_id(role_id);
    }

    public Role updateRole(Long id, Role role) throws RoleNotFoundException {
        Role updatedRole = roleRepo.findRoleById(id).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
        updatedRole.setRole_id(role.getRole_id());
        updatedRole.setRole_name(role.getRole_name());
        updatedRole.setRole_desc(role.getRole_desc());
        updatedRole.setModify_date(new Date());
        return roleRepo.save(updatedRole);
    }

    public void deleteRole(Long id) throws RoleNotFoundException {
        Role deletedRole = roleRepo.findRoleById(id).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
        roleRepo.delete(deletedRole);
    }
}
