package br.edu.ifpb.dac.falacampus.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifpb.dac.falacampus.model.entity.Answer;
import br.edu.ifpb.dac.falacampus.model.entity.Comment;
import br.edu.ifpb.dac.falacampus.model.enums.CommentType;
import br.edu.ifpb.dac.falacampus.model.enums.StatusComment;

public class DetailsCommentDto {
	
	private Long id;
	
	@NotNull @NotEmpty @Size(min=5, max=50)	
	private String title; 
	
	@NotNull @NotEmpty @Size(min = 10, max=255)
	private String message;
	
	private LocalDateTime creationDate = LocalDateTime.now();
	
	private CommentType commentType;
	
	private StatusComment statusComment = StatusComment.NOT_SOLVED;
	
	private Long authorId;
	
	private Long departamentId;
	
	private Long answerId;
	
	public DetailsCommentDto() {
		
	}
	
	public DetailsCommentDto (Comment comment) {
		this.id = comment.getId();
		this.title = comment.getTitle();
		this.message = comment.getMessage();
		this.commentType = comment.getCommentType();
		this.statusComment = comment.getStatusComment();
		this.authorId = comment.getAuthor().getId();
		this.departamentId = comment.getDepartament().getId();
		this.answerId = comment.getAnswer().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	public StatusComment getStatusComment() {
		return statusComment;
	}

	public void setStatusComment(StatusComment statusComment) {
		this.statusComment = statusComment;
	}
	
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getDepartamentId() {
		return departamentId;
	}

	public void setDepartamentId(Long departamentId) {
		this.departamentId = departamentId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	
	public static List<DetailsCommentDto> converter(List<Comment> comments) {
		return comments.stream().map(DetailsCommentDto::new).collect(Collectors.toList());
	}
	
}
