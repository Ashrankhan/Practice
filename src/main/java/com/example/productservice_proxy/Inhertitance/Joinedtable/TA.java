package com.example.productservice_proxy.Inhertitance.Joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name="jt_TA")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private double rating;
}
