package com.techinnovsn.backend.mobilite.repository;

import com.techinnovsn.backend.mobilite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    User findUserByUsername(String username);

    Optional<User> findByTelephone(String  telephone);
    boolean existsByTelephone(String telephone);

}
