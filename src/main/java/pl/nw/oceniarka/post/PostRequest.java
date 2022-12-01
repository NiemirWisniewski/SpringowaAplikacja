package pl.nw.oceniarka.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import pl.nw.oceniarka.user.User;

@Getter
public class PostRequest {

    private Long OpId;
    private String content;

    @JsonCreator
    public PostRequest(Long opId, String content) {
        this.OpId = opId;
        this.content = content;
    }
}
