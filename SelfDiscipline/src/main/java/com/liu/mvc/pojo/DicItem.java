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
	private int dicTypeId;		// 字典类型
	private String createTime;		// 创建时间
	
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

	public int getDicTypeId() {
		return dicTypeId;
	}
	public void setDicTypeId(int dicTypeId) {
		this.dicTypeId = dicTypeId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	

	

	

}
