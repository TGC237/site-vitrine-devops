package com.tgc.vitrine.repository;

import com.tgc.vitrine.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

    @Query(value = "SELECT * FROM dashboard WHERE id = 1", nativeQuery = true)
    Dashboard findLatestStatus();
}
