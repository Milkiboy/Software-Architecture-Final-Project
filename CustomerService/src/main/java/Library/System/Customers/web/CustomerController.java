package Library.System.Customers.web;



import Library.System.Customers.service.CustomerService;
import Library.System.Customers.service.dtos.CustomerDto;
import Library.System.Customers.service.dtos.CustomersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto){
        customerService.add(customerDto);
        return  new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerNumber){
        customerService.deleteById(customerNumber);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{customerNumber}")
    public ResponseEntity<?> updateCustomer(@PathVariable long customerNumber,@RequestBody CustomerDto customerDto){
        customerService.updateById(customerNumber,customerDto);
        return  new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable long customerNumber){
       CustomerDto customerDto= customerService.getCustomerById(customerNumber);
        return  new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        Collection<CustomerDto> customerDtos=customerService.getCustomers();
        CustomersDto customersDto=new CustomersDto(customerDtos);
        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }

}
