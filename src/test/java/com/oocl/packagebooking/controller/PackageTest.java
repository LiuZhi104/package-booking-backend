package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.repository.PackageRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackageTest {
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private MockMvc mockMvc;
    public void should_return_all_pakages_when_find() throws Exception {
        mockMvc.perform(get("/pakages")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
