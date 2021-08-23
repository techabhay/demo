package com.example.demo.RestCallYBL;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
XEBIA:YBL
@author ABHAY MISHRA
*/

public class CaAccountChkRequest {

	@JsonProperty("ReqRefNum")
	String ReqRefNum;
	
	@JsonProperty("CustomerId")
	String CustomerId;
	
	
	public String getReqRefNum() {
		return ReqRefNum;
	}
	public void setReqRefNum(String reqRefNum) {
		this.ReqRefNum = reqRefNum;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		this.CustomerId = customerId;
	}
	
	

}
