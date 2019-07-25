package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface PackageRepository extends JpaRepository<Package,Long> {
//  @Modifying
//  @Transactional
//  @Query(value = "update Package p set p.staus=1 where p.id=?",nativeQuery = true)
//  int update(long id);
//  List<Package> getAllByStartTime(Date startTime);
  List<Package> findPackagesByStatus(String status);
}
