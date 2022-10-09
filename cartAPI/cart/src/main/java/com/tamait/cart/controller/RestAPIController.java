package com.tamait.cart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamait.cart.dto.OrderDTO;
import com.tamait.cart.models.Customer;
import com.tamait.cart.models.Order;
import com.tamait.cart.models.Product;
import com.tamait.cart.models.ShopCart;
import com.tamait.cart.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestAPIController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IProductService productService;

    @Autowired
    IOrderDtoService orderDtoService;

    @Autowired
    IOrderService orderService;

    @Autowired
    ICartService cartService;

    @GetMapping("/listCustomer")
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listProduct")
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listOrder")
    public ResponseEntity<Iterable<Order>> findAllOrder() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listOrderDTO")
    public ResponseEntity<Iterable<OrderDTO>> findAllOrderDTO() {
        return new ResponseEntity<>(orderDtoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listOrder/{id}")
    public ResponseEntity<Optional<Order>> findAllOrderDTO(@PathVariable Integer id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/customerOrder/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = customerService.findById(id);
        return customer.map(x -> new ResponseEntity<>(x, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/getCustomer")
    public ResponseEntity<Order> login(@RequestBody Customer customer) {
        Optional<Order> order = orderService.findByLast();
        return order.map(x -> new ResponseEntity<>(x, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveOrder")
    public HttpStatus saveOrder(@RequestBody Map<String, Object> data, ObjectMapper objectMapper) throws JsonProcessingException {


//        List<ShopCart> s = new ArrayList<>();
//
//        List<Product> map = (List) data.get("data");


        Object dataObj = data.get("data");
        String json = objectMapper.writeValueAsString(dataObj);
        List<ShopCart> products = getDataAsList(json, ShopCart.class);
        cartService.save(products);
        return HttpStatus.OK;
    }

    public <T> List<T> getDataAsList(String content, Class clazz) {
        List<T> listValue = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            listValue = mapper.readValue(content,
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listValue;
    }
}
