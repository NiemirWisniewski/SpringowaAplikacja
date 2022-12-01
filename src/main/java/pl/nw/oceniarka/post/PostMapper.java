package pl.nw.oceniarka.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nw.oceniarka.user.UserRepository;

@Component
@RequiredArgsConstructor
public class PostMapper {

    private final UserRepository userRepository;

    public Post toPost(PostRequest postRequest) {
        return new Post(userRepository.findById(postRequest.getOpId()).orElseThrow(() -> new RuntimeException("there is no user with such id"))
                , postRequest.getContent());
    }

    public PostResponse toPostResponse(Post post) {
        return new PostResponse(post.getId(), post.getUser().getId(), post.getContent(), post.getDateAdded(), post.getValue());
    }
}