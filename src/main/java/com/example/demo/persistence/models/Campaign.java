package com.example.demo.persistence.models;

import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Campaign {
    @Id
    @GeneratedValue
    UUID id;

    @Column
    @NonNull
    String name;

    @Column
    @NonNull
    String unusedShit;
}
