/**
 * 
 */
package com.cjb.test.study.bean;

/**
 * 用户实体类
 * @author MyPC
 * 2019年4月21日 下午2:15:24
 */
public class User {
	
	private String id;
	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id
	 */
	public User(String id) {
		super();
		this.id = id;
		this.name=id;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
