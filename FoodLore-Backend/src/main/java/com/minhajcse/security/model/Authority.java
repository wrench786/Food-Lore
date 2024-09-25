package com.minhajcse.security.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "authority_table")
public class Authority {
    @Id
    @GeneratedValue
    @Column(name = "authority_id")
    private long id;

    @Column(name = "authority", unique = true)
    public String authority;
}
