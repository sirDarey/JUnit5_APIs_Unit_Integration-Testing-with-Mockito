package sirdarey.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import sirdarey.entity.Admin;

@DataJpaTest
class AdminRepoTest {
	
	
	@Autowired
	AdminRepo adminRepo;

	@Test
	void testAdminList() {
		adminRepo.save(new Admin("Test 1", "test1*gmail.com", "2222", "admin", "test1.jpg", "myself"));
		assertTrue(adminRepo.adminList().size() > 0);
	}
}
