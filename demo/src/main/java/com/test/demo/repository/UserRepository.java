package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
