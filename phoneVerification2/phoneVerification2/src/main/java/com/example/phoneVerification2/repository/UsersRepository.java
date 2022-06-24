package com.example.phoneVerification2.repository;

import com.example.phoneVerification2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository <User, UUID> {
}
