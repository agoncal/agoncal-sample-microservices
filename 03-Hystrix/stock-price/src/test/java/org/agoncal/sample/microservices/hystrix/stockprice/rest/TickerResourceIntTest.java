package org.agoncal.sample.microservices.hystrix.stockprice.rest;

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
 * @see TickerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TickerResourceIntTest {

    private MockMvc restTickerResourceMockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TickerResource tickerResource = new TickerResource();
        this.restTickerResourceMockMvc = MockMvcBuilders.standaloneSetup(tickerResource)
                .build();
    }

    @Test
    public void checkHealth() throws Exception {

        // Checks Health
        restTickerResourceMockMvc.perform(get("/getTickerPrice/health"))
                .andExpect(status().isOk());
    }
}
