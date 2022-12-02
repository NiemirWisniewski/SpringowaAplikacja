package pl.nw.oceniarka.comment.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private String comment;
    private Long authorId;
    private Double rate;

    @JsonCreator
    public CommentRequest(String comment, Long authorId, Double rate) {
        this.comment = comment;
        this.authorId = authorId;
        this.rate = rate;
    }
}
