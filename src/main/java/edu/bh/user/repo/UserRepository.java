package edu.bh.user.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import edu.bh.user.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{

	public User findByUserId(String userId);
	public Optional<User> findById(Long id);
}
