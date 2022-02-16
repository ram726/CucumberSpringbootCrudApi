package com.example.BddSpringboot.cucumber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByPhone(Long phoneNumber);

    void deleteByPhone(Long phone);
}
