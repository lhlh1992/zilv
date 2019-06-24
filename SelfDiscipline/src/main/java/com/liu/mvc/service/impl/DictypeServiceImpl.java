package com.liu.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.mvc.dao.dictype.DictypeMapper;

import com.liu.mvc.pojo.DicType;
import com.liu.mvc.service.IDictypeService;




@Service
public class DictypeServiceImpl   implements IDictypeService {
	
	  @Resource
	  private DictypeMapper dictype;

	@Override
	public List<DicType> selectDictype(String name, String code) {
		
		return dictype.selectDictype(name, code);
	}
   
	@Override
	public int insertDictype(DicType dtype) {	
		return dictype.insertDictype(dtype);
	}

	@Override
	public int updateDictype(DicType dic) {
		// TODO Auto-generated method stub
		return dictype.updateDictype(dic);
	}

	@Override
	public int deleteDictype(String dic_type_code) {
		// TODO Auto-generated method stub
		return dictype.deleteDictype(dic_type_code);
	}
	
}
