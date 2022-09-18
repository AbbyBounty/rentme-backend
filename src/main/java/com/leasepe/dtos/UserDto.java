package com.leasepe.dtos;

public class UserDto {

	Integer id;
	String name;
	String email;
	String pinCode;
	String phoneNo;
	String address;
	public UserDto() {
	
	}
	public UserDto(Integer id, String name,  String email, String pinCode, String phoneNo,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pinCode = pinCode;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPinCode() {
		return pinCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", pinCode=" + pinCode + ", phoneNo="
				+ phoneNo + ", address=" + address + "]";
	}
	
	
	
}