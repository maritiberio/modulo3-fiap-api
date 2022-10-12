package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.controller.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Long> arrayAssists) throws Exception;
    List<Order> listOrderByOperator(Long operatorId);

}
