package pl.nw.oceniarka.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nw.oceniarka.comment.dto.CommentMapper;
import pl.nw.oceniarka.comment.dto.request.CommentRequest;
import pl.nw.oceniarka.comment.dto.response.CommentResponse;
import pl.nw.oceniarka.comment.domain.Comment;
import pl.nw.oceniarka.comment.repository.CommentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    public CommentResponse saveComment(CommentRequest commentRequest, Long postId) {
        Comment comment = commentMapper.toComment(commentRequest, postId);
        commentRepository.save(comment);
        return commentMapper.toCommentResponse(comment);
    }

    public CommentResponse findById(Long id) {
        return commentMapper.toCommentResponse(commentRepository.findById(id)
               .orElseThrow(() -> new RuntimeException(String.format("There is no comment with id %d", id))));
    }

    public List<CommentResponse> findAll(String author) {
        List<Comment> commentList = commentRepository.findAllByAuthor(author);
        return commentList.stream().map(commentMapper::toCommentResponse).toList();
    }

    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("no comment with such id: " + id));
        commentRepository.delete(comment);
    }

    public CommentResponse update(Long postId, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException(String.format("There is no such comment with id: %d", + postId)));
        comment.setComment(commentRequest.getComment());
        comment.setRate(commentRequest.getRate());
        commentRepository.save(comment);
        return commentMapper.toCommentResponse(comment);
    }
}