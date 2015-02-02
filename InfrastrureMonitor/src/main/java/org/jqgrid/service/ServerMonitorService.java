package org.jqgrid.service;

import org.jqgrid.domain.servers;
import org.jqgrid.repository.ServersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ServerMonitorService {

	@Autowired
	private ServersRepository repository;

	// create new record ?
	public Boolean create(servers server ) {
		//InfraMonitor.getServerName().setServerName(InfraMonitor);
		servers saved = repository.save(server);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean update(servers servername) {
		servers existingServer = repository.findByServername(servername.getServerName());
		if (existingServer == null) 
			return false;
		
		// Only firstName, lastName, email and role fields are updatable
//		existingUser.setFirstName(user.getFirstName());
//		existingUser.setLastName(user.getLastName());
//		existingUser.setEmail(user.getEmail());
//		existingUser.setPhone(user.getPhone());
//		existingUser.getRole().setRole(user.getRole().getRole());
		
		servers saved = repository.save(existingServer);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean delete(servers servername) {
		servers existingServer = repository.findByServername(servername.getServerName());
		if (existingServer == null) 
			return false;
		
		repository.delete(existingServer);
		servers deletedUser = repository.findByServername(servername.getServerName());
		if (deletedUser != null) 
			return false;
		
		return true;
	}
}