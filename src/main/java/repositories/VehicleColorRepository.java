package repositories;

import models.VehicleColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleColorRepository extends JpaRepository<VehicleColor, Long> {
}
