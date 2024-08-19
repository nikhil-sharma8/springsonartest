package com.zemoso.formvalidation.model;

import com.zemoso.formvalidation.validation.EnrollmentNumber;
import com.zemoso.formvalidation.validation.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "Please provide first name")
    private String firstName;
    private String lastName;

    @NotNull(message = "Please provide enrollment number")
    @Size(min = 3, message = "Enrollment number should be of size greater than 3")
    @EnrollmentNumber
    private String enrollmentNo;

    @Pattern(regexp = "^\\d{10}$", message = "Please enter a 10 digit number")
    private String phoneNumber;

    @NotNull(message = "Please enter a valid percentage")
    private Double aggregatePercentage;

    @Gender     //Custom validator
    private Character gender;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter a valid email")
    private String email;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentNo='" + enrollmentNo + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", aggregatePercentage=" + aggregatePercentage +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
