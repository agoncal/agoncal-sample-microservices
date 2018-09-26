package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the NumberGeneratorResource REST controller.
 *
 * @see HoldingsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HoldingsResourceIntTest {

    private MockMvc restTickerResourceMockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final HoldingsResource holdingsResource = new HoldingsResource(null);
        this.restTickerResourceMockMvc = MockMvcBuilders.standaloneSetup(holdingsResource)
                .build();
    }

    @Test
    public void checkHealth() throws Exception {
        // Checks Health
        restTickerResourceMockMvc.perform(get("/api/getHoldings/health"))
                .andExpect(status().isOk());
    }
}
