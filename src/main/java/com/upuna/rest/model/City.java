package com.upuna.rest.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class City implements Serializable {

    private static final long serialVersionUID = -1147240351916042688L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cityCenterLatitude;
    private double getCityCenterLongitude;

}