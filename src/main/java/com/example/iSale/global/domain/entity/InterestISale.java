package com.example.iSale.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "INTEREST_ISALE")
@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterestISale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTEREST_ISALE_ID")
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "ISALE_ID", nullable = false)
    private ISale isale;
}
