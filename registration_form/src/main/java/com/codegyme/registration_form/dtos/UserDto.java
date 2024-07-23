package com.codegyme.registration_form.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto {
    @NotBlank(message = "Name could not be blank")
    @Pattern(regexp = "^[A-Za-z]{3,45}$", message = "Name is not valid")
    private String firstName;

    @NotBlank(message = "Name could not be blank")
    @Pattern(regexp = "^[A-Za-z]{3,45}$", message = "Name is not valid")
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9}$",message = "Phone number is not valid")
    private String phoneNumber;

    @Min(value = 18,message = "Age must be higher or equal 18")
    private int age;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",message = "email is not valid"
    )
    private String email;

    public UserDto() {}

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
