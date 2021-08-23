package com.example.demo.RestCallYBL;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
XEBIA:YBL
@author ABHAY MISHRA
*/

public class CaVerifyResponse {

	@JsonProperty("CAAccountCheckRes")
	CAAccountCheckResponse CAAccountCheckRes;

	public CAAccountCheckResponse getCAAccountCheckRes() {
		return CAAccountCheckRes;
	}

	public void setCAAccountCheckRes(CAAccountCheckResponse cAAccountCheckRes) {
		CAAccountCheckRes = cAAccountCheckRes;
	}

	@Override
	public String toString() {
		return "CaVerifyResponse [CAAccountCheckRes=" + CAAccountCheckRes + "]";
	}	
	
}
