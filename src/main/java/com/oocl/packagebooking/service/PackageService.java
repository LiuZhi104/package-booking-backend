package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Package;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
public interface PackageService {
     List<Package> getAllPackages();
     List<Package> findPackagesByStatus( String status);
    Package updatePackage(long id, Package packageone);
    Package postPackage(Package packageone);
//     List<Package> getQueryPackge(long id);
//    ResponseEntity updateQueryPackage(long id);
//    ResponseEntity getPickupPackage(Package packageone);
//    ResponseEntity getAllPickup(Date startTime);

}
