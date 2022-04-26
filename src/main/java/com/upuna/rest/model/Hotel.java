package com.upuna.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hotel implements Serializable {

    private static final long serialVersionUID = 2087500586896068L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double rating;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    private String address;
    private double latitude;
    private double longitude;
    @JsonIgnore
    private boolean deleted;

}
