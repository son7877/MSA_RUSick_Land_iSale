package com.example.iSale.global.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ISALE")
public class ISale {
    @Id @GeneratedValue
    @Column(name = "ISALE_ID") // 분양 id
    private UUID iSaleId;

    @Column(name = "ISALE_IN") // 입주 가능일
    private String iSaleIn;

    @Column(name = "ISALE_SELL_PRICE") // 분양가
    private Long iSaleSellPrice;

    @Column(name = "ISALE_CATEGORY")
    private Integer iSaleCategory;

    @Column(name = "ISALE_NAME")
    private String iSaleName;

    @Column(name = "ISALE_AREA")
    private String iSaleArea;

    @Column(name = "ISALE_ADDRESS")
    private String iSaleAddress;

}
