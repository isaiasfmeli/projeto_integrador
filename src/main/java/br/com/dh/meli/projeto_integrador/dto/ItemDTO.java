package br.com.dh.meli.projeto_integrador.dto;

import br.com.dh.meli.projeto_integrador.model.Advertisement;
import br.com.dh.meli.projeto_integrador.model.BatchStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long advertisementId;
    private Integer batchNumber;
    private Integer quantity;
    private Double unitPrice;
    private Double price;
}
