package br.com.dh.meli.projeto_integrador.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person {
    @OneToOne
    @JoinColumn(name = "shoppingcart_id", nullable = true)
    private ShoppingCart shoppingCart;
}
