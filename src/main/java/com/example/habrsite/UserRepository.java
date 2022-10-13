package com.example.habrsite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

/*    User findById(long id);
    List<User> findAll();
    void deleteById(long id);*/
}
