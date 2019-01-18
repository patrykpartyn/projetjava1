package repositories;

import models.WorkerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerTypeRepository extends JpaRepository<WorkerType,Long> {
}
