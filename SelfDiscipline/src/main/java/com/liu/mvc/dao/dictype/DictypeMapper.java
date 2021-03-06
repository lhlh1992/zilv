/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liu.mvc.dao.dictype;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.liu.mvc.pojo.DicType;
import java.util.List;


/**
 * <p>
 * 角色�? Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
public interface DictypeMapper  {

    /**
     * 根据条件查询角色列表
    
     * @return
     * @date 2017�?2�?12�? 下午9:14:34
     */
    List<DicType> selectDictype(@Param("name") String name,@Param("code") String code);


    int insertDictype(DicType dictype);
   
	int updateDictype(DicType dictype);
	
	int deleteDictype(String dic_type_code);
}