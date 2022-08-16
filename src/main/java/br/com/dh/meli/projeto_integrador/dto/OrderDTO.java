package br.com.dh.meli.projeto_integrador.dto;

import br.com.dh.meli.projeto_integrador.enums.Status;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private Status status;
    private Long customerId;
    private Double totalPrice;
    private List<ItemDTO> items;
}
