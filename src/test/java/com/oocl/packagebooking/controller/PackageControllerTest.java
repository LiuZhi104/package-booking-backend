package com.oocl.packagebooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.repository.PackageRepository;
import com.oocl.packagebooking.res.PackageRes;
import com.oocl.packagebooking.service.PackageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PackageController.class)
public class PackageControllerTest {
    @MockBean
    private PackageService packageService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_all_pakages_when_find() throws Exception {
        // given
        List<Package> mocklist = new ArrayList<>();
        Package packageOne = new Package("starting", 500L);
        mocklist.add(packageOne);
        Mockito.when(packageService.getAllPackages()).thenReturn(mocklist);

        this.mockMvc.perform(get("/packages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].status").value("starting"))
                .andExpect(jsonPath("$.[0].startTime").value(500L));
    }

    @Test
    public void should_return_all_query_packages_when_give_package_id() throws Exception {
        // given
        List<Package> mocklist = new ArrayList<>();
        Package packageOne = new Package("starting", 100L);
        mocklist.add(packageOne);
        given(packageService.findPackagesByStatus(anyString())).willReturn(mocklist);

        this.mockMvc.perform(
                get("/packages?status=starting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].status").value("starting"))
                .andExpect(jsonPath("$.[0].startTime").value(100L));
    }

    @Test
    public void should_return_update_packages_when_give_package_id() throws Exception {
        // given
        Package packageOne = new Package("starting", 500L);
        given(packageService.updatePackage(anyLong(), any(Package.class))).willReturn(packageOne);

        this.mockMvc.perform(put("/packages/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(packageOne)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("starting"))
                .andExpect(jsonPath("$.startTime").value(500L));
    }

    @Test
    public void should_return_pickup_packages_when_give_package_id() throws Exception {
        // given
        Package packageOne = new Package("starting", 500L);
        given(packageService.postPackage(any(Package.class))).willReturn(packageOne);

        this.mockMvc.perform(post("/packages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(packageOne)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("starting"))
                .andExpect(jsonPath("$.startTime").value(500L));

    }
}
