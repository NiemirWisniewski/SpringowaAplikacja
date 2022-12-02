package pl.nw.oceniarka.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class PostResponse {

    private Long id;
    private Long opId;
    private String content;
    private LocalDateTime dateAdded;
    private Double value;
}
