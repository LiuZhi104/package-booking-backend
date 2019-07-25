package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.repository.PackageRepository;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class PackageController {
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private PackageService packageService;
    @GetMapping("/packages")
    public ResponseEntity getAllPackages(){
        return  ResponseEntity.ok(packageService.getAllPackages());
    }
    @GetMapping("/packages/{id}")
    public ResponseEntity getQueryPackages(@PathVariable long id){
        return  ResponseEntity.ok(packageService.getQueryPackge(id));
    }
    @PutMapping("/packages/{id}")
    public  ResponseEntity updateQueryPackage(@PathVariable long id){
        return packageService.updateQueryPackage(id);
    }
    @PostMapping("/packages")
    public  ResponseEntity postPickupPackage(@RequestBody Package packageone){
       return  packageService.getPickupPackage(packageone);
    }
    @GetMapping("/packages")
    public  ResponseEntity getAllpickup(@RequestParam Date startTime){

    }


}
