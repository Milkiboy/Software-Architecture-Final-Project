package Library.System.Customers.service;





import Library.System.Customers.domain.Customer;
import Library.System.Customers.service.dtos.CustomerDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDto(CustomerDto customerDto){
//        Address address = getAddressFromAddressDto(customerDto.getAddressDto());
//        Contact contact = getContactFromContactDto(customerDto.getContactDto());
        return new Customer(customerDto.getCustomerNumber(),
                customerDto.getName(), customerDto.getAddress(), customerDto.getContact());
    }
    public static CustomerDto getCustomerDtoFromCustomer(Customer customer){
//        AddressDto addressDto = getAddressDtoFromAddress(customer.getAddress());
//        ContactDto contactDto = getContactDtoFromContact(customer.getContact());
        return  new CustomerDto(customer.getCustomerNumber(),
                customer.getName(), customer.getAddress(),customer.getContact());
    }
//    public static AddressDto getAddressDtoFromAddress(Address address){
//        return new AddressDto( address.getStreet(), address.getCity(), address.getZip());
//    }
//    public static ContactDto getContactDtoFromContact(Contact contact){
//        return new ContactDto(contact.getPhone(), contact.getEmail());
//    }
//    public static Address getAddressFromAddressDto(AddressDto addressDto){
//        return new Address( addressDto.getStreet(), addressDto.getCity(), addressDto.getZip());
//    }
//    public static Contact getContactFromContactDto(ContactDto contactDto){
//        return new Contact(contactDto.getPhone(), contactDto.getEmail());
//    }
    public static Collection<CustomerDto> getCustomerDtoListFromCustomerList(List<Customer> customers){
        List <CustomerDto> customerDtos=new ArrayList<>();
        for (Customer customer:customers){
            customerDtos.add(getCustomerDtoFromCustomer(customer));

        }
        return customerDtos;
    }
}
