package pl.nw.hehexd.Api;

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
public abstract class AbstractController {
    private final AbstractService abstractService;

    public ResponseEntity<List<AbstractResponse>> showAllAbstractEntities(){
        List<AbstractResponse> abstractResponseList = abstractService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(abstractResponseList);
    }

    public ResponseEntity<AbstractResponse> abstractCustomer(AbstractRequest abstractRequest){
        AbstractResponse abstractResponse = abstractService.saveCustomer(abstractRequest);
        URI uri = URI.create("/admin/" + abstractResponse.getId());
        return ResponseEntity.created(uri).body(abstractResponse);
    }
}