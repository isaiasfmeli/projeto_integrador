package br.com.dh.meli.projeto_integrador.controller;

import br.com.dh.meli.projeto_integrador.dto.OrderDTO;
import br.com.dh.meli.projeto_integrador.model.Order;
import br.com.dh.meli.projeto_integrador.service.ICustomerService;
import br.com.dh.meli.projeto_integrador.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *  Customer endpoints
 *
 */
@RestController
@RequestMapping("/api/v1/fresh-products/customer")
public class CustomerController {

    @Autowired
    ICustomerService service;

    @Autowired
    IOrderService orderService;

    /**
     * List all purchase history of a valid customerId
     *
     * @param customerId
     * @return ResponseEntity<List<OrderDTO>>
     * @author Isaias Finger
     */
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<OrderDTO>> listPurchaseHistory(
            @PathVariable @Valid @NotNull Long customerId) {
        List<Order> orders = orderService.listPurchaseHistory(service.getCustomerById(customerId));
        return ResponseEntity.status(HttpStatus.OK).body(orderService.convertToDTO(orders));
    }
}
