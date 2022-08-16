package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.OrderDTO;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.model.Order;
import br.com.dh.meli.projeto_integrador.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderDTO> convertToDTO(List<Order> orders);
    Optional<Order> createOrderByClosedCart(ShoppingCart cart);
    List<Order> listPurchaseHistory(Customer customer);
}
