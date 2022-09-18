package com.leasepe.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.leasepe.entities.Role;
import com.leasepe.entities.User;

public class UserDaoImpl implements Userdao{

	@Override
	public List<User> findAll() {

		return null;
	}

	@Override
	public List<User> findAll(Sort sort) {

		return null;
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {

		return null;
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {

		return null;
	}

	@Override
	public void flush() {

		
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {

		return null;
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {

		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {

		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {

		
	}

	@Override
	public void deleteAllInBatch() {

		
	}

	@Override
	public User getOne(Integer id) {

		return null;
	}

	@Override
	public User getById(Integer id) {

		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {

		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {

		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {

		return null;
	}

	@Override
	public <S extends User> S save(S entity) {

		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {

		return null;
	}

	@Override
	public boolean existsById(Integer id) {

		return false;
	}

	@Override
	public long count() {

		return 0;
	}

	@Override
	public void deleteById(Integer id) {

		
	}

	@Override
	public void delete(User entity) {

		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {

		
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {

		
	}

	@Override
	public void deleteAll() {

		
	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {

		return null;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {

		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {

		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {

		return false;
	}

	@Override
	public Optional<User> findByEmailAndPassword(String email, String pwd) {

		return null;
	}

	@Override
	public List<User> findByRole(Role role) {

		return null;
	}

	@Override
	public Optional<User> findByEmail(String email) {

		return null;
	}

	@Override
	public void deleteById(int id) {

		
	}

}
