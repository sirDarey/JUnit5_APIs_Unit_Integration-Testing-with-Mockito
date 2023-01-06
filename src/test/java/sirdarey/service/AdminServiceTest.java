package sirdarey.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sirdarey.entity.Admin;
import sirdarey.repo.AdminRepo;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

	@Mock 
	private AdminRepo adminRepo;
	private AdminService underTest;
	
	@BeforeEach
	void setUp () {
		underTest = new AdminService(adminRepo);
	}
	
	@Test
	void testCanGetAdmins() {
		underTest.getAdmins();
		verify(adminRepo).adminList();
	}

	@Test
	@Disabled
	void testGetAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testCanAddAdmin() {
		Admin newAdmin = new Admin("Test 1", "test1*gmail.com", "2222", "admin", "test1.jpg", "myself");
		
		underTest.addAdmin(newAdmin);
		ArgumentCaptor<Admin> argumentCaptor = ArgumentCaptor.forClass(Admin.class);
		
		verify(adminRepo).save(argumentCaptor.capture());
		Admin capturedAdmin = argumentCaptor.getValue();
		
		assertThat(capturedAdmin).isEqualTo(capturedAdmin);
	}

	@Test
	@Disabled
	void testUpdateAdmin() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteAdmin() {
		fail("Not yet implemented");
	}

}
