package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Package;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PackageService {
    public List<Package> getAllPackages();
}
