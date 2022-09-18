package com.leasepe.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.Role;
import com.leasepe.entities.User;

public interface Userdao extends JpaRepository<User, Integer>{
	Optional<User> findByEmailAndPassword(String email, String pwd);
	List<User> findByRole(Role role);
	Optional<User> findByEmail(String email);
	void deleteById(int id);
}
