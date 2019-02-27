package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    public User findByEmailAndPassword(String email,String password);
    public User findByEmail(String email);
    public User findByTel(Long Tel);
}
