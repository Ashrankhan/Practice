package com.example.productservice_proxy.Inhertitance.Singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="sc_TA")
@DiscriminatorValue(value = "1")
@Getter
@Setter
public class TA extends User {
    private double rating;
}
