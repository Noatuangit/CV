package service.impl.customer;

import models.person.Customer;
import reposition.IBaseRepository;
import reposition.impl.customer.CustomerRepository;
import service.IBaseService;
import utils.ValidData;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CustomerService implements IBaseService<Customer> {
    private final IBaseRepository<Customer> customerRepository = new CustomerRepository();

    @Override
    public Map<String, String> save(Customer customer) throws SQLException {
        Map<String, String> mapError = ValidData.validData(customer);
        if (mapError.isEmpty()) {
            customerRepository.save(customer);
        }
        return mapError;
    }

    @Override
    public Map<String, String> update(Customer customer, int id) throws SQLException {
        Map<String, String> mapError = ValidData.validData(customer);
        if (mapError.isEmpty()) {
            customerRepository.update(customer, id);
        }
        return mapError;
    }

    @Override
    public void removeById(int id) {
        customerRepository.removeById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public int countAmountFindAll() {
        return customerRepository.countAmountFindAll();
    }

    @Override
    public List<Customer> getList(int offset) {
        return customerRepository.getList(offset, CustomerRepository.list_customer_offset);
    }

    public List<Customer> getListHaveContract(int offset) {
        return customerRepository.getList(offset, CustomerRepository.list_customer_have_contract);
    }

    @Override
    public List<Customer> getList() {
        return customerRepository.getList();
    }
}
