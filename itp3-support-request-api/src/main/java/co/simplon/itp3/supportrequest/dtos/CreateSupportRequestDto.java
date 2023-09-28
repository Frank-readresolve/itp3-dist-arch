package co.simplon.itp3.supportrequest.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateSupportRequestDto {

    @NotBlank
    private String email;

    @NotBlank
    @Size(max = 100)
    private String subject;

    @NotBlank
    @Size(max = 1000)
    private String description;

    public CreateSupportRequestDto() {

    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "CreateSupportRequestDto [email=" + email
		+ ", subject=" + subject + ", description="
		+ description + "]";
    }

}
