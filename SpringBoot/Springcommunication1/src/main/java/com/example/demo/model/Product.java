package com.example.demo.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
 
@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private String subscription;
	private int price;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	 
	 
}