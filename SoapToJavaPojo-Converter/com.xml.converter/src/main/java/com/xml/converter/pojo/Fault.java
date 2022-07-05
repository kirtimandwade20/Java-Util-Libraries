package com.xml.converter.pojo;

public class Fault {

	private String faultcode;
	private String faultstring;
	private Detail detail;
	private String status;

	
	public Fault() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fault(String status) {
		super();
		this.status = status;
	}

	public String getFaultcode() {
		return faultcode;
	}

	public void setFaultcode(String faultcode) {
		this.faultcode = faultcode;
	}

	public String getFaultstring() {
		return faultstring;
	}

	public void setFaultstring(String faultstring) {
		this.faultstring = faultstring;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Fault [faultcode=" + faultcode + ", faultstring=" + faultstring + ", detail=" + detail + ", status="
				+ status + "]";
	}
	

}
