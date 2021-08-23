package com.example.demo.RestCallYBL;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
XEBIA:YBL
@author ABHAY MISHRA
*/

public class CaVerifyRequest {
	
	@JsonProperty("CAAccountCheckReq")
	CaAccountChkRequest CAAccountCheckReq;

	public CaAccountChkRequest getCAAccountCheckReq() {
		return CAAccountCheckReq;
	}

	public void setCAAccountCheckReq(CaAccountChkRequest cAAccountCheckReq) {
		this.CAAccountCheckReq = cAAccountCheckReq;
	}
	
	

}
