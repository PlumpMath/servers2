package org.jqgrid.domain;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;

@Entity(name = "servers")
//@Entity(name = "server_view")
public class servers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ServerID; // changed from Int type

	//private String ServerID;
	//private String ServerName;

	@Column(unique = true)
	//private String ServerID;
	private String ServerName;

//	@OneToOne(mappedBy = "user", cascade = { CascadeType.ALL })
//	private Role role;

	public servers() {
	}

	public servers(String ServerID, String ServerName) {
		this.ServerID = ServerID; // may need to convert from int to string
		this.ServerName = ServerName;
	}

	public String getServerId() {
		return ServerID;  // may need to confert from int to string
	}


	public String getServerName() {
		return ServerName;
	}

	public void setServerId(String id) {
		this.ServerID = id.toString();
	}

	//public String getLastName() {
	//	return lastName;
	//}

	public void setServerName(String serverName) {
		this.ServerName = serverName;
	}

	//public String getUsername() {
	//	return username;
	//}

	//public void setUsername(String username) {
	//	this.username = username;
	//}

	//public String getPassword() {
	//	return password;
	//}

	//public void setPassword(String password) {
	//	this.password = password;
	//}

	//public String getEmail() {
	//	return email;
	//}

	//public void setEmail(String email) {
	//	this.email = email;
	//}

	//public String getPhone() {
	//	return phone;
	//}

	//public void setPhone(String phone) {
	//	this.phone = phone;
	//}

	//public Role getRole() {
	//	return role;
	//}

	//public void setRole(Role role) {
	//	this.role = role;
	//}
}
