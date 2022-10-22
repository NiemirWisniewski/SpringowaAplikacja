package pl.nw.hehexd.Api.response;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AbstractResponse {

    private Long id;
}
