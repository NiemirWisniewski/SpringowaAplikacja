package pl.nw.oceniarka.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.nw.oceniarka.user.User;

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
