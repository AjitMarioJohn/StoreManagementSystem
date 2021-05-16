package com.sms.itemMgmt.infra.repositories;

import com.sms.itemMgmt.infra.entities.CategoryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryData, UUID>{
    Optional<CategoryData> findByName(String name);
}