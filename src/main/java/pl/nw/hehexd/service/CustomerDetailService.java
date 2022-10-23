package pl.nw.hehexd.service;

import org.springframework.stereotype.Service;
import pl.nw.hehexd.domain.CustomerDetail;
import pl.nw.hehexd.repository.CustomerDetailRepository;
import pl.nw.hehexd.support.CustomerDetailMapper;

@Service
public class CustomerDetailService extends AbstractService {


    public CustomerDetailService(CustomerDetailMapper abstractMapper, CustomerDetailRepository abstractRepository) {
        super(abstractMapper, abstractRepository);
    }

}
