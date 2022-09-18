package com.leasepe.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leasepe.custom_exception.AccountHandlingException;
import com.leasepe.daos.Userdao;
import com.leasepe.entities.Cart;
import com.leasepe.entities.Role;
import com.leasepe.entities.User;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private Userdao userdao;
	
	@Override
	public User validateUser(String email,String password ) {
		Optional<User> user = userdao.findByEmailAndPassword(email, password);
		return user.get() ;
	}

	@Override
	public List<User> getUserList() {
		return userdao.findByRole(Role.CUSTOMER);
	}
	
	
	@Override
	public User getUser(int id) {
		return userdao.findById(id).get();
	}
	@Override
	public User findByEmail(String email) {
		 Optional<User> user = userdao.findByEmail(email);
	    return user.get();
	}
   @Override
public boolean deleteById(int id) {
	if(userdao.existsById(id)) {
		userdao.deleteById(id);
		return true;
	}
	return false;
}

@Override
public User updateAccount(int userId, User user) {
	  User user1 = userdao.findById(userId).orElseThrow(()->new AccountHandlingException("user Updates failed !!!: invalid user id"));
	   user1.setPassword(user.getPassword());
	  return user;
}

@Override
public User RegisterAccount(User user) {
	
	if(user.getEmail().length() <=0 || !user.getEmail().matches("^[a-zA-Z0-9._:$!%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]$"))
		return null;
	if(user.getPhoneNo().length() <=0 || !user.getPhoneNo().matches("^[0-9]{10}$"))
		return null;
	if(user.getPinCode().length() <=0 || !user.getPinCode().matches("^[1-9]{1}[0-9]{5}"))
		return null;
	if(user.getPassword().length() <=5 )
		return null;
	Cart cart = new Cart();
	cart.setUser(user);
	user.setCart(cart);	
	return userdao.save(user);
}

@Override
public List<User> SellersList() {
	return userdao.findByRole(Role.SELLER);
}

@Override
public User SignupCustomerAccount(User cust) {
	cust.setRole(Role.CUSTOMER);
	return userdao.save(cust);
}


@Override
public User updateUserProfile(int userId, User user) {
	User userDetails = userdao.findById(userId).get();

	if (user.getAddress().length() != 0)
		userDetails.setAddress(user.getAddress());
	if (user.getName().length() != 0)
		userDetails.setName(user.getName());
	if (user.getPhoneNo().length() != 0)
		userDetails.setPhoneNo(user.getPhoneNo());
	if (user.getPinCode().length() != 0)
		userDetails.setPinCode(user.getPinCode());

	
	return userdao.save(userDetails);
}



}

