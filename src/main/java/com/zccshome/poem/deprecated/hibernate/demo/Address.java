package com.zccshome.poem.deprecated.hibernate.demo;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String postcode;
	private String addrinfo;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddrinfo() {
		return addrinfo;
	}

	public void setAddrinfo(String addrinfo) {
		this.addrinfo = addrinfo;
	}

}
