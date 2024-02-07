package com.example.demo.persistence.models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    @NonNull
    UUID id;

    @Column
    @NonNull
    String name;

    @Column
    @NonNull
    String unusedShit;
}
