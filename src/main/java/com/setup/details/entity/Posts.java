package com.setup.details.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
@NamedQuery(name="Posts.findAll", query="select i from Posts i")
public class Posts {

	@Id
	@Column(name = "post_id")
	int postId;
	String title;
	String description;
	
	@Column(name = "user_id")
	int userId;
	
	@Column(name = "created_on")
	Timestamp createdOn;
}
