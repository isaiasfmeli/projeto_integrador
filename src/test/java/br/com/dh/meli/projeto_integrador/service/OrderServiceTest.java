package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.OrderDTO;
import br.com.dh.meli.projeto_integrador.enums.Status;
import br.com.dh.meli.projeto_integrador.exception.NotFoundException;
import br.com.dh.meli.projeto_integrador.model.Customer;
import br.com.dh.meli.projeto_integrador.model.Item;
import br.com.dh.meli.projeto_integrador.model.Order;
import br.com.dh.meli.projeto_integrador.model.ShoppingCart;
import br.com.dh.meli.projeto_integrador.repository.IOrderRepository;
import br.com.dh.meli.projeto_integrador.util.CustomerUtil;
import br.com.dh.meli.projeto_integrador.util.OrderUtil;
import br.com.dh.meli.projeto_integrador.util.ShoppingCartUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderServiceTest {

    @InjectMocks
    private OrderService service;

    @Mock
    private IOrderRepository repo;

    @Mock
    private IItemService itemService;

    @BeforeEach
    public void setup() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Order.class)))
                .thenReturn(OrderUtil.orderGenerator());

        BDDMockito.when(repo.findOrdersByCustomer(ArgumentMatchers.any(Customer.class)))
                .thenReturn(OrderUtil.ordersGenerator());

        BDDMockito.when(itemService.convertToDTO(ArgumentMatchers.any(Item.class)))
                .thenReturn(OrderUtil.itemPriceGenerator());
    }

    @Test
    void createOrderByClosedCart_When_IsOpen() {
        ShoppingCart cart = ShoppingCartUtil.shoppingCartGenerator();
        cart.setStatus(Status.ABERTO);

        Optional<Order> order = service.createOrderByClosedCart(cart);

        assertThat(order.isEmpty()).isTrue();
    }

    @Test
    void createOrderByClosedCart_When_IsClosed() {
        ShoppingCart cart = ShoppingCartUtil.shoppingCartGenerator();
        cart.setStatus(Status.FECHADO);

        Optional<Order> order = service.createOrderByClosedCart(cart);

        assertThat(order.isPresent()).isTrue();
    }

    @Test
    void convertToDTO() {
        List<OrderDTO> dtos = service.convertToDTO(OrderUtil.ordersGenerator());

        assertThat(dtos.size()).isPositive();
    }

    @Test
    void listPurchaseHistory_When_HaveOrders() {
        List<Order> orders = service.listPurchaseHistory(CustomerUtil.customerGenerator());

        assertThat(orders.size()).isPositive();
    }

    @Test
    void listPurchaseHistory_When_NotHaveOrders() {
        BDDMockito.when(repo.findOrdersByCustomer(ArgumentMatchers.any(Customer.class)))
                .thenReturn(new ArrayList<>());

        NotFoundException exception = Assertions.assertThrows(
                NotFoundException.class, () -> service.listPurchaseHistory(CustomerUtil.customerGenerator()));

        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
