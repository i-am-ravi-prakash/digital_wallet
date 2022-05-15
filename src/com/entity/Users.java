/**
 * 
 */
package com.digitalwallet.entity;

import java.util.UUID;

/**
 * @author ravi.prakash1
 *
 */
public class Users {
	private String userName;
	private String userId;
	
	public Users(String _userName) {
		this.userName = _userName;
		this.userId = UUID.randomUUID().toString();
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String _userName) {
		this.userName = _userName;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String _userId) {
		this.userId = _userId;
	}
}