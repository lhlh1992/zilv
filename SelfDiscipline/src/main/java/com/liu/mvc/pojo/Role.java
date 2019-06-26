package com.liu.mvc.pojo;

import java.util.List;

public class Role {
					
				private int id;
				
				private String  rolename;
				
				private String  roleCode;
				
				private String  description;
				
				private String  available;
				
				private List<Permission> perList;
				
				private List<User> UserList;

				public int getId() {
					return id;
				}

				public void setId(int id) {
					this.id = id;
				}

				public String getRolename() {
					return rolename;
				}

				public void setRolename(String rolename) {
					this.rolename = rolename;
				}

				public String getRoleCode() {
					return roleCode;
				}

				public void setRoleCode(String roleCode) {
					this.roleCode = roleCode;
				}

				public String getDescription() {
					return description;
				}

				public void setDescription(String description) {
					this.description = description;
				}

				public String getAvailable() {
					return available;
				}

				public void setAvailable(String available) {
					this.available = available;
				}

				public List<Permission> getPerList() {
					return perList;
				}

				public void setPerList(List<Permission> perList) {
					this.perList = perList;
				}

				public List<User> getUserList() {
					return UserList;
				}

				public void setUserList(List<User> userList) {
					UserList = userList;
				}

				
				
			
				
				
				
				
			    
						
}
