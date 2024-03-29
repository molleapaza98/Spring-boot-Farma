package com.farma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farma.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	public Users findByUsername(String username);
}
