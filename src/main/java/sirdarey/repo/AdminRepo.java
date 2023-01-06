package sirdarey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sirdarey.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	@Query("Select a from admins a ORDER by a.admins_id DESC")
	List <Admin> adminList ();
}
