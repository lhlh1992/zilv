package com.liu.mvc.service;

import java.util.List;

import com.liu.mvc.pojo.DicType;
import com.liu.mvc.pojo.Role;



public interface IDictypeService {

	public  List<DicType> selectDictype(String name,String code);
	
	
	public int insertDictype(DicType dictype);
	
	
	public int updateDictype(DicType dictype);
	
	public int deleteDictype(String dic_type_code);
}
