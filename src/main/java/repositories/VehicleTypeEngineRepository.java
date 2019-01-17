package repositories;

import models.VehicleTypeEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeEngineRepository extends JpaRepository<VehicleTypeEngine,Long> {
}
