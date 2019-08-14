package com.liu.mvc.pojo;

import java.util.List;

public class Role {
					
				private int rid;
				
				private String  rolename;
				
				private String  roleCode;
				
				private String  description;
				
				private boolean  available;
				
				private List<Perm> perList;
				
				private List<User> UserList;

				private String  create_time;
				
				private String  create_user;
				
				private String  update_time;
				
				private String  update_user;

				
				
				
				
				public String getCreate_time() {
					return create_time;
				}

				public void setCreate_time(String create_time) {
					this.create_time = create_time;
				}

				public String getCreate_user() {
					return create_user;
				}

				public void setCreate_user(String create_user) {
					this.create_user = create_user;
				}

				public String getUpdate_time() {
					return update_time;
				}

				public void setUpdate_time(String update_time) {
					this.update_time = update_time;
				}

				public String getUpdate_user() {
					return update_user;
				}

				public void setUpdate_user(String update_user) {
					this.update_user = update_user;
				}

				public int getRid() {
					return rid;
				}

				public void setRid(int rid) {
					this.rid = rid;
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

				

				public boolean isAvailable() {
					return available;
				}

				public void setAvailable(boolean available) {
					this.available = available;
				}

				public List<Perm> getPerList() {
					return perList;
				}

				public void setPerList(List<Perm> perList) {
					this.perList = perList;
				}

				public List<User> getUserList() {
					return UserList;
				}

				public void setUserList(List<User> userList) {
					UserList = userList;
				}

				
				
			
				
				
				
				
			    
						
}
