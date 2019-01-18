package repositories;

import models.WorkerWorkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerWorkAreaRepository extends JpaRepository<WorkerWorkArea,Long> {
}
