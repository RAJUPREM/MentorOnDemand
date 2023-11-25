package com.mentorOnDemand.Admin;

import java.util.List;



public interface AdminService {
	
	public List<Admin> getAllAdmin();
	
	public Admin getAdminById(int adminId);
	
	public Admin saveAdmin(Admin admin);
	
	public Admin updateAdminByAdminId( Admin admin, int adminId);
	
	public Admin deleteAdminByAdminId(int adminId);

}
