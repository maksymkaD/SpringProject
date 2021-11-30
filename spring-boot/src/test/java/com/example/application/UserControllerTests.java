package com.example.application;


import com.example.application.controller.user.*;
import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.service.user.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

@WebMvcTest(UserController.class)
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void isMockMvcAutowired()throws Exception {
        assertNotNull(mockMvc);
        System.out.println("test 1 : isMockMvcAutowired - success");
    }

    @Test
    public void loginRedirection_test() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is(302));
        System.out.println("test 2 : loginRedirection_test - success");
    }

    @WithMockUser(authorities = {"admin","teacher","student"})
    @Test
    public void getUser_test() throws Exception {
        this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().is(200));
        System.out.println("test 3 : getUser_test - success");
    }

    @WithMockUser(authorities = {"admin","teacher"})
    @Test
    public void deleteUser_test() throws Exception {
        this.mockMvc.perform(delete("/users/1")).andDo(print()).andExpect(status().isOk());
        System.out.println("test 4 : deleteUser_test - success");
    }

    @WithMockUser(authorities = {"student"})
    @Test
    public void unauthorizedDeleteUser_test() throws Exception {
        this.mockMvc.perform(delete("/users/1")).andDo(print()).andExpect(status().is(403));
        System.out.println("test 5 : unauthorizedDeleteUser_test - success");
    }

}
