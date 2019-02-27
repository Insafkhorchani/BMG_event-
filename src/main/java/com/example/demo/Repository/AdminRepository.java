package com.example.demo.Repository;
import com.example.demo.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin ,Long> {
}