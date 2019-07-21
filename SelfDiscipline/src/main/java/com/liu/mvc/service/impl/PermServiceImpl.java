package com.liu.mvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.liu.mvc.dao.perm.PermMapper;
import com.liu.mvc.dao.role.RoleMapper;
import com.liu.mvc.dao.user.UserMapper;
import com.liu.mvc.pojo.Perm;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IPermService;
import com.liu.mvc.service.IUserService;

@Service
public class PermServiceImpl implements IPermService{
	
	@Resource
	public PermMapper permDao;
	@Resource
	public UserMapper userDao;
	@Resource
	public RoleMapper roleDao;


	@Override
	public List<Perm> getPermList(String u,String id) {
		// TODO Auto-generated method stub
		return permDao.getPermList(u,id);
	}

	@Override
	public  String getUserMenu(String uname) {     
		List<Perm> pList = new ArrayList<>();
		
		List<Map<String,Object>> list = new ArrayList<>();//向前台传的List
			
        List<User> userInfoList = userDao.getUserList(String.valueOf(uname));
        User userInfo=userInfoList.get(0);
        List<Role> roleList = userInfo.getRoleList();
        System.out.println("该用户有"+roleList.size()+"个角色");
         
        List<Integer> rolePerm= new ArrayList<>();
        int count=0;//角色处理计数器，处理完一个角色，+1,用于处理:完成一个角色的权限统计后，执行下一个代码流程的判断
        Map<String,String> menu = new HashMap<>();
        for(Role role:roleList){                	
        	boolean flag = true;
	        List<Role> r = roleDao.getRoleList(role.getRolename());
	        Role ro = r.get(0);
	        //如果角色有权限，则进行权限的获取
	        if (ro.getPerList().get(0).getPermissionName()!=null && ro.getPerList().get(0).getPermissionName()!="") {	
	        	  //首先把一级菜单加入map，当做去重处理，结构：一个一级菜单，下面包含很多子菜单，避免生成多个重复的一级菜单
	        	  for(Perm p:ro.getPerList()){   
	  	        	pList =  permDao.getPermList("", String.valueOf(p.getpCode()));   
	  	        	if(rolePerm.contains(p.getPeid())) {
	  	        		flag = false;    		
	      				continue;
	  	        	}  
	  	        	rolePerm.add(p.getPeid());	             	  		        		  
	  	      		menu.put(pList.get(0).getRouteName(), String.valueOf(pList.get(0).getPeid()));	      		
	  	        }  	
	        	  //根据一级菜单遍历，组成路由
	  	          if (flag)	  	 
	  	    	  for(Map.Entry<String,String> entry:menu.entrySet()) {	
	  	    		  //每一个一级路由
	  	    		  Map<String,Object> menuMap = new HashMap<>();//路由children节点的字菜单
	  	    		  menuMap.put("text", entry.getKey());
	  	    		 //子菜单list
	  	              List<Map<String,Object>> menulist = new ArrayList<>();
	  	              
	  	              //如果向前台的list里已经有数据了，说明已经加入了一个角色的路由
	  	              if(count>0) {
	  	         
	  	            	//for(Map<String,Object> ml:list){
	  	            	System.out.println(list.size());
	  	            	for(int i =0;i<list.size();i++) {
	  	            		Map<String,Object> ml=list.get(i);
	  	    				String text = ml.get("text").toString();
	  	    			  	if(entry.getKey().equals(text)) {
	  	    			  			menulist = (List<Map<String, Object>>) ml.get("children");
	  	    			  			for(Perm p:ro.getPerList()){           	 
	  	    			  			List<Perm> peList =  permDao.getPermList("", String.valueOf(p.getPeid()));   	
		  	 	  	          		int pid=Integer.valueOf(entry.getValue());
	  	 	  	        		    if(pid == Integer.parseInt(peList.get(0).getpCode())) {
	  	 	  	        			  Map<String,Object>  map = new HashMap<>();//children里的子菜单，map
	  	 	  	        			  map.put("text", peList.get(0).getRouteName());
	  	 	  	        			  map.put("link", peList.get(0).getUrl()); 
	  	 	  	            		  menulist.add(map);
	  	 	  	        		    }    		 
	  	 	  	                     }    
	  	    			  		   menuMap.put("children", menulist);     			  		   
	  	    			  	}else {
		  	    			  	for(Perm p:ro.getPerList()){           	 
	  	    			  			List<Perm> peList =  permDao.getPermList("", String.valueOf(p.getPeid()));   	
		  	 	  	          		int pid=Integer.valueOf(entry.getValue());
	  	 	  	        		    if(pid == Integer.parseInt(peList.get(0).getpCode())) {
	  	 	  	        			  Map<String,Object>  map = new HashMap<>();//children里的子菜单，map
	  	 	  	        			  map.put("text", peList.get(0).getRouteName());
	  	 	  	        			  map.put("link", peList.get(0).getUrl()); 
	  	 	  	            		  menulist.add(map);
	  	 	  	        		    }    		 
	  	 	  	                 }    
	  	    			  		   menuMap.put("children", menulist);  
	  	    			  		   //list.add(menuMap); 
	  	    			  	}	
	  	    			
	  	    		  } 
	  	              }else {
	  	            	int pid=Integer.valueOf(entry.getValue());  	             
		  	              for(Perm p:ro.getPerList()){           	 
		  	          		  pList =  permDao.getPermList("", String.valueOf(p.getPeid()));   		
		  	        		  if(pid == Integer.parseInt(pList.get(0).getpCode())) {
		  	        			  Map<String,Object>  map = new HashMap<>();//children里的子菜单，map
		  	        			  map.put("text", pList.get(0).getRouteName());
		  	        			  map.put("link", pList.get(0).getUrl()); 
		  	            		  menulist.add(map);
		  	        		  }    		 
		  	              }            
		  	              menuMap.put("children", menulist);    	              
		  	    		  list.add(menuMap);     		  	    		 
	  	              }     	                 
	  	    	  }
	  	          count++;
	        }  	      
	    }               
        Gson gson = new Gson();
        String jsonStr = gson.toJson(list);
        System.out.println(jsonStr);
        return jsonStr;
	}
	
	
	
	public   Map<String,Object> secondLevel(Map<String,String> menu,Role ro){
		 for(Map.Entry<String,String> entry:menu.entrySet()) {	
	    		  //每一个一级路由
	    		  Map<String,Object> menuMap = new HashMap<>();//路由children节点的字菜单
	              menuMap.put("text", entry.getKey());
	              int pid=Integer.valueOf(entry.getValue());
	              //子菜单list
	              List<Map<String,Object>> menulist = new ArrayList<>();
	              for(Perm p:ro.getPerList()){           	 
	            	  List<Perm>  pList =  permDao.getPermList("", String.valueOf(p.getPeid()));   		
	        		  if(pid == Integer.parseInt(pList.get(0).getpCode())) {
	        			  Map<String,Object>  map = new HashMap<>();//children里的子菜单，map
	        			  map.put("text", pList.get(0).getRouteName());
	        			  map.put("link", pList.get(0).getUrl()); 
	            		  menulist.add(map);
	        		  }    		 
	              }            
	              menuMap.put("children", menulist);    	              
	    		          
	    	  }
		return null;
		
	}

	

}
