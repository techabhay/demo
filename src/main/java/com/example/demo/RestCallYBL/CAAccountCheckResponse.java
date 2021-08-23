package com.example.demo.RestCallYBL;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
XEBIA:YBL
@author ABHAY MISHRA
*/

public class CAAccountCheckResponse {	

	@JsonProperty("ResponseCode")
	String ResponseCode;
	
	@JsonProperty("ResponseDescription")
	String ResponseDescription;
	
	@JsonProperty("CustomerId")
	String CustomerId;
	
	@JsonProperty("AccountType")
	String AccountType;
	
	@JsonProperty("AccountDetails")
	List<AccountDetailsResponse> AccountDetails;
	
	
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		this.ResponseCode = responseCode;
	}
	public String getResponseDescription() {
		return ResponseDescription;
	}
	public void setResponseDescription(String responseDescription) {
		this.ResponseDescription = responseDescription;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		this.CustomerId = customerId;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		this.AccountType = accountType;
	}
	public List<AccountDetailsResponse> getAccountDetails() {
		return AccountDetails;
	}
	public void setAccountDetails(List<AccountDetailsResponse> accountDetails) {
		this.AccountDetails = accountDetails;
	}
	@Override
	public String toString() {
		return "CaVerifyResponse [ResponseCode=" + ResponseCode + ", ResponseDescription=" + ResponseDescription
				+ ", CustomerId=" + CustomerId + ", AccountType=" + AccountType + ", AccountDetails=" + AccountDetails
				+ "]";
	}
	
	
}
