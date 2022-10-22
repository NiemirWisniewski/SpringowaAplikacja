package pl.nw.hehexd.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nw.hehexd.Api.request.CustomerRequest;
import pl.nw.hehexd.Api.response.CustomerResponse;
import pl.nw.hehexd.service.CustomerService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "Customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    @ApiOperation("Show all")
    public ResponseEntity<List<CustomerResponse>> showAllCustomer(){
        List<CustomerResponse> customerResponseList = customerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseList);
    }

    @PostMapping("/customers")
    @ApiOperation("Create customer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.saveCustomer(customerRequest);
        URI uri = URI.create("/admin/" + customerResponse.getId());
        return ResponseEntity.created(uri).body(customerResponse);
    }
}