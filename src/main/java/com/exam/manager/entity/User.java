package com.exam.manager.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	
	@NotBlank(message="Name Field is required !!")
	@Size(min=2,max = 20, message="Name must have min 2 and max 20 characters")
	private String userName;
	
	@Column(unique = true)
	private String userEmailID;
	
	private String userPassword;
	
	@Column(length = 500)
	private String userAbout;
	
	private Boolean profileIsActive;
	
	private String role;
	
	private String userProfileImageUrl;
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
	private Set<Contact> contacts = new HashSet<>();

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userEmailID=" + userEmailID + ", userPassword="
				+ userPassword + ", userAbout=" + userAbout + ", profileIsActive=" + profileIsActive + ", role=" + role
				+ ", userProfileImageUrl=" + userProfileImageUrl + ", contacts=" + contacts + "]";
	}
	
	
}
