package com.liu.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.mvc.pojo.DicItem;
import com.liu.mvc.pojo.DicType;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IDicitemService;
import com.liu.mvc.service.IDictypeService;

@Controller
@CrossOrigin
@RequestMapping(value="/dic")
public class DicController {
            
	@Autowired
	private IDictypeService dictypeService;
	
	@Autowired
	private IDicitemService dicitemService;
	
	
	
	
    @RequiresRoles("admin")
    @RequiresPermissions("字典管理")
    @RequestMapping(value="/dictypeList")
    @ResponseBody        
       public  List<DicType> dictypeList() {
    	
	       
     	List<DicType> list =   dictypeService.selectDictype("", "");
     	return list;
       }
    
    @RequestMapping(value="/dicitemList")
    @ResponseBody        
       public  List<DicItem> dicitemList(@RequestBody  Map<String,Object> map) {	  
    	System.out.println("///////////////////////////");
 	    String code ="";
 	   if( map.get("code")!=null) {
 		  code =  map.get("code").toString();
 	   }
 	 
 	    List<DicItem> list = new ArrayList<>();	    
 	    list =   dicitemService.selectDicitem(code);
     	 return list;
       }
    
    @RequestMapping(value="/insertDictype")
    @ResponseBody        
       public  int insertDictype(@RequestBody DicType dic) {	  
     	 return  dictypeService.insertDictype(dic);
       }
    
    @RequestMapping(value="/updateDictype")
    @ResponseBody        
       public  int updateDictype(@RequestBody DicType dic) {	  
     	 return  dictypeService.updateDictype(dic);
       }
    
    
    @RequestMapping(value="/deleteDictype")
    @ResponseBody    
    @Transactional
       public  int deleteDictype(@RequestBody  Map<String,Object> map) {	  
 	    String id = map.get("id").toString();
 	    dicitemService.deleteDicitemAll(id);
     	 return  dictypeService.deleteDictype(id);
       }
    
    
    
    @RequestMapping(value="/insertDicItem")
    @ResponseBody        
       public  int insertDicItem(@RequestBody DicItem dic) {	 
    	System.out.println();
     	 return  dicitemService.insertDicItem(dic);
       }
    
    @RequestMapping(value="/updateDicitem")
    @ResponseBody        
       public  int updateDicitem(@RequestBody DicItem dic) {	  
     	 return  dicitemService.updateDicitem(dic);
       }
    
    
    @RequestMapping(value="/deleteDicitem")
    @ResponseBody        
       public  int deleteDicitem(@RequestBody  Map<String,Object> map) {	    
 	    String id = map.get("id").toString();
     	return  dicitemService.deleteDicitem(id);
       }
}
