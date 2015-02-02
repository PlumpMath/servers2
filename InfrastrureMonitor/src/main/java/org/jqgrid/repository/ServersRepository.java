package org.jqgrid.repository;

import org.jqgrid.domain.servers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServersRepository extends JpaRepository<servers, Long> {
	
	servers findByServername(String username);
	
	Page<servers> findByServerIDLike(String serverid, Pageable pageable);
	Page<servers> findByServerNameLike(String servername, Pageable pageable);
	//Page<User> findByLastNameLike(String lastName, Pageable pageable);
	//Page<User> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable);
	//Page<User> findByPhoneLike(String phone, Pageable pageable);
	//Page<User> findByEmailLike(String email, Pageable pageable);
	
	//@Query("select * from server_view")
	//Page<InfraMonitor> findByID(@Param("serverid") Integer role, Pageable pageable);

}
