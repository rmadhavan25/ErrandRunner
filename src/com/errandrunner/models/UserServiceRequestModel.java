package com.errandrunner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="user_service_request")
@NamedQueries({@NamedQuery(name="get_user_services", query="from UserServiceRequestModel where phone= :phno"),@NamedQuery(name="get_user_services_byid", query="from UserServiceRequestModel where serviceid= :id")})
@org.hibernate.annotations.NamedNativeQuery(name = "get_user_services_by_erunnerid", query = "select * from user_service_request where erunnerid=:id",resultClass = UserServiceRequestModel.class)

public class UserServiceRequestModel implements Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="serviceid")
	private int serviceid;
	
	@Column(name="jobType")
	private String jobType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="status")
	private short status;
	@OneToOne
	@JoinColumn(name="userid")
	private UserModel userid;
	
	@OneToOne
	@JoinColumn(name="erunnerid")
	private ErunnerModel erunnerid;
	
	public UserServiceRequestModel() {
		super();
	}
	
	public UserServiceRequestModel(int serviceid, String jobType, String description, String address,String phone, short status,
			UserModel userid,ErunnerModel erunnerid) {
		super();
		this.serviceid = serviceid;
		this.jobType = jobType;
		this.description = description;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.userid = userid;
		this.erunnerid = erunnerid;
	}
	
	public UserServiceRequestModel(String jobType, String description, String address,String phone, short status, UserModel userid) {
		super();
		this.jobType = jobType;
		this.description = description;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.userid = userid;
	}
	
	public UserServiceRequestModel(String jobType, String description, String address, String phone,
			UserModel userid) {
		super();
		this.jobType = jobType;
		this.description = description;
		this.address = address;
		this.phone = phone;
		this.userid = userid;
	}

	public int getOrderid() {
		return serviceid;
	}
	public void setOrderid(int orderid) {
		this.serviceid = orderid;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public UserModel getUserid() {
		return userid;
	}
	public void setUserid(UserModel userid) {
		this.userid = userid;
	}
	
	public ErunnerModel getErunner() {
		return erunnerid;
	}
	
	public void setErunner(ErunnerModel erunner) {
		this.erunnerid = erunner;
	}
}


