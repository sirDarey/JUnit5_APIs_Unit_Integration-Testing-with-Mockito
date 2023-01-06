package sirdarey.entity;

import java.util.List;

public class Admins {
	List<Admin> adminList;
	
	public Admins () {}

	public Admins(List<Admin> adminList) {
		this.adminList = adminList;
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}	
}
