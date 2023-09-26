package co.simplon.itp3.supportrequest.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MailSenderDto {

    @NotBlank
    @Email
    private String primaryRecipient;

    @Email
    @NotBlank
    private String sender;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\\s]+")
    @Size(min = 1, max = 100)
    private String subject;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9/. $]+$")
    @Size(min = 1, max = 1000)
    private String body;

    public MailSenderDto() {
    }

    public String getPrimaryRecipient() {
	return primaryRecipient;
    }

    public void setPrimaryRecipient(
	    String primaryRecipient) {
	this.primaryRecipient = primaryRecipient;
    }

    public String getSender() {
	return sender;
    }

    public void setSender(String sender) {
	this.sender = sender;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    @Override
    public String toString() {
	return " {primaryRecipient=" + primaryRecipient
		+ ", sender=" + sender + ", subject="
		+ subject + ", body=" + body + "}";
    }

}
