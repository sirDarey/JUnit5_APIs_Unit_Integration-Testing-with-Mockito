package sirdarey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sirdarey.entity.Admin;
import sirdarey.entity.Admins;
import sirdarey.repo.AdminRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo adminRepo;
			
	public AdminService(AdminRepo adminRepo) {
		this.adminRepo = adminRepo;
	}

	public Admins getAdmins() {		
        return new Admins(adminRepo.adminList());
    }
	
	public Admin getAdmin(int id) {
		return adminRepo.findById(id).get();
	}

	public void addAdmin(Admin newAdmin) {
		adminRepo.save(newAdmin);
	}

	public void updateAdmin(Admin admin, int id) {
		Admin getAdmin = adminRepo.findById(id).get();
		
		getAdmin.setEmail(admin.getEmail());
		getAdmin.setName(admin.getName());
		getAdmin.setRole(admin.getRole());
		
		adminRepo.save(getAdmin);
	}

	public void deleteAdmin(int id) {
		adminRepo.deleteById(id);
	}

}
