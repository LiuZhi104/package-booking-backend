package com.oocl.packagebooking.service.iml;

import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.repository.PackageRepository;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class PackageServiceIml implements PackageService {
    @Autowired
    private PackageRepository packageRepository;
    @Override
    public List<Package> getAllPackages() {
        List<Package> packages=packageRepository.findAll();
        return packages;
    }

    @Override
    public List<Package> getQueryPackge(long id) {
        List<Package> queryPackages=packageRepository.findAllById(Collections.singleton(id));
        return  queryPackages;
    }

    @Override
    public ResponseEntity updateQueryPackage(long id) {
        int status=packageRepository.update(id);
        Package packageone=packageRepository.findById(id).get();
        if (status == 1) {
            return ResponseEntity.ok(packageone);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity getPickupPackage(Package packageone) {
        Package newPackage=packageRepository.save(packageone);
        return ResponseEntity.ok(newPackage);
    }
}
