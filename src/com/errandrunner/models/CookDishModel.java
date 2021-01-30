package com.errandrunner.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQuery;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name="cookdish")
@NamedQuery(name = "get_user_food", query = "from CookDishModel where userPhone= :phno")
public class CookDishModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private float price;
	
	@Column(name="date")
	private String date;
	
	
	@Column(name="breakfast")
	private boolean breakfast;
	
	@Column(name="lunch")
	private boolean lunch;
	
	@Column(name="dinner")
	private boolean dinner;
	
	@Column(name="status")
	private short status;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userAddress")
	private String userAddress;
	
	@Column(name="userPhone")
	private String userPhone;
	
	@OneToOne
	@JoinColumn(name="cookid") 
	private CookModel cook;
	
	


	
	public CookDishModel() {
		super();
	}

	public CookDishModel(String name, float price, String date, boolean breakfast, boolean lunch,
			boolean dinner,short status, CookModel cook) {
		super();
		this.name = name;
		this.price = price;
		this.date = date;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.status = status;
		this.cook = cook;
	}

	public CookDishModel(int id, String name, float price, String date, boolean breakfast, boolean lunch,
			boolean dinner,short status, CookModel cook,String userName,String userAddress,String userPhone) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.status = status;
		this.cook = cook;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public CookModel getCook() {
		return cook;
	}


	public void setCook(CookModel cook) {
		this.cook = cook;
	}

	public void setBreakfast(boolean bf) {
		this.breakfast = bf;
	}
	
	public boolean getBreakfast() {
		return this.breakfast;
	}
	
	public void setDinner(boolean dn) {
		this.dinner = dn;
	}
	
	public boolean getDinner() {
		return this.dinner;
	}
	
	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}
	
	public boolean getLunch() {
		return this.lunch;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setStatus(short status) {
		this.status = status;
	}
	
	public short getStatus() {
		return this.status;
	}

	public void setUserName(String name)
	{
		this.userName = name;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserAddress(String add)
	{
		this.userAddress = add;
	}
	
	public String getUserAddress() {
		return this.userAddress;
	}
	 
	public void setUserPhone(String ph)
	{
		this.userPhone = ph;
	}
	
	public String getUserPhone() {
		return this.userPhone;
	}
}
