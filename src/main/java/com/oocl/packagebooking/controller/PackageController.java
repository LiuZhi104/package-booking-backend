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
    private PackageService packageService;
    @GetMapping("/packages")
    public ResponseEntity getAllPackage(@RequestParam(defaultValue = "") String status){
        if(status.equals("")) {
            return ResponseEntity.ok(packageService.getAllPackages());
        } else {
            return ResponseEntity.ok(packageService.findPackagesByStatus(status));
        }
    }
    @PutMapping("/packages/{id}")
    public Package updatePackage(@RequestBody Package packageone, @PathVariable long id){
        return packageService.updatePackage(id, packageone);
    }

    @PostMapping("/packages")
    public Package createPackage(@RequestBody Package packageone) {
        return packageService.postPackage(packageone);
    }


}
