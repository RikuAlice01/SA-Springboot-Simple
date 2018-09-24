package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}