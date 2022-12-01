package pl.nw.oceniarka.post;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Api(tags = "Post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ApiOperation("Show all posts")
    public ResponseEntity<List<PostResponse>> showAllPosts() {
        List<PostResponse> postResponseList = postService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(postResponseList);
    }

    @PostMapping
    @ApiOperation("Create post")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
        PostResponse postResponse = postService.saveCustomer(postRequest);
        URI uri = URI.create("/admin/" + postResponse.getId());
        return ResponseEntity.created(uri).body(postResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find post")
    public ResponseEntity<PostResponse> findPost(@PathVariable Long id) {
        PostResponse postResponse = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(postResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete post")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update post")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        PostResponse postResponse = postService.update(id, postRequest);
        return ResponseEntity.status(HttpStatus.OK).body(postResponse);
    }
}