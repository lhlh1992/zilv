package com.liu.mvc.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.liu.mvc.dao.dicitem.DicitemMapper;
import com.liu.mvc.pojo.DicItem;
import com.liu.mvc.service.IDicitemService;



/**
 * liuhui
 * @author Administrator
 *
 */
@Service
public class DicitemServiceImpl   implements IDicitemService {
	
	  @Resource
	  private DicitemMapper dicitem;

	@Override
	public List<DicItem> selectDicitem(String code) {
		List<DicItem> dic =dicitem.selectDicitem(code);
		for(DicItem d:dic) {
				d.setSportsTime("0");
		}
		return dic;
	}

	@Override
	public int insertDicItem(DicItem dic) {
		// TODO Auto-generated method stub
		return dicitem.insertDicItem(dic);
	}

	@Override
	public int updateDicitem(DicItem dic) {
		// TODO Auto-generated method stub
		return dicitem.updateDicitem(dic);
	}

	@Override
	public int deleteDicitem(String dic_type_code) {
		// TODO Auto-generated method stub
		return dicitem.deleteDicitem(dic_type_code);
	}

	@Override
	public int deleteDicitemAll(String code) {
		// TODO Auto-generated method stub
		return dicitem.deleteDicitemAll(code);
	}

	
   
	
}
