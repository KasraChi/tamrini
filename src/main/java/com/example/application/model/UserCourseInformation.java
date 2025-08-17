package com.example.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_course_information")
public class UserCourseInformation {
    @Id
    private Long id;

    private String name;

}
