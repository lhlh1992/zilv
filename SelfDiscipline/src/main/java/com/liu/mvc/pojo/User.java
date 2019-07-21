package com.liu.mvc.pojo;

import java.util.List;

public class User {
					
				private String uid;
				
				private String  username;
				
				private String  password;
				
				private String  salt;
				
				private List<Role> roleList;
				
				private String is_Banning;
							
				private String roleStr; //拥有角色字符串，逗号分隔
				
			
				public String getIs_Banning() {
					return is_Banning;
				}

				public void setIs_Banning(String is_Banning) {
					this.is_Banning = is_Banning;
				}

				public String getRoleStr() {
					return roleStr;
				}

				public void setRoleStr(String roleStr) {
					this.roleStr = roleStr;
				}

				public String getUid() {
					return uid;
				}

				public void setUid(String uid) {
					this.uid = uid;
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
