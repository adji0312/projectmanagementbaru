package project.ProjectManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ProjectManagement.model.Role;
import project.ProjectManagement.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public List<Role> roleList(){
        return roleService.getAllRole();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {

        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping("/getRole/{role_id}")
    public ResponseEntity<Role> getRoleByRoleId(@PathVariable("role_id") String role_id){
        Role getRole = roleService.getRoleByRoleID(role_id);
        return new ResponseEntity<>(getRole, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role newRole = roleService.addRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") Long id,@RequestBody Role role){
        Role updateRole = roleService.updateRole(id,role);
        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
