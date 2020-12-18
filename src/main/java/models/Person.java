package models;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private String country;
    private Integer personalID;
}
