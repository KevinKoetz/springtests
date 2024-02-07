package com.example.demo.persistence.models;

import java.util.UUID;

public record Pojo(UUID campaignId, String campaignName, UUID customerId, String customerName, String approval) {
}
