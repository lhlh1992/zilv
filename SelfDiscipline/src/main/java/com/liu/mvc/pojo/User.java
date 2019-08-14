package com.liu.mvc.pojo;

import java.util.Date;
import java.util.List;

public class User {
					
				private String uid;
				
				private String  username;
				
				private String  password;
				
				private String  salt;
				
				private List<Role> roleList;
				
				private boolean Banning;
							
				private String roleStr; //拥有角色字符串，逗号分隔
				
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

				public boolean isBanning() {
					return Banning;
				}

				public void setBanning(boolean banning) {
					Banning = banning;
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
