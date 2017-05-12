package com.mastercard.example.springbootsample;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by e056441 on 5/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdultControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAdult() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/check/21").
                accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.equalTo("Yes, Person is Adult")));
    }


    @Test
    public void testNotAnAdult() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/check/15").
                accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.equalTo("No, Person is not an Adult")));
    }


}
