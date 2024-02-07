package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class ReactiveServiceTest {

    @RegisterExtension
    static WireMockExtension wm1 = WireMockExtension.newInstance().options(wireMockConfig().port(8080))
            .build();
    

    @Autowired
    private ReactiveService reactiveService;

    @BeforeAll
    static void configureWireMock() {
        wm1.stubFor(get("/get").willReturn(ok().withBody("Hello World")));
    }

    @Test
    void itWorks() {

        var res = reactiveService.get();
        assertEquals(res.block(), "Hello World");

        Flux<String> t = Flux.interval(Duration.ofSeconds(2)).flatMap(__ -> reactiveService.get()).take(5);
        assertEquals(t.collectList().block(), Arrays.asList("Hello World", "Hello World", "Hello World", "Hello World", "Hello World"));

        
    }

}
