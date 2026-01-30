package com.tgc.site.repository;
package com.tgc.vitrine.repository; // Attention à bien garder le package "vitrine"
import com.tgc.site.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tgc.vitrine.model.Dashboard;
import org.springframework.stereotype.Repository; 

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    // Récupère la dernière ligne mise à jour par n8n
    @Query(value = "SELECT * FROM dashboard WHERE id = 1", nativeQuery = true)
    Dashboard findLatestStatus();
}
