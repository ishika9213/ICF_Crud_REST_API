package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.EducationalQualificationsEntity;
 
@Repository
public interface EducationalQualificationsRepository
        extends JpaRepository<EducationalQualificationsEntity, Long> {
 
}
