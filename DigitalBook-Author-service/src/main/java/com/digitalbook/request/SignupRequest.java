package com.digitalbook.request;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Table(name = "signUpRequest")
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(name = "username")
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Set<String> role;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
