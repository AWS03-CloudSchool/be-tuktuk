package com.example.tuktuk.users.repository;

import com.example.tuktuk.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
