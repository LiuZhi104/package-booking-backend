package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PackageRepository extends JpaRepository<Package,Long> {
//    @Modifying
//    @Query(value = "update Package p set p.capcity=p.capcity+200 where p.id=?",nativeQuery = true)
}
