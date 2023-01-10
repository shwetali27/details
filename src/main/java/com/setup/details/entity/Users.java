package com.setup.details.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQuery(name = "Users.findAll", query = "select i from Users i")
public class Users {
	@Id
	@Column(name = "user_id")
	int userId;

	@Column(name = "user_name")
	// @Size this will restrict the name should be >= 2 while sending the create request
	@Size(min = 2, message = "Name should have atleast 2 chars")
	String name;

	@Column(name = "user_email")
	String email;

	@Column(name = "user_number")
	String number;

	@Column(name = "user_status")
	String status;

	@Column(name = "user_password")
	String password;

	@GeneratedValue
	@Column(name = "created_on")
	Timestamp createdOn;

	@Column(name = "birthdate")
	// @Past This will restrict that date should be past date while sending the
	// create request
	@Past(message = "Birth date should be in the past")
	Timestamp birthdate;
}