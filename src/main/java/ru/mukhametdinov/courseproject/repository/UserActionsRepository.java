package ru.mukhametdinov.courseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mukhametdinov.courseproject.entity.UserActions;

@Repository
public interface UserActionsRepository extends JpaRepository<UserActions,Long> {

}
