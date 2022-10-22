package pl.nw.hehexd.support;

import org.springframework.stereotype.Component;
import pl.nw.hehexd.Api.request.CustomerRequest;
import pl.nw.hehexd.Api.response.CustomerResponse;
import pl.nw.hehexd.domain.Customer;

@Component
public class CustomerMapper {

    public CustomerResponse toCustomerResponse(Customer customer){
        return new CustomerResponse(customer.getId(), customer.getUsername(), customer.getRole());
    }

    public Customer toCustomer(CustomerRequest customerRequest) {
        return new Customer(customerRequest.getUsername(), customerRequest.getRole());
    }
}