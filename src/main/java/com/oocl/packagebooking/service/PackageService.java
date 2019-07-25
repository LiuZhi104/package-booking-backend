package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Package;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PackageService {
    public List<Package> getAllPackages();
    public List<Package> getQueryPackge(long id);
//    public Package uodateQueryPackage(long id,int status);

}
