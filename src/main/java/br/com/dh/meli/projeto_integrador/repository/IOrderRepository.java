package br.com.dh.meli.projeto_integrador.repository;

import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByCustomer(Customer customer);
}
