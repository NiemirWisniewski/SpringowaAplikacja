package pl.nw.hehexd.Api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.nw.hehexd.Api.request.AbstractRequest;
import pl.nw.hehexd.Api.response.AbstractResponse;
import pl.nw.hehexd.service.AbstractService;

import javax.persistence.MappedSuperclass;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@MappedSuperclass
public abstract class AbstractController<T extends AbstractResponse, E extends AbstractRequest, O extends AbstractService> {
    private final O abstractService;

    public ResponseEntity<List<T>> showAllAbstractEntities(){
        List<T> abstractResponseList = (List<T>) abstractService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(abstractResponseList);
    }

    public ResponseEntity<T> abstractCustomer(E abstractRequest){
        T abstractResponse = (T) abstractService.saveCustomer(abstractRequest);
        URI uri = URI.create("/admin/" + abstractResponse.getId());
        return ResponseEntity.created(uri).body(abstractResponse);
    }
}