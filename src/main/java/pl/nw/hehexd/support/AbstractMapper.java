package pl.nw.hehexd.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.nw.hehexd.Api.request.AbstractRequest;
import pl.nw.hehexd.Api.response.AbstractResponse;
import pl.nw.hehexd.domain.AbstractEntity;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMapper {

    private Long id;

    public AbstractResponse toAbstractResponse(AbstractEntity abstractEntity){
        return new AbstractResponse(abstractEntity.getId());
    }

    public abstract AbstractEntity toAbstractEntity(AbstractRequest abstractRequest);

}