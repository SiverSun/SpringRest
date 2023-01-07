package com.example.springrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;


import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
public class User {
    @Email(message = "Введен не адрес электронной почты!")
    String login;
    @Length(min = 4, message = "Пароль должен быть от 4 символов!")
    String password;
    @JsonIgnore
    Set<Authorities> authorities;
}
