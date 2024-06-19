package com.intellect.reportManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intellect.reportManagement.entity.CourseEntity;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}
