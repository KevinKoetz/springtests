package com.example.demo.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.persistence.models.Campaign;
import com.example.demo.persistence.models.Customer;
import com.example.demo.persistence.models.CustomerHasCampaign;
import com.example.demo.persistence.models.CustomerHasCampaignKey;
import jakarta.transaction.Transactional;

@SpringBootTest
@Slf4j
public class CampaignRepositoryTest {
    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CustomerRespository customerRespository;

    @Autowired
    CustomerHasCampaignRespository customerHasCampaignRespository;

/*    @Test
    @Transactional
    public void canSaveSoneData() {
        var campaign = new Campaign();
        var customer = new Customer();
        var savedCustomer = customerRespository.saveAndFlush(customer);
        campaign.setName("My Campaign Name");
        var savedCampaign = campaignRepository.saveAndFlush(campaign);
        var all = campaignRepository.findAll();
        assertEquals(all.size(), 1);
        
        var customerHasCampaign = new CustomerHasCampaign();
        var customerHasCampaignKey = new CustomerHasCampaignKey();
        customerHasCampaignKey.setCampaignId(savedCampaign.getId());
        customerHasCampaignKey.setCustomerId(savedCustomer.getId());
        customerHasCampaign.setId(customerHasCampaignKey);
        customerHasCampaignRespository.saveAndFlush(customerHasCampaign);
        campaignRepository.saveAndFlush(savedCampaign);

        var queriedCampaign = campaignRepository.findById(savedCampaign.getId()).get();
        assertEquals(queriedCampaign.getCustomerHasCampaigns().size(), 1);
    }*/

    @Test
    @Transactional
    public void jpqlRetrievesPojo() {
        var campaign = new Campaign();
        var customer = new Customer();
        customer.setName("Hans Wurst");
        customer.setUnusedShit("iojhdowia");
        var savedCustomer = customerRespository.saveAndFlush(customer);
        campaign.setName("Auf in den Süden");
        campaign.setUnusedShit("iuhawekjfha");
        var savedCampaign = campaignRepository.saveAndFlush(campaign);
        var customerHasCampaign = new CustomerHasCampaign();
        customerHasCampaign.setApproval("Jup");
        var customerHasCampaignKey = new CustomerHasCampaignKey();
        customerHasCampaignKey.setCampaignId(savedCampaign.getId());
        customerHasCampaignKey.setCustomerId(savedCustomer.getId());
        customerHasCampaign.setId(customerHasCampaignKey);
        customerHasCampaignRespository.saveAndFlush(customerHasCampaign);
        campaignRepository.saveAndFlush(savedCampaign);

        log.info("------------Query------------");
        var pojoList = campaignRepository.jpqlQuery(savedCampaign.getId());
        log.info("------------Query------------");
        assertEquals(pojoList.size(), 1);
        var pojo = pojoList.get(0);
        assertEquals(pojo.campaignId(), savedCampaign.getId());
        assertEquals(pojo.customerId(), savedCustomer.getId());
        assertEquals(pojo.campaignName(), savedCampaign.getName());
        assertEquals(pojo.approval(), customerHasCampaign.getApproval());
        assertEquals(pojo.customerName(), customer.getName());
    }
}
