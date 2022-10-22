package pl.nw.hehexd.service;

import lombok.RequiredArgsConstructor;
import pl.nw.hehexd.Api.request.AbstractRequest;
import pl.nw.hehexd.Api.response.AbstractResponse;
import pl.nw.hehexd.domain.AbstractEntity;
import pl.nw.hehexd.repository.AbstractRepository;
import pl.nw.hehexd.support.AbstractMapper;
import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.stream.Collectors;

@MappedSuperclass
@RequiredArgsConstructor
public abstract class AbstractService{

    private final AbstractMapper abstractMapper;
    private final AbstractRepository abstractRepository;
    public AbstractResponse saveCustomer(AbstractRequest abstractRequest) {
        AbstractEntity abstractEntity =  abstractMapper.toAbstractEntity(abstractRequest);
        abstractRepository.save(abstractEntity);
        return abstractMapper.toAbstractResponse(abstractEntity);
    }

    public List<AbstractResponse> findAll() {
        List<AbstractEntity> abstractList = abstractRepository.findAll();
        return abstractList.stream().map(abstractMapper::toAbstractResponse).collect(Collectors.toList());
    }
}