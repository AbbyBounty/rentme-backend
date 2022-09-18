package com.leasepe.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leasepe.custom_exception.AccountHandlingException;
import com.leasepe.daos.SellerDao;
import com.leasepe.entities.Seller;


@Service
@Transactional
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	private SellerDao sellerDao;
	

	
	
	@Override
	public Optional<Seller> fetchSellerDetails(Integer sellerId) {
		Optional<Seller> seller = sellerDao.findById(sellerId);
		System.out.println("seller :"+seller);
		return seller;
	}

	@Override
	public Seller SignupSellerAccount(Seller seller) {
		Seller seller2 = sellerDao.save(seller);
		return seller2;
	}

	@Override
	public List<Seller> fetchDetailsSellerList() {
		List<Seller> sellerList = sellerDao.findAll();
		return sellerList;
	}

	
	@Override
	public Optional<Seller> validateSeller(String companyEmail, String password) {
		Optional<Seller> seller = sellerDao.findByCompanyEmailAndPassword(companyEmail, password);
		return seller;
	}

	@Override
	public Seller updateSellerProfile(int sellerId, Seller seller) {
		Seller seller1 = sellerDao.findById(sellerId).orElse(null);
		System.out.println("1st seller"+seller1);
		seller1.setCompanyName(seller.getCompanyName());
		seller1.setCompanyPhone(seller.getCompanyPhone());
		seller1.setGSTIN(seller.getGSTIN());
		seller1.setCompanyAddress(seller.getCompanyAddress());
		System.out.println(seller1);
		return sellerDao.save(seller1);
	}

	@Override
	public Seller findBySellerId(int sellerId) {
		return sellerDao.findById(sellerId).orElse(null);
	}

	@Override
	public Seller save(Seller seller2) {
		return sellerDao.save(seller2);
	}

	@Override
	public Seller updateSellerAccount(int sellerId, Seller seller) {
		 Seller seller1 = sellerDao.findById(sellerId).orElseThrow(()->new AccountHandlingException("Password Updatation failed !!!: invalid seller id"));
		 
		   seller1.setPassword(seller.getPassword());
		return null;
	}
}

