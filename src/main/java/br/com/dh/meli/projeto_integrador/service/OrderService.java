package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.ItemDTO;
import br.com.dh.meli.projeto_integrador.dto.OrderDTO;
import br.com.dh.meli.projeto_integrador.enums.Status;
import br.com.dh.meli.projeto_integrador.exception.NotFoundException;
import br.com.dh.meli.projeto_integrador.mapper.IOrderMapper;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.model.Order;
import br.com.dh.meli.projeto_integrador.model.ShoppingCart;
import br.com.dh.meli.projeto_integrador.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderRepository repo;

    @Autowired
    IItemService itemService;

    public Optional<Order> createOrderByClosedCart(ShoppingCart cart) {
        if(cart.getStatus().equals(Status.FECHADO)) {
            return Optional.of(createOrder(cart));
        }
        return Optional.empty();
    }

    private Order createOrder(ShoppingCart cart) {
        Order order = convertCartToOrder(cart);
        cart.getItems().forEach(i -> i.setOrder(order));
        return repo.save(order);
    }

    private Order convertCartToOrder(ShoppingCart cart) {
        Order order = new Order();
        order.setId(cart.getId());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(cart.getStatus());
        order.setCustomer(cart.getCustomer());
        return order;
    }

    @Override
    public List<OrderDTO> convertToDTO(List<Order> orders) {
        List<OrderDTO> dtos = new ArrayList<>();
        orders.forEach(o -> {
            OrderDTO dto = IOrderMapper.MAPPER.mappingModelToDTO(o);
            dto.setCustomerId(o.getCustomer().getId());
            dtos.add(priceCalculator(o, dto));
        });
        return dtos;
    }

    private OrderDTO priceCalculator(Order order, OrderDTO dto) {
        List<ItemDTO> items = new ArrayList<>();
        AtomicReference<Double> totalPrice = new AtomicReference<>(0D);
        order.getItems().forEach(i -> {
            ItemDTO idto = itemService.convertToDTO(i);
            totalPrice.updateAndGet(v -> v + idto.getPrice());
            items.add(idto);
        });
        dto.setTotalPrice(totalPrice.get());
        dto.setItems(items);
        return dto;
    }

    public List<Order> listPurchaseHistory(Customer customer) {
        List<Order> orders = repo.findOrdersByCustomer(customer);
        if(orders.isEmpty()) {
            throw new NotFoundException("no results were found in the purchase history");
        }
        return orders;
    }

}
