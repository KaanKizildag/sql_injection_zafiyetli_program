package sqli_zafiyet.service;

import sqli_zafiyet.entity.Customer;
import sqli_zafiyet.repository.CustomerDao;

public class CustomerService {
    private CustomerDao customerDao;

    public void insert(Customer customer){
        customerDao.insertUser(customer);
    }

    public Customer getByCustomerName(String customerName){
        return customerDao.getByCustomerName(customerName);
    }
}
