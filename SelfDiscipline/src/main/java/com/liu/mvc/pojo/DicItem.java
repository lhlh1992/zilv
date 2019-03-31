/**
 * 
 */
package com.liu.mvc.pojo;

/**
 * @author qlibm
 *
 */
public class DicItem {
	
	private int id;				// ID
	private String dicItemCode;		// 编码
	private String dicItemName;		// 字典名称
	private String dicTypeId;		// 字典类型
	private String createTime;		// 创建时间
	private String sportsTime;		// 单项运动时间
	
	
	
	
	public String getSportsTime() {
		return sportsTime;
	}
	public void setSportsTime(String sportsTime) {
		this.sportsTime = sportsTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDicItemCode() {
		return dicItemCode;
	}
	public void setDicItemCode(String dicItemCode) {
		this.dicItemCode = dicItemCode;
	}
	public String getDicItemName() {
		return dicItemName;
	}
	public void setDicItemName(String dicItemName) {
		this.dicItemName = dicItemName;
	}

	
	public String getDicTypeId() {
		return dicTypeId;
	}
	public void setDicTypeId(String dicTypeId) {
		this.dicTypeId = dicTypeId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	

	

	

}
