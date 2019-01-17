package repositories;
import models.VehicleAreaRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAreaRentalRepository extends JpaRepository<VehicleAreaRental, Long> {
}
