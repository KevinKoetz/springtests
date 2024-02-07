package com.example.demo.persistence.models;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CustomerHasCampaignKey implements Serializable {
    @Column
    @NonNull
    UUID customerId;
    @Column
    @NonNull
    UUID campaignId;
}
