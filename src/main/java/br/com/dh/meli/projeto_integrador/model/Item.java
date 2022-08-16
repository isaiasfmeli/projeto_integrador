package br.com.dh.meli.projeto_integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id", nullable = true)
    private Advertisement advertisement;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "batchstock_id", nullable = true)
    private BatchStock batchStock;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="shopping_cart_id", nullable = false)
    @JsonIgnoreProperties("items")
    private ShoppingCart shoppingCart;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = true)
    @JsonIgnoreProperties("order")
    private Order order;

    public boolean isBatchStockIsEmpty(){
        return Optional.ofNullable(this.batchStock).isEmpty();
    }
}
