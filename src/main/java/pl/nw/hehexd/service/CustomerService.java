package pl.nw.hehexd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.hehexd.Api.request.CustomerRequest;
import pl.nw.hehexd.Api.response.CustomerResponse;
import pl.nw.hehexd.domain.Customer;
import pl.nw.hehexd.repository.CustomerRepository;
import pl.nw.hehexd.support.CustomerMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService{

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        Customer customer =  customerMapper.toCustomer(customerRequest);
        customerRepository.save(customer);
        return customerMapper.toCustomerResponse(customer);
    }

    public List<CustomerResponse> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream().map(customerMapper::toCustomerResponse).collect(Collectors.toList());
    }
}
