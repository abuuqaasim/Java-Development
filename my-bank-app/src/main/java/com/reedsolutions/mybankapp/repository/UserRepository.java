package com.reedsolutions.mybankapp.repository;

import com.reedsolutions.mybankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);
}
