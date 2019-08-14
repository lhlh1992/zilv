package com.liu.mvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.liu.mvc.dao.role.RoleMapper;
import com.liu.mvc.dao.user.UserMapper;
import com.liu.mvc.pojo.Perm;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IRoleService;
import com.liu.mvc.service.IUserService;

@Service
public class RoleServiceImpl implements IRoleService{
	
	@Resource
	public RoleMapper roleDao;

	@Override
	public List<Role> getRoleList(String u) {
		// TODO Auto-generated method stub
		return roleDao.getRoleList(u);
	}
	
	
	/**
	  *  获取路由，因数据库表改变，弃用
	 */
	@Override
	public List<Role> createRoute2(String uname) {
		// TODO Auto-generated method stub
		List<Role> rList = roleDao.createRoute(uname);
		List<Map<String,Object>> list = new ArrayList<>();//向前台传的List
		List<String> rolePerm= new ArrayList<>();//判断一级菜单的重复
		for(Role r:rList) {		
		  if(r!=null) {
			  Map<String,Object> level1=new HashMap();
				List<Perm> pList =r.getPerList();
				//循环权限菜单  
				for(Perm p:pList) {
					//这里进行判断，如果一级菜单没有产生过
					if(!(rolePerm.contains(p.getpCode()))) {
						level1.put("text", p.getPermissionName());	
						rolePerm.add(p.getpCode());	
						List<Map<String,String>> lm=new ArrayList<>();
						Map<String,String>  map = new HashMap<>();//children里的子菜单，map
						map.put("text",p.getRouteName());
		    			map.put("link",p.getFore_End()); 
		    			lm.add(map);
		    			level1.put("children", lm);
		    			
	  	        	}
					//这里进行判断，如果产生过这个一级菜单，就把这条路由，加到这个一级菜单下
					else {
	  	        		Map<String,Object> bigMap=new HashMap<>();
	  	        			for(Map<String,Object> l1:list) {
		  	        		 bigMap=l1;
		  	        		 //这里不用再对bigMap进行遍历！！！遍历了反而会乱，因为有多个key-value，这里直接指定key为text，就OK撩
		  	        		 if(bigMap.get("text").equals(p.getPermissionName())) {	
		  	        			boolean flag=true;
								List<Map<String,String>> lm=(List<Map<String, String>>) bigMap.get("children");
								//这个遍历lm的原因在于,如果出现了用户存在多个角色，而多个角色有重复的权限的情况，这里不会对重复的权限进行处理添加
								for(Map<String,String> childrenMap:lm) {
										if(childrenMap.get("text").equals(p.getRouteName())) {
											flag=false;
										}
								}
								if(flag) {
									Map<String,String>  map = new HashMap<>();//children里的子菜单，map
									map.put("text",p.getRouteName());
					    			map.put("link",p.getFore_End()); 
					    			lm.add(map);
								}	  	        				
		  	        		 }
	  	        		}	        		
	  	        	}  			
				}	
				//判断，如果不是空Map,就加到list里面，完活
				if(!level1.isEmpty()) {
					list.add(level1);
				}		 
		  }		
		}	
		
		Gson gson = new Gson();
	    String jsonStr = gson.toJson(list);
		return rList;
	}
	
	

	@Override
	public String createRoute(String uname) {
		// TODO Auto-generated method stub
		List<Role> rList = roleDao.createRoute(uname);
		List<Map<String,Object>> list = new ArrayList<>();//向前台传的List
		List<String> distinctText= new ArrayList<>();//判断一级菜单的重复
		for(Role r:rList) {		
		  if(r!=null) {	
			  List<Perm> pList =r.getPerList();
				//循环权限菜单  
				for(Perm p:pList) {
					Map<String,Object> level1=new LinkedHashMap(); //一级目录
					if(!(distinctText.contains(String.valueOf(p.getPeid())))) {
						if(p.getMenu_level().equals("1")) {
							level1.put("text", p.getPermissionName());	
							level1.put("id", p.getPeid());	
							level1.put("children", new ArrayList<>());	
							distinctText.add(String.valueOf(p.getPeid()));
						}	
					}
						
					if(!level1.isEmpty()) {
						list.add(level1);								
					}							
					if(!(p.getpCode().equals("0"))) {
						String pCode=p.getpCode();						
						for(Map<String,Object> ml:list) {
							String id=ml.get("id").toString();
							List<Map<String,String>> children = (List<Map<String, String>>) ml.get("children");//children List
							if(pCode.equals(id)) {
								boolean flag = true;
								for(Map<String,String> m:children) {
									if(m.get("text").equals(p.getPermissionName())) {
										flag = false;
									}								
								}
								if(flag){
									Map<String,String>  map = new LinkedHashMap<>();//children里的子菜单，map
									map.put("text",p.getPermissionName());
					    			map.put("link",p.getFore_End()); 
					    			children.add(map);	
					    			ml.put("children", children);
								}					
							}					
						}	

					}						
				}	
		  }		
		}	
		Gson gson = new Gson();
	    String jsonStr = gson.toJson(list);
		return jsonStr;
	}


	@Override
	public int addRole(Role role) {
		role.setAvailable(true);
		//shiro中获取登录名
		String userName=(String)SecurityUtils.getSubject().getPrincipal();	
		role.setCreate_user(userName);
		return roleDao.addRole(role);
	}


	@Override
	public int editRole(Role role) {
		System.out.println(role.isAvailable());
		//shiro中获取登录名
		String userName=(String)SecurityUtils.getSubject().getPrincipal();	
		role.setUpdate_user(userName);
		return  roleDao.editRole(role);
	}


	@Override
	public Role banRole(Role role) {
		Role rr = roleDao.getRole(role);
		
		if(rr.isAvailable()) {
			rr.setAvailable(false);
		}else{
			rr.setAvailable(true);
		}
		//shiro中获取登录名
		String userName=(String)SecurityUtils.getSubject().getPrincipal();	 
		rr.setUpdate_user(userName);
		int i= roleDao.editRole(rr);
		
		System.out.println(i);
		Role ro=new Role();
		if(i>0) {
			ro=roleDao.getRole(rr);
		}
		return ro;
	}


	@Override
	@Transactional(rollbackFor=Exception.class)
	public int deleteRole(String id) {
		int i=roleDao.deleteRole(Integer.valueOf(id));
		if(i>0) {
			roleDao.deleteRolePrem(id);
			roleDao.deleteUserRole(id);
		}
		return i;
	}




}
