package com.example.productservice_proxy.Inhertitance.Tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tpc_TA")
@Getter
@Setter
public class TA extends User{
    private double rating;
}
