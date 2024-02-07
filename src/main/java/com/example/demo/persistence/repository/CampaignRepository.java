package com.example.demo.persistence.repository;

import com.example.demo.persistence.models.Campaign;
import com.example.demo.persistence.models.Pojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
    @Query("select new com.example.demo.persistence.models.Pojo(cam.id, cam.name, cust.id, cust.name, chc.approval) from CustomerHasCampaign as chc " +
            "inner join Campaign as cam On chc.id.campaignId = cam.id " +
            "inner join Customer as cust On chc.id.customerId = cust.id " +
            "where chc.id.campaignId = :campaignId")
    List<Pojo> jpqlQuery(@Param("campaignId") UUID id);

}
