package pl.nw.oceniarka.post.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nw.oceniarka.post.domain.Post;
import pl.nw.oceniarka.post.dto.request.PostRequest;
import pl.nw.oceniarka.post.dto.response.PostResponse;
import pl.nw.oceniarka.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class PostMapper {

    private final UserRepository userRepository;

    public Post toPost(PostRequest postRequest) {
        return new Post(userRepository.findById(postRequest.getOpId()).orElseThrow(() -> new RuntimeException("there is no user with such id"))
                , postRequest.getContent());
    }

    public PostResponse toPostResponse(Post post) {
        return new PostResponse(post.getId(), post.getUser().getId(), post.getContent(), post.getDateAdded());
    }
}