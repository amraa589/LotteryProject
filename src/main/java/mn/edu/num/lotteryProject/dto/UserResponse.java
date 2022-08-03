package mn.edu.num.lotteryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserResponse {
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName, lastName, email, username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String jwt;

    private Long id;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
