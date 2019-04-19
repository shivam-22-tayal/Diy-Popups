package com.ibm.diypopups.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class creditcounter {
	@Id
	@GeneratedValue 
	private int sln;
	
	public int getSln() {
		return sln;
	}
	public void setSln(int sln) {
		this.sln = sln;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	private int eid;
	private int vid;
	

}
