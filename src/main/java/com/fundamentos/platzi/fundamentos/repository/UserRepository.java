package com.fundamentos.platzi.fundamentos.repository;

import com.fundamentos.platzi.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    /*@Query("Select u from User u WHERE u.email.=?1")
    Optional<User> findByUserEmail(String email);
    */

}
