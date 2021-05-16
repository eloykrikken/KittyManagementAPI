package eloy.personal.KittyManagementAPI.repository;

import eloy.personal.KittyManagementAPI.model.LitterBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LitterBoxRepository extends JpaRepository<LitterBox, Integer> {
}
