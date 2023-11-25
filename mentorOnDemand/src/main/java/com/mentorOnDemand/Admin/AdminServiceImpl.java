package com.mentorOnDemand.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> ladmin=adminRepository.findAll();
		return ladmin;
	}
	
	@Override
	public Admin getAdminById(int adminId) {
		Optional<Admin> tempAdmin=adminRepository.findById(adminId);
		Admin admin=tempAdmin.get();
		return admin;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		adminRepository.save(admin);
		return admin;
	}

	@Override
	public Admin updateAdminByAdminId(Admin admin, int adminId) {
		Optional<Admin> tempAdmin=adminRepository.findById(adminId);
		Admin newAdmin=tempAdmin.get();
		newAdmin.setAdminName(admin.getAdminName());
		newAdmin.setAdminPassword(admin.getAdminPassword());
		adminRepository.save(newAdmin);
		return newAdmin;
	}

	@Override
	public Admin deleteAdminByAdminId(int adminId) {
		adminRepository.deleteById(adminId);
		return null;
	}

}
