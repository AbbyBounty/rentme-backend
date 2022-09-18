package com.leasepe.services;

import java.util.List;

import com.leasepe.entities.User;
public interface UserService  {
	User validateUser(String email,String password );
	List<User> getUserList();
	List<User> SellersList();
	User updateAccount(int acctId,User user);
	User updateUserProfile(int acctId,User user);
    User getUser(int id);
	User findByEmail(String email);
	boolean deleteById(int id);
	User RegisterAccount(User user);
	User SignupCustomerAccount(User user);
	
}