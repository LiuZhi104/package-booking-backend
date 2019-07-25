package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.repository.PackageRepository;
import com.oocl.packagebooking.res.PackageRes;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackageControllerTest {
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private PackageRes packageRes;
    @Autowired
    private MockMvc mockMvc;
    public void should_return_all_pakages_when_find() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get("/pakages")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    public  void should_return_all_query_packages_when_give_package_id() throws Exception {
        //given
        List<Package> mocklist=new ArrayList<>();
        Package packageone=new Package(1,"ZHANGSAN","199999999999",1,new Date());
        Package packagetwo=new Package(2,"ZHANGSAN","197742984320",0,new Date());
        Package packagethree=new Package(3,"ZHANGSAN","18312463499",0,new Date());
        mocklist.add(packageone);
        mocklist.add(packagetwo);
        mocklist.add(packagethree);
        //when
        Mockito.when(packageRes.getPackages()).thenReturn(mocklist);
        //then
        mockMvc.perform(get("/packages/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    public  void should_return_update_packages_when_give_package_id() throws Exception {
        //given
        List<Package> mocklist=new ArrayList<>();
        Package packageone=new Package(1,"ZHANGSAN","199999999999",1,new Date());
        Package packagetwo=new Package(2,"ZHANGSAN","197742984320",0,new Date());
        Package packagethree=new Package(3,"ZHANGSAN","18312463499",0,new Date());
        mocklist.add(packageone);
        mocklist.add(packagetwo);
        mocklist.add(packagethree);
        //when
        Mockito.when(packageRes.getPackages()).thenReturn(mocklist);
        //then
        mockMvc.perform(put("/packages/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    public  void should_return_pickup_packages_when_give_package_id() throws Exception {
        //given
        List<Package> mocklist=new ArrayList<>();
        Package packageone=new Package(1,"ZHANGSAN","199999999999",1,new Date());
        Package packagetwo=new Package(2,"ZHANGSAN","197742984320",0,new Date());
        Package packagethree=new Package(3,"ZHANGSAN","18312463499",0,new Date());
        mocklist.add(packageone);
        mocklist.add(packagetwo);
        mocklist.add(packagethree);
        //when
        Mockito.when(packageRes.getPackages()).thenReturn(mocklist);
        //then
        mockMvc.perform(post("/packages")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    public void should_return_all_pickup_when_give_startTime() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get("/pakages")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
