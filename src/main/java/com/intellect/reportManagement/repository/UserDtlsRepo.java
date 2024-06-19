package com.intellect.reportManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intellect.reportManagement.entity.UserDtlsEntity;

@Repository
public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer> {
	UserDtlsEntity findByUserEmail(String userEmail);
}
