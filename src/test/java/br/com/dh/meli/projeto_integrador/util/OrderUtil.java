package br.com.dh.meli.projeto_integrador.util;

import br.com.dh.meli.projeto_integrador.dto.ItemDTO;
import br.com.dh.meli.projeto_integrador.model.Item;
import br.com.dh.meli.projeto_integrador.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    public static Order orderGenerator() {
        Order order = new Order();
        order.setId(ShoppingCartUtil.shoppingCartGenerator().getId());
        order.setCustomer(CustomerUtil.customerGenerator());
        List<Item> items = new ArrayList();
        items.add(ItemUtil.completeItem());
        order.setItems(items);
        return order;
    }

    public static List<Order> ordersGenerator() {
        List<Order> orders = new ArrayList<>();
        orders.add(orderGenerator());
        return orders;
    }

    public static ItemDTO itemPriceGenerator() {
        ItemDTO item = ItemUtil.emptyItemDTO();
        item.setUnitPrice(1D);
        item.setPrice(2D);
        return item;
    }
}
