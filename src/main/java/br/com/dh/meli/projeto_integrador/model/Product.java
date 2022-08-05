package br.com.dh.meli.projeto_integrador.model;

import br.com.dh.meli.projeto_integrador.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productId;
    private Integer batchNumber;
    private Float currentTemperature;
    private Float minimumTemperature;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDate manufaturingDate;
    private LocalDateTime manufaturingTime;
    private LocalDate dueDate;
    private Category category;
}
