package pl.wsb.collection.libraryclientweb.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.collection.libraryclientweb.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
