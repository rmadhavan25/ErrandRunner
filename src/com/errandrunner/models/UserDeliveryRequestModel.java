package com.errandrunner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="user_delivery_request")
@NamedQueries({@NamedQuery(name="get_user_deliveries", query="from UserDeliveryRequestModel where phone= :phno"),
				@NamedQuery(name="get_all_deliveries",query="from UserDeliveryRequestModel"),
				@NamedQuery(name="get_user_deliveries_byid", query="from UserDeliveryRequestModel where deliveryid= :id")})
@org.hibernate.annotations.NamedNativeQuery(name = "get_user_deliveries_by_erunnerid", query = "select * from user_delivery_request where erunnerid=:id",resultClass = UserDeliveryRequestModel.class)
public class UserDeliveryRequestModel implements Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="deliveryid")
	private int deliveryid;
	
	@Column(name="pickupAddress")
	private String pickupAddress;
	
	@Column(name="dropAddress")
	private String dropAddress;
	
	@Column(name="items")
	private String items;
	
	@Column(name="description")
	private String description;
	
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
	
	

	public UserDeliveryRequestModel() {
		super();
	}

	public UserDeliveryRequestModel(String pickupAddress, String dropAddress, String items, String description,
			String phone, short status, UserModel user) {
		super();
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.items = items;
		this.description = description;
		this.phone = phone;
		this.status = status;
		this.userid = user;
	}

	public UserDeliveryRequestModel(String pickupAddress, String dropAddress, String items, String description,
			String phone, UserModel user) {
		super();
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.items = items;
		this.description = description;
		this.phone = phone;
		this.userid = user;
	}

	public UserDeliveryRequestModel(int deliveryid, String pickupAddress, String dropAddress, String items,
			String description, String phone, short status, UserModel user,ErunnerModel erunner) {
		super();
		this.deliveryid = deliveryid;
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.items = items;
		this.description = description;
		this.phone = phone;
		this.status = status;
		this.userid = user;
		this.erunnerid = erunner;
	}

	public int getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(int deliveryid) {
		this.deliveryid = deliveryid;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public UserModel getUser() {
		return userid;
	}

	public void setUser(UserModel user) {
		this.userid = user;
	}
	
	public ErunnerModel getErunner() {
		return erunnerid;
	}
	
	public void setErunner(ErunnerModel erunner) {
		this.erunnerid = erunner;
	}
	
	
	

}
