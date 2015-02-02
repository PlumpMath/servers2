package org.jqgrid.util;

import java.util.ArrayList;
import java.util.List;

import org.jqgrid.domain.servers;
import org.jqgrid.response.ServersDto;
import org.springframework.data.domain.Page;
// change to server values
public class ServersMapper {

	public static ServersDto map(servers server_view) {
		ServersDto dto = new ServersDto();
			//dto.setId(server_view.getServerId());
			//dto.setFirstName(server_view.getServerName());
			//dto.setLastName(user.getLastName());
			//dto.setUsername(user.getUsername());
			//dto.setPhone(user.getPhone());
			//dto.setEmail(user.getEmail());
			//dto.setRole(user.getRole().getRole());
			return dto;
	}
	
	public static List<ServersDto> map(Page<servers> server_views) {
		List<ServersDto> dtos = new ArrayList<ServersDto>();
		for (servers server_view: server_views) {
			dtos.add(map(server_view));
		}
		return dtos;
	}
}
