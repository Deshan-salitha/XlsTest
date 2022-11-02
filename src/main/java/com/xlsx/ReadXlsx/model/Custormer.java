package com.xlsx.ReadXlsx.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class Custormer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custormerId;
    private String customerName;
    private String city;
    private String country;
    private String contactName;

    public Custormer(int custormerId, String customerName, String city, String country, String contactName) {
        this.custormerId = custormerId;
        this.customerName = customerName;
        this.city = city;
        this.country = country;
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "Custormer{" +
                "custormerId=" + custormerId +
                ", customerName='" + customerName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactName='" + contactName + '\'' +
                '}';
    }
}
