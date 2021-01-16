package com.errandrunner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="erunner")
public class ErunnerModel {
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	@Column(name="aadhar")
	private long aadhar;
	@Column(name="available")
	private short available;
	@Column(name="jobs")
	private String jobs;
	@Column(name="userid")
	private int userid;
	
	public ErunnerModel(int id, long aadhar, short available, String jobs, int userid) {
		super();
		this.id = id;
		this.aadhar = aadhar;
		this.available = available;
		this.jobs = jobs;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public short getAvailable() {
		return available;
	}
	public void setAvailable(short available) {
		this.available = available;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
