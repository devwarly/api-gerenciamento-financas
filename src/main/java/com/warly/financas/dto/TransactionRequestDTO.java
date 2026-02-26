package com.warly.financas.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDTO {

    private Long id;
    private BigDecimal value;
    private String currency;
    private BigDecimal conversionRate;
    private BigDecimal convertedValue;
    private LocalDateTime createdAt;

}
