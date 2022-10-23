package pl.nw.hehexd.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.nw.hehexd.Api.request.AbstractRequest;
import pl.nw.hehexd.Api.request.CustomerDetailRequest;
import pl.nw.hehexd.Api.response.AbstractResponse;
import pl.nw.hehexd.domain.AbstractEntity;
import pl.nw.hehexd.domain.CustomerDetail;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMapper<T extends AbstractEntity, E extends AbstractRequest, O extends AbstractResponse> {

    private Long id;

    public abstract O toAbstractResponse(T t);

    public abstract T toAbstractEntity(E e);
}