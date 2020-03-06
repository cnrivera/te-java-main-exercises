package com.techelevator.mailingList.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;


public class MailingListSignUp {
	
	@NotBlank(message="You must provide your name.")
	private String name;

	@NotBlank(message="Email address is required.")
	@Email
	private String email;
	
	private String emailVerification;
	
	@AssertTrue(message="Email addresses do not match.")
	public boolean isEmailMatching() {
		return email != null && email.equals(emailVerification);
	}

	@NotBlank
	@Pattern(regexp="\\([0-9]{3}\\)[0-9]{3}-[0-9]{4}", message="Expected (###)###-####")
	private String phone;

	@Range(min=13, max=120, message="You are too old or young!")
	private int age;
	
	@NotNull
	@Future(message="Subscription must start on a future date!")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate subscriptionStartDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime confirmationCallTime;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailVerification() {
		return emailVerification;
	}
	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getSubscriptionStartDate() {
		return subscriptionStartDate;
	}
	public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}
	public LocalDateTime getConfirmationCallTime() {
		return confirmationCallTime;
	}
	public void setConfirmationCallTime(LocalDateTime confirmationCallTime) {
		this.confirmationCallTime = confirmationCallTime;
	}
	
}
