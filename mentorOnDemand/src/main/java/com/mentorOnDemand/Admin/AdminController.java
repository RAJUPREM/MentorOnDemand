package com.mentorOnDemand.Admin;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	AdminServiceImpl AdminServiceImpl;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to admin cotroller";
	}

	@GetMapping("/")
    public ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> admins = AdminServiceImpl.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int adminId){
    	Admin admin=AdminServiceImpl.getAdminById(adminId);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
    	Admin newAdmin=AdminServiceImpl.saveAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.OK);
    }

    @PutMapping("/update/{adminId}")
    public ResponseEntity<Admin> updateAdminByAdminId(@RequestBody Admin admin, @PathVariable int adminId){
    	Admin adminRes=AdminServiceImpl.updateAdminByAdminId(admin, adminId);
        return new ResponseEntity<>(adminRes, HttpStatus.OK);
    }

    @DeleteMapping("delete/{adminId}")
    public ResponseEntity<Admin> deleteAdminByAdminId(@PathVariable int adminId){
    	Admin newAdmin=AdminServiceImpl.deleteAdminByAdminId(adminId);
        return new ResponseEntity<>(newAdmin, HttpStatus.OK);
    }

}
