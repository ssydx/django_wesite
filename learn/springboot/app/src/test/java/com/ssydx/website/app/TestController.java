package com.ssydx.website.app;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ssydx.website.app.controller.UserController;
import com.ssydx.website.app.service.UserService;

@WebMvcTest(controllers = UserController.class)
public class TestController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void TestUserController() throws Exception {
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/1")).andExpect(status().isOk()).andReturn();
        System.out.println(res.getResponse().getContentAsString());
    }
}
