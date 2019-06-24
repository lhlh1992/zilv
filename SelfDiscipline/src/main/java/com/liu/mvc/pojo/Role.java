package com.liu.mvc.pojo;

import java.util.List;

public class Role {
					
				private int id;
				
				private String  rolename;
				
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
