package pl.nw.hehexd.support;

import org.springframework.stereotype.Component;
import pl.nw.hehexd.Api.request.CustomerDetailRequest;
import pl.nw.hehexd.Api.response.CustomerDetailResponse;
import pl.nw.hehexd.domain.CustomerDetail;

@Component
public class CustomerDetailMapper extends AbstractMapper<CustomerDetail, CustomerDetailRequest, CustomerDetailResponse>{


    @Override
    public CustomerDetailResponse toAbstractResponse(CustomerDetail customerDetail) {
        return new CustomerDetailResponse(customerDetail.getName(), customerDetail.getSurname()
                , customerDetail.getAddress(), customerDetail.getEmail());
    }

    @Override
    public CustomerDetail toAbstractEntity(CustomerDetailRequest cDRequest) {
        return new CustomerDetail(cDRequest.getName(), cDRequest.getSurname(), cDRequest.getAddress(), cDRequest.getEmail());
    }
}
