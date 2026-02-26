package com.warly.financas.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal originalValue;

    private String currency;

    private BigDecimal convertedValue;

    private BigDecimal conversionRate;

    private LocalDateTime createdAt = LocalDateTime.now();
}