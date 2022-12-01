package Library.System.Customers.service;




import Library.System.Customers.domain.Customer;
import Library.System.Customers.kafka.Sender;
import Library.System.Customers.repo.CustomerRepo;
import Library.System.Customers.service.dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    Sender sender;


    @Override
    public void add(CustomerDto customerDto) {
        Customer customer= CustomerAdapter.getCustomerFromCustomerDto(customerDto) ;
        customerRepo.save(customer);
    }

    @Override
    public void deleteById(long customerNumber) {
        Customer customer = customerRepo.findById(customerNumber).get();
      customerRepo.delete(customer);
    }

    @Override
    public void updateById(long customerNumber, CustomerDto customerDto) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customerNumber);
        if (optionalCustomer.isPresent()){
            Customer customer= CustomerAdapter.getCustomerFromCustomerDto(customerDto) ;
            customerRepo.save(customer);
            sender.send("customer_topic", customerDto);
        }
    }

    @Override
    public CustomerDto getCustomerById(long customerNumber) {

        Customer optionalCustomer=customerRepo.findById(customerNumber).get();
        if (optionalCustomer == null){
            System.out.println("Customer not found!");
        }

        return CustomerAdapter.getCustomerDtoFromCustomer(optionalCustomer);
    }
//    @Override
//    public void updateCustomer(long customerNumber, CustomerDTO customerDTO) {
//        Customer customer = customerRepository.findById(customerNumber);
//        customer.setCustomerNumber(customerNumber);
//        customer.setName(customerDTO.getName());
//        customer.setContact(customerDTO.getContact());
//        customer.setAddress(customerDTO.getAddress());
//        sender.send("customer_topic", customerDTO);
//
//        customerRepository.save(customer);
//    }

    @Override
    public Collection<CustomerDto> getCustomers() {
        List<Customer>customers=customerRepo.findAll();
        return CustomerAdapter.getCustomerDtoListFromCustomerList(customers);
    }
}
