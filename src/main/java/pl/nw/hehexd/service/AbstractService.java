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
public abstract class AbstractService<E extends AbstractResponse, T extends AbstractRequest, O extends AbstractEntity>{

    private final AbstractMapper abstractMapper;
    private final AbstractRepository<O> abstractRepository;
    public E saveCustomer(T abstractRequest) {
        O abstractEntity = (O) abstractMapper.toAbstractEntity(abstractRequest);
        abstractRepository.save(abstractEntity);
        return (E) abstractMapper.toAbstractResponse(abstractEntity);
    }

    public List<AbstractResponse> findAll() {
        List<O> abstractList = abstractRepository.findAll();
        return abstractList.stream().map(x -> abstractMapper.toAbstractResponse(x)).collect(Collectors.toList());
    }
}