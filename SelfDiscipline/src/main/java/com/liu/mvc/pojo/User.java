package com.liu.mvc.pojo;

import java.util.List;

public class User {
					
				private String id;
				
				private String  username;
				
				private String  password;
				
				private String  salt;
				
				private List<Role> roleList;
				
				
				

				public String getId() {
					return id;
				}

				public void setId(String id) {
					this.id = id;
				}

				public String getUsername() {
					return username;
				}

				public void setUsername(String username) {
					this.username = username;
				}

				public String getPassword() {
					return password;
				}

				public void setPassword(String password) {
					this.password = password;
				}

				public List<Role> getRoleList() {
					return roleList;
				}

				public void setRoleList(List<Role> roleList) {
					this.roleList = roleList;
				}
				
				
				
				
				 public String getSalt() {
					return salt;
				}

				public void setSalt(String salt) {
					this.salt = salt;
				}

				/**
			     * 密码盐.
			     * @return
			     */
			    public String getCredentialsSalt(){
			        return this.username+this.salt;
			    }
				
				
}
