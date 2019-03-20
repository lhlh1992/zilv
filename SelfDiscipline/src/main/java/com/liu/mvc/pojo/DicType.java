package com.liu.mvc.pojo;

public class DicType {
	private String id;		// 编码
	private String dic_type_code;		// 编码
	private String dic_type_name;		// 字典名称
	private String dic_type_state;		// 是否可操作
	private String create_time;		// 创建时间
	private String dictypecode;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDictypecode() {
		return dictypecode;
	}
	public void setDictypecode(String dictypecode) {
		this.dictypecode = dictypecode;
	}
	public String getDic_type_code() {
		return dic_type_code;
	}
	public void setDic_type_code(String dic_type_code) {
		this.dic_type_code = dic_type_code;
	}
	public String getDic_type_name() {
		return dic_type_name;
	}
	public void setDic_type_name(String dic_type_name) {
		this.dic_type_name = dic_type_name;
	}
	public String getDic_type_state() {
		return dic_type_state;
	}
	public void setDic_type_state(String dic_type_state) {
		this.dic_type_state = dic_type_state;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

}
