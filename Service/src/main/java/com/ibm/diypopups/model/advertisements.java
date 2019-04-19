package com.ibm.diypopups.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity


public class advertisements
{

	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	
	//@Column(name="id")
	private int id;
	
	
	//@Column(name="categoryadd")
	private String categoryadd;
	
	//@Column(name="product")
	private String product;
	
	//@Column(name="dop")
	private String dop;
	
	//@Column(name="description")
	private String description;
	
	private int clicks;
	private int eid;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryadd() {
		return categoryadd;
	}

	public void setCategoryadd(String categoryadd) {
		this.categoryadd = categoryadd;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	
	public String getDop() {
		return dop;
	}

	public void setDop(String dop) {
		this.dop = dop;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	
}
