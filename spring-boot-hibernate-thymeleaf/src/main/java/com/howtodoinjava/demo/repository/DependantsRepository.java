package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.DependantsEntity;
 
@Repository
public interface DependantsRepository
        extends JpaRepository<DependantsEntity, Long> {
 
}
