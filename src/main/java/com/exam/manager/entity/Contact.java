package com.exam.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contacts")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	
	private String contactName;
	
	private String contactNickName;
	
	private String contactWorkDetails;
	
	private String contactEmailAddress;
	
	private String contactImageUrl;
	
	private String contactPhoneNumber;
	
	@Column(length = 5000)
	private String contactDescription;
	
	@ManyToOne
	@JsonIgnore
	private User user;

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNickName="
				+ contactNickName + ", contactWorkDetails=" + contactWorkDetails + ", contactEmailAddress="
				+ contactEmailAddress + ", contactImageUrl=" + contactImageUrl + ", contactPhoneNumber="
				+ contactPhoneNumber + ", contactDescription=" + contactDescription + ", user=" + user + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.contactId == ((Contact)obj).getContactId();
	}
	
	
}
