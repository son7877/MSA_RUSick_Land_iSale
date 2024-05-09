package com.example.iSale.global.domain.repository;

import com.example.iSale.global.domain.entity.ISaleEnroll;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleEnrollRepository extends JpaRepository<ISaleEnroll, UUID> {
    List<ISaleEnroll> findByQualTFIsNull();
}
