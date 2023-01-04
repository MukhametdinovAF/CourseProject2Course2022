package ru.mukhametdinov.courseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mukhametdinov.courseproject.entity.CounterAgent;

@Repository
public interface CounterAgentRepository extends JpaRepository<CounterAgent, Long> {

}
