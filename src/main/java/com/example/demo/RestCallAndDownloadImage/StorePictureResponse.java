package com.example.demo.RestCallAndDownloadImage;

/**
 *@Nielsen
 *@author Abhay Mishra
 */

public class StorePictureResponse {

	String accountName;
	String sessionToken;
	String validityStartTimestamp;
	String validityEndTimestamp;
	
	
	 public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getSessionToken() {
		return sessionToken;
	}


	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}


	public String getValidityStartTimestamp() {
		return validityStartTimestamp;
	}


	public void setValidityStartTimestamp(String validityStartTimestamp) {
		this.validityStartTimestamp = validityStartTimestamp;
	}


	public String getValidityEndTimestamp() {
		return validityEndTimestamp;
	}


	public void setValidityEndTimestamp(String validityEndTimestamp) {
		this.validityEndTimestamp = validityEndTimestamp;
	}

	public String toString() {
		return this.getAccountName() + "\n" + this.getSessionToken() + "\n" + 
				this.getValidityStartTimestamp() + "\n" + this.getValidityEndTimestamp();
	}
}



