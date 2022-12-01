package pl.nw.oceniarka.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.oceniarka.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponse saveCustomer(PostRequest postRequest) {
        Post post =  postMapper.toPost(postRequest);
        postRepository.save(post);
        return postMapper.toPostResponse(post);
    }

    public List<PostResponse> findAll() {
        List<Post> userList = postRepository.findAll();
        return userList.stream().map(postMapper::toPostResponse).collect(Collectors.toList());
    }

    public PostResponse findById(Long id){
        return postMapper.toPostResponse(postRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a post")));
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a post"));
        postRepository.delete(post);
    }


    public PostResponse update(Long id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no such a post"));
        post.setContent(postRequest.getContent());
        post.setUser(userRepository.findById(postRequest.getOpId()).orElseThrow(() -> new RuntimeException("There is no such a user")));
        postRepository.save(post);
        return postMapper.toPostResponse(post);
    }
}
