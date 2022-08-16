package br.com.dh.meli.projeto_integrador.model;

import br.com.dh.meli.projeto_integrador.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_item")
@JsonIgnoreProperties({"customer", "items"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime orderDate;

    @Column
    private Status status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
