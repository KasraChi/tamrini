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
@Table(name = "messaging_platform_usage")
public class Platform {

    @Id
    private long id;
    private String name;
    private int usage;


}
