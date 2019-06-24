package com.liu.mvc.pojo;

import java.util.List;

/**
 * 权限实体类
 * @author Administrator
 *
 */
public class Permission {
				
	     private int id;
	     
	     private String PName;
	     
	     private List<Role> roleList;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPName() {
			return PName;
		}

		public void setPName(String pName) {
			PName = pName;
		}

		public List<Role> getRoleList() {
			return roleList;
		}

		public void setRoleList(List<Role> roleList) {
			this.roleList = roleList;
		}
	     
	     
	     
	     
}
