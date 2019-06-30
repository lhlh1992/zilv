package com.liu.mvc.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.mvc.pojo.Perm;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IPermService;
import com.liu.mvc.service.IUserService;

@Controller
@CrossOrigin
@RequestMapping(value="/perm")
public class PermController {
			@Autowired	
			private IPermService permService;
	
			@RequestMapping(value="/getPermList")
			@ResponseBody
			public List<Perm> getPermList(@RequestBody Map<String,Object> map){				
				String pname = map.get("pname").toString();		
				List<Perm> permList = permService.getPermList(pname);			
				return permList;
			}
			
		
}
