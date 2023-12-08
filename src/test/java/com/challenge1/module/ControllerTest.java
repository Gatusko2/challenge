package com.challenge1.module;

import com.challenge1.module.model.CheckAddress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Test
    public void test() throws Exception {
        CheckAddress checkAddress =new CheckAddress();
        ObjectMapper mapper = new ObjectMapper();
        ResultActions a = mockmvc.perform(post("/address/")
                .contentType("application/json")
                        .header("Authorization","Basic ZGVtby11c2VybmFtZTpkZW1vLXBhc3N3b3Jk")
                .content(mapper.writeValueAsString(checkAddress)));
    }
}
