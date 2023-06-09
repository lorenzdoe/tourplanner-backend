package at.technikum.tourplannerbackend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private Long id;
    private String name;
    private Boolean isEmployed;


}
