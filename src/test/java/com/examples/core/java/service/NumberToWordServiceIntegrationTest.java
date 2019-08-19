package com.examples.core.java.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.examples.core.java.NumberInWordApplication;

 

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NumberInWordApplication.class)

public class NumberToWordServiceIntegrationTest {
    private static final String BASE_ENDPOINT_URL = "/services";
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void testNumberToWordService() throws Exception {
        String requestBody = "";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_ENDPOINT_URL + "/numberInWord/88742")
            .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestBody).headers(headers))
            .andExpect(status().isOk()).andDo(print());
    }
}
