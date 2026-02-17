package com.aluri.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name="Customer",
        description = "Schema to hold Customer and account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Akhil Aluri"
    )
    @NotEmpty(message="name cannot be a null or empty")
    @Size(min=5, max=30,message ="name should be min of 5 chars and max of 30 chars")
    private String name;

    @Schema(
            description = "Email of the customer", example = "akhil258@gmail.com"
    )
    @NotEmpty(message="email cannot be a null or empty")
    @Email(message = "Email should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "7416145779"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message="Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
