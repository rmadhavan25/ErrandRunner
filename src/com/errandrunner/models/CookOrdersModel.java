package com.errandrunner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="cookorders")
@NamedNativeQueries({@NamedNativeQuery(name = "get_orders_from_cook", 
query = "select * from cookorders where cookid=:cookid",
resultClass = CookOrdersModel.class),
@NamedNativeQuery(name = "get_orders_from_user", 
query = "select * from cookorders where userid=:userid",
resultClass = CookOrdersModel.class)})

public class CookOrdersModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="dishid") 
	private CookDishModel dish;
	
	@OneToOne
	@JoinColumn(name="userid") 
	private UserModel user;
	
	@OneToOne
	@JoinColumn(name="cookid") 
	private CookModel cook;
	

	
	public CookOrdersModel(int id, CookDishModel dish, UserModel user, CookModel cook) {
		super();
		this.id = id;
		this.dish = dish;
		this.user = user;
		this.cook = cook;
	}

	public CookOrdersModel(CookDishModel dish, UserModel user, CookModel cook) {
		super();
		this.dish = dish;
		this.user = user;
		this.cook = cook;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CookDishModel getDish() {
		return dish;
	}

	public void setDish(CookDishModel dish) {
		this.dish = dish;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public CookModel getCook() {
		return cook;
	}

	public void setCook(CookModel cook) {
		this.cook = cook;
	}
	

}
