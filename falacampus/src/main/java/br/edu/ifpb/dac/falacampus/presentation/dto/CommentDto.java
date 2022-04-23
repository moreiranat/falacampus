package br.edu.ifpb.dac.falacampus.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifpb.dac.falacampus.model.entity.Comment;

public class CommentDto {
	
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min=5, max=50)
	private String title;
	
	@NotNull
	@NotEmpty
	@Size(min = 10, max=255)
	private String message;
	
	@NotNull
	@NotEmpty
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDateTime creationDate;
	
	public CommentDto() {
		
	}

	public CommentDto (Comment comment) {
		this.id = comment.getId();
		this.title = comment.getTitle();
		this.message = comment.getMessage();
		this.creationDate = comment.getCreationDate();
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
	
	public static List<CommentDto> converter(List<Comment> comments) {
		return comments.stream().map(CommentDto::new).collect(Collectors.toList());
	}

}
