package com.liu.mvc.pojo;

import java.util.List;

/**
 * 权限实体类
 * @author Administrator
 *
 */
public class Perm {
				
	     private int peid;
	     
	     private String code;
	     
	     private String permissionName;
	     
	     private String url;
	     
	     private String type;
	     
	     private String pCode;
	     
	     private String available;
	     
	     private List<Role> roleList;

	     

		public int getPeid() {
			return peid;
		}

		public void setPeid(int peid) {
			this.peid = peid;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getPermissionName() {
			return permissionName;
		}

		public void setPermissionName(String permissionName) {
			this.permissionName = permissionName;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getpCode() {
			return pCode;
		}

		public void setpCode(String pCode) {
			this.pCode = pCode;
		}

		public String getAvailable() {
			return available;
		}

		public void setAvailable(String available) {
			this.available = available;
		}

		public List<Role> getRoleList() {
			return roleList;
		}

		public void setRoleList(List<Role> roleList) {
			this.roleList = roleList;
		}
	     
	     
	     
	     
	     

	     
	     
	     
	     
	     
}
