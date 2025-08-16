package com.example.application.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_course_information")
public class Platform {

    @Id
    private Long id;

    @Column(name = "social_network")
    private String name;

    @Transient
    private int usage;
}
//@Table(name = "messaging_platform_usage")
//public class Platform {
//
//    @Id
//    private long id;
//    private String name;
//    private int usage;
//
//
//}
