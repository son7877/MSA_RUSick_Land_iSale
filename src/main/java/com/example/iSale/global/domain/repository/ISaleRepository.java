package com.example.iSale.global.domain.repository;

import com.example.iSale.global.domain.entity.ISale;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<ISale, UUID> {

}
