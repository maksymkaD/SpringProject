package com.example.application;


import com.example.application.controller.user.*;
import com.example.application.dal.repository.UserRepository;
import com.example.application.page.user.StudentPage;
import com.example.application.page.user.TeacherPage;
import com.example.application.service.user.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({TeacherController.class, TeacherPage.class})
class TeacherControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private TeacherService teacherService;

    @MockBean
    private UserRepository userRepository;


    @WithMockUser(authorities = {"admin","teacher"})
    @Test
    public void getTeachers_test() throws Exception {
        this.mockMvc.perform(get("/teachers")).andDo(print()).andExpect(status().is(200));
        System.out.println("test 1 : getTeachers_test - success");
    }

    @WithMockUser(authorities = {"admin","teacher"})
    @Test
    public void postTeachers_test() throws Exception {
        this.mockMvc.perform(post("/teachers")).andDo(print()).andExpect(status().is(302));
        System.out.println("test 2 : postTeachers_test - success");
    }


}
