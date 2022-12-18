package pl.nw.oceniarka.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.oceniarka.exception.postException.PostExceptionSupplier;
import pl.nw.oceniarka.post.domain.Post;
import pl.nw.oceniarka.post.dto.PostMapper;
import pl.nw.oceniarka.post.dto.request.PostRequest;
import pl.nw.oceniarka.post.dto.response.PostResponse;
import pl.nw.oceniarka.post.repository.PostRepository;
import pl.nw.oceniarka.user.repository.UserRepository;

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
        return postMapper.toPostResponse(postRepository.findById(id).orElseThrow(PostExceptionSupplier.postNotFound(id)));
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostExceptionSupplier.postNotFound(id));
        postRepository.delete(post);
    }


    public PostResponse update(Long id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow(PostExceptionSupplier.postNotFound(id));
        post.setContent(postRequest.getContent());
        post.setUser(userRepository.findById(postRequest.getOpId()).orElseThrow(PostExceptionSupplier.postNotFound(id)));
        postRepository.save(post);
        return postMapper.toPostResponse(post);
    }
}
