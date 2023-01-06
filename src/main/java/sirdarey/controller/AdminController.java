package sirdarey.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sirdarey.entity.Admin;
import sirdarey.entity.Admins;
import sirdarey.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@GetMapping
	public Admins getAdmins() {
		return adminService.getAdmins();
    }
	
	@GetMapping("/{id}")
	public Admin getAdmin (@PathVariable int id) {
		return adminService.getAdmin(id);
	}

	@PostMapping
	public void addAdmin (@RequestBody Admin newAdmin) {
		adminService.addAdmin(newAdmin);
	}
	
	@PutMapping("/{id}")
	public void updateAdmin (@RequestBody Admin admin, @PathVariable int id) {
		adminService.updateAdmin(admin, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAdmin (@PathVariable int id) {
		adminService.deleteAdmin(id);
	}
	
	@GetMapping("checkEmail/{email}")
	public String checkEmail (@PathVariable String email) {
		
		List <String> result = new ArrayList<String>();
		String sql = "Select email from admins";
		result.addAll(jdbc.queryForList(sql, String.class));
		if (result.contains(email)) {
			return "Email Already Used";
		} else {
			return null;
		}
		
	}
	
	@GetMapping ("/imagePath")
	public String getAdminImagePath () {
		return "C:/STS Workspace/PROJECT1_MicroService_Admin/images/";
	}
	
	@GetMapping ("/getLastIndex")
	public int getLastIndex () {
				
		List <Integer> result = new ArrayList<Integer>();
		String sql = "Select admins_id from admins ORDER by admins_id ASC";
		result.addAll(jdbc.queryForList(sql, Integer.class));
		return result.get(result.size()-1);
	}
	
}
