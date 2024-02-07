package com.blueyonder.FS20CrudOperations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    private Long id;

    @Column(name="firstname", length = 15, nullable = false, unique = false)
    private String firstName;

    @Column(name="lastname", length = 15, nullable = false, unique = false)
    private String lastName;
}
