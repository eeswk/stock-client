package com.mechanitis.demo.stockclient;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
    private String symbol;
    private Double price;
    private LocalDateTime time;
}
