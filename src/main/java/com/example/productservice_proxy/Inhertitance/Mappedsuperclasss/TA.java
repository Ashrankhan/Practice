package com.example.productservice_proxy.Inhertitance.Mappedsuperclasss;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="mps_TA")
@Getter
@Setter
public class TA extends User {
    private double rating;
}
