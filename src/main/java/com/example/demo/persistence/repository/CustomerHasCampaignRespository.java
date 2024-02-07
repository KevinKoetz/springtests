package com.example.demo.persistence.repository;

import com.example.demo.persistence.models.Pojo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.persistence.models.CustomerHasCampaign;
import com.example.demo.persistence.models.CustomerHasCampaignKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CustomerHasCampaignRespository extends JpaRepository<CustomerHasCampaign, CustomerHasCampaignKey>{

}
