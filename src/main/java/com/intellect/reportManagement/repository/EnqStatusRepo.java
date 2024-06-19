package com.intellect.reportManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intellect.reportManagement.entity.EnqStatusEntity;

@Repository
public interface EnqStatusRepo extends JpaRepository<EnqStatusEntity, Integer> {

}
