package com.example.acount.RepositoryInter;

import com.example.acount.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInter extends JpaRepository<Users,Integer> {
        Users findById(String id);
        Users findByUsername(String username);
}
