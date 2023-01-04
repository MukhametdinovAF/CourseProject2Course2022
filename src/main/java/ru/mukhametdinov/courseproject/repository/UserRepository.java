package ru.mukhametdinov.courseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mukhametdinov.courseproject.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
