package com.oocl.packagebooking.res;

import com.oocl.packagebooking.model.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRes {
    private List<Package> packages=new ArrayList<>();
    public void add(Package packageone){
        this.packages.add(packageone);
    }

    public List<Package> getPackages() {
        return packages;
    }
}
