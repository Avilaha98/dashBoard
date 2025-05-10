package com.avi.dashBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avi.dashBoard.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
