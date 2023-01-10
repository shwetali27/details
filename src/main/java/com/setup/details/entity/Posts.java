package com.setup.details.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Column(name = "created_on")
	@GeneratedValue
	Timestamp createdOn;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JsonIgnore
	@JoinColumn(name="user_id")
	Users user;
}
