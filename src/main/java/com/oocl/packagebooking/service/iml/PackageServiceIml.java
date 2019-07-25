package com.oocl.packagebooking.service.iml;

import com.oocl.packagebooking.exception.ErrorBookingTimeException;
import com.oocl.packagebooking.exception.NoSuchPackageException;
import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.repository.PackageRepository;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
@Service
public class PackageServiceIml implements PackageService {
    @Autowired
    private PackageRepository packageRepository;
    @Override
    public List<Package> getAllPackages() {
        List<Package> packages=packageRepository.findAll();
        return packages;
    }

    @Override
    public List<Package> findPackagesByStatus(String status) {
        return packageRepository.findPackagesByStatus(status);
    }

    @Override
    public Package updatePackage(long id, Package packageone) {
        long pID = packageRepository.findById(id).orElseThrow(NoSuchPackageException::new).getId();
        long startTime = packageone.getStartTime();
        LocalDateTime localDateTime = Instant.ofEpochMilli(startTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
        int hour = localDateTime.getHour();
        if (hour > 9 && hour < 20) {
            packageone.setId(id);
            return packageRepository.save(packageone);
        } else {
            throw new ErrorBookingTimeException();
        }
    }
    @Override
    public Package postPackage(Package packageone) {
        return packageRepository.saveAndFlush(packageone);
    }

}
