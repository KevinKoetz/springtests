package com.example.demo.persistence.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerHasCampaign {
    @EmbeddedId
    CustomerHasCampaignKey id;
    String approval;
}
