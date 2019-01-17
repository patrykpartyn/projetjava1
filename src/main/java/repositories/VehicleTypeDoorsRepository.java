package repositories;
import models.VehicleTypeDoors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeDoorsRepository extends JpaRepository<VehicleTypeDoors, Integer>{
}
