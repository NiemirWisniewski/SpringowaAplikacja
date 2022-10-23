package pl.nw.hehexd.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nw.hehexd.Api.request.CustomerDetailRequest;
import pl.nw.hehexd.Api.response.CustomerDetailResponse;
import pl.nw.hehexd.service.CustomerDetailService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "CustomerDetail")
public class CustomerDetailController extends AbstractController<CustomerDetailResponse, CustomerDetailRequest, CustomerDetailService>{

    public CustomerDetailController(CustomerDetailService customerDetailService) {
        super(customerDetailService);
    }

    @GetMapping("/customerDetails")
    @ApiOperation("Show all")
    @Override
    public ResponseEntity<List<CustomerDetailResponse>> showAllAbstractEntities() {
        return super.showAllAbstractEntities();
    }

    @PostMapping("/customerDetails")
    @ApiOperation("Create customerdetail")
    @Override
    public ResponseEntity<CustomerDetailResponse> abstractCustomer(CustomerDetailRequest abstractRequest) {
        return super.abstractCustomer(abstractRequest);
    }
}
