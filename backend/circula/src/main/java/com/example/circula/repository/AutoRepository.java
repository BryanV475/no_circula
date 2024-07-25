package com.example.circula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.circula.entity.AutoEntity;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, String> {
}
