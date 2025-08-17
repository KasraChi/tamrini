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

@Table(name = "prepaid_user_information")
public class PrepaidUserInformation {
    @Id
    private Long id;

    private String name;

}
