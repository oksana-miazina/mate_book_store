package mate.academy.bookstore.repository;

import mate.academy.bookstore.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByName(Role.RoleName roleName);
}
