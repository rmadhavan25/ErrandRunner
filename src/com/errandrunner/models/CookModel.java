package com.errandrunner.models;

import com.mysql.cj.jdbc.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cook")
public class CookModel {
	@Id
	@GeneratedValue
	 @Column(name="id")
	private int id;
	 
	@Column(name="address")
	private String address;
	
	 @Column(name="addressProof")
	private Blob addressProof;
	 
	 @Column(name="verified")
	private Short verified;
	 
	 @Column(name="userid")
	private int userid;
	
	protected CookModel() {
	}
	public CookModel(int id, String address, Blob addressProof, Short verified, int userid) {
		super();
		this.id = id;
		this.address = address;
		this.addressProof = addressProof;
		this.verified = verified;
		this.userid = userid;
	}
	
	public CookModel(String address, Blob addressProof, Short verified, int userid) {
		super();
		this.address = address;
		this.addressProof = addressProof;
		this.verified = verified;
		this.userid = userid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Blob getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(Blob addressProof) {
		this.addressProof = addressProof;
	}
	public Short getVerified() {
		return verified;
	}
	public void setVerified(Short verified) {
		this.verified = verified;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
