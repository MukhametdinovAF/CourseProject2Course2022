package ru.mukhametdinov.courseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mukhametdinov.courseproject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
