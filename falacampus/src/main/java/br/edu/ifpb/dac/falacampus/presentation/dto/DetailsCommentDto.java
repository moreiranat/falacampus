package br.edu.ifpb.dac.falacampus.presentation.dto;

import java.time.LocalDateTime;

import br.edu.ifpb.dac.falacampus.model.entity.Answer;
import br.edu.ifpb.dac.falacampus.model.entity.Comment;
import br.edu.ifpb.dac.falacampus.model.enums.CommentType;
import br.edu.ifpb.dac.falacampus.model.enums.StatusComment;

public class DetailsCommentDto {
	
	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();
	private CommentType commentType;
	private StatusComment statusComment;
	private String authorName;
	private Long departamentId;
	private Answer answer;
	
	public DetailsCommentDto() {
		
	}
	
	public DetailsCommentDto (Comment comment) {
		this.id = comment.getId();
		this.title = comment.getTitle();
		this.message = comment.getMessage();
		this.creationDate = comment.getCreationDate();
		this.commentType = comment.getCommentType();
		this.statusComment = comment.getStatusComment();
		this.authorName = comment.getAuthor().getName();
		this.departamentId = comment.getDepartament().getId();
		this.answer = comment.getAnswer();
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getDepartamentId() {
		return departamentId;
	}

	public void setDepartamentId(Long departamentId) {
		this.departamentId = departamentId;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}
