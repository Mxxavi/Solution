package com.mx.gritsolutions.repositories;

import com.mx.gritsolutions.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByMail(String mail);
}
