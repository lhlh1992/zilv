package com.liu.mvc.service;

import java.util.List;

import com.liu.mvc.pojo.DicItem;
import com.liu.mvc.pojo.DicType;
import com.liu.mvc.pojo.Role;



public interface IDicitemService {

	public  List<DicItem> selectDicitem(String code);
	
	public int insertDicItem(DicItem dicitem);
	
	
	public int updateDicitem(DicItem dicitem);
	
	public int deleteDicitem(String dic_type_code);
	
	public int deleteDicitemAll(String code);
}
