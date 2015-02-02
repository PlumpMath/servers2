package org.jqgrid.controller;

import java.util.List;

import org.jqgrid.domain.servers;
import org.jqgrid.repository.ServersRepository;
import org.jqgrid.response.JqgridResponse;
import org.jqgrid.response.ServersDto;
import org.jqgrid.response.StatusResponse;
import org.jqgrid.service.ServerMonitorService;
import org.jqgrid.util.JqgridFilter;
import org.jqgrid.util.JqgridObjectMapper;
import org.jqgrid.util.ServersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inframonitor")
public class ServersController {

	@Autowired
	private ServersRepository repository;
	@Autowired 
	private ServerMonitorService service;
	
	@RequestMapping
	public String getserversPage() {
		return "servers";
	}
	
	@RequestMapping(value="/records", produces="application/json")
	public @ResponseBody JqgridResponse<ServersDto> records(
    		@RequestParam("_search") Boolean search,
    		@RequestParam(value="filters", required=false) String filters,
    		@RequestParam(value="page", required=false) Integer page,
    		@RequestParam(value="rows", required=false) Integer rows,
    		@RequestParam(value="sidx", required=false) String sidx,
    		@RequestParam(value="sord", required=false) String sord) {

		Pageable pageRequest = new PageRequest(page-1, rows);
		
		if (search == true) {
			return getFilteredRecords(filters, pageRequest);
		} 
			
		Page<servers> servers = repository.findAll(pageRequest);
		List<ServersDto> ServersDtos = ServersMapper.map(servers);
		
		JqgridResponse<ServersDto> response = new JqgridResponse<ServersDto>();
		response.setRows(ServersDtos);
		response.setRecords(Long.valueOf(servers.getTotalElements()).toString());
		response.setTotal(Integer.valueOf(servers.getTotalPages()).toString());
		response.setPage(Integer.valueOf(servers.getNumber()+1).toString());
		
		return response;
	}
	
	/**
	 * Helper method for returning filtered records
	 */
	public JqgridResponse<ServersDto> getFilteredRecords(String filters, Pageable pageRequest) {
		String qServerId = null;
		String qServerName = null;
		//String qLastName = null;
		//String qPhone = null;
		//String qEmail = null;
		//Integer qRole = null;
		
		JqgridFilter jqgridFilter = JqgridObjectMapper.map(filters);
		for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
			if (rule.getField().equals("serverId"))
				qServerId = rule.getData();
			else if (rule.getField().equals("serverName"))
				qServerName = rule.getData();
		//	else if (rule.getField().equals("lastName"))
		//		qLastName = rule.getData();
		//	else if (rule.getField().equals("phone"))
		//		qPhone = rule.getData();
		//	else if (rule.getField().equals("email"))
		//		qEmail = rule.getData();
		//	else if (rule.getField().equals("role"))
		//		qRole = Integer.valueOf(rule.getData());
		}
		
		Page<servers> servers = null;
		if (qServerId != null) 
			servers = repository.findByServerNameLike("%"+qServerName+"%", pageRequest);
		//if (qServerName != null && qLastName != null) 
		//	servers = repository.findByFirstNameLikeAndLastNameLike("%"+qFirstName+"%", "%"+qLastName+"%", pageRequest);
		//if (qFirstName != null) 
			//	users = repository.findByFirstNameLike("%"+qFirstName+"%", pageRequest);
		//if (qLastName != null) 
			//	users = repository.findByLastNameLike("%"+qLastName+"%", pageRequest);
		//if (qPhone != null) 
			//	users = repository.findByPhoneLike("%"+qPhone+"%", pageRequest);		
		//if (qEmail != null) 
			//	users = repository.findByEmailLike("%"+qEmail+"%", pageRequest);		
		//if (qRole != null) 
			//	users = repository.findByRole(qRole, pageRequest);
		
		List<ServersDto> ServerDtos = ServersMapper.map(servers);
		JqgridResponse<ServersDto> response = new JqgridResponse<ServersDto>();
		response.setRows(ServerDtos);
		response.setRecords(Long.valueOf(servers.getTotalElements()).toString());
		response.setTotal(Integer.valueOf(servers.getTotalPages()).toString());
		response.setPage(Integer.valueOf(servers.getNumber()+1).toString());
		return response;
	}
	
	@RequestMapping(value="/get", produces="application/json")
	public @ResponseBody ServersDto get(@RequestBody ServersDto InfraMonitor) {
		return ServersMapper.map(repository.findByServername(InfraMonitor.getServerName()));
	}

	@RequestMapping(value="/create", produces="application/json", method=RequestMethod.POST)
	public @ResponseBody StatusResponse create(
			@RequestParam String serverId,
			@RequestParam String serverName)
			//@RequestParam String firstName,
			//@RequestParam String lastName,
			//@RequestParam String phone,
			//@RequestParam String email,
			//@RequestParam Integer role)
			{
		
		servers newInfraMonitor = new servers(serverId, serverName);
		Boolean result = service.create(newInfraMonitor);
		//Boolean result = false;  //return false for just a view
		return new StatusResponse(result);
	}
	
	
	@RequestMapping(value="/update", produces="application/json", method=RequestMethod.POST)
	public @ResponseBody StatusResponse update(
			@RequestParam String serverId,
			@RequestParam String serverName){
			//@RequestParam String username,
			//@RequestParam String firstName,
			//@RequestParam String lastName,
			//@RequestParam String phone,			
			//@RequestParam String email,
			//@RequestParam Integer role) {
		
		servers existingServer = new servers(serverId, serverName);
		Boolean result = service.update(existingServer);
		//Boolean result = false;  //return false for just a view
		return new StatusResponse(result);
	}
	
	@RequestMapping(value="/delete", produces="application/json", method=RequestMethod.POST)
	public @ResponseBody StatusResponse delete(
			@RequestParam String serverId,
			@RequestParam String serverName){

		servers existingServer = new servers(serverId, serverName);
		Boolean result = service.delete(existingServer);
		//Boolean result = false;  //return false for just a view
		return new StatusResponse(result);
	}
	
}
