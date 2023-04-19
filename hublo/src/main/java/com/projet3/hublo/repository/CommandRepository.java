package com.projet3.hublo.repository;

import com.projet3.hublo.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

}
