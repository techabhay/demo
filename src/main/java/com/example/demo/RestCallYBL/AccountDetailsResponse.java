package com.example.demo.RestCallYBL;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
XEBIA:YBL
@author ABHAY MISHRA
*/

public class AccountDetailsResponse {
	
	@JsonProperty("AccountNumber")
	String AccountNumber;
	
	@JsonProperty("AccountStatus")
	Integer AccountStatus;
	
	
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.AccountNumber = accountNumber;
	}
	public Integer getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(Integer accountStatus) {
		this.AccountStatus = accountStatus;
	}
	
	
}
