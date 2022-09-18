package com.leasepe.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seller_id")
	private int sellerId;
	
	 @Column(name="company_name",length=20)
     private String companyName;
     
	 @Column(name="company_email",length=50)
	 private String companyEmail;
	 
	 @Column(name="password",length=150)
	 private String password;
	 
	 @Column(name="company_phone" , length=14)
	 private String companyPhone;
	 
	 @Column(name="company_address" , length = 300)
	 private String CompanyAddress;
	 
	 @Column(name="gstin" , length=15)
	 private String gstin;
	 
	 @Column(name="role" , length=20)
	 private String role;
	 
	 @Column(name="revenue" , length=20)
	 private double revenue;
	 
	 @OneToMany(mappedBy = "seller" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<Product> productList;

		{this.productList = new ArrayList<Product>();}
	 
	 public Seller() {

	 }




	public Seller(int sellerId, String companyName, String companyEmail, String password, String companyPhone,
			String companyAddress, String gstin, String role, double revenue, List<Product> productList) {
		super();
		this.sellerId = sellerId;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.password = password;
		this.companyPhone = companyPhone;
		CompanyAddress = companyAddress;
		this.gstin = gstin;
		this.role = role;
		this.revenue = revenue;
		this.productList = productList;
	}




	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyAddress() {
		return CompanyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.CompanyAddress = companyAddress;
	}

	public String getGSTIN() {
		return gstin;
	}

	public void setGSTIN(String gSTIN) {
		this.gstin = gSTIN;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}




	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", companyName=" + companyName + ", companyEmail=" + companyEmail
				+ ", password=" + password + ", companyPhone=" + companyPhone + ", CompanyAddress=" + CompanyAddress
				+ ", gstin=" + gstin + "]";
	}


 
          
}
