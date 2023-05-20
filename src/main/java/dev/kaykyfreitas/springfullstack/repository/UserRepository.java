package dev.kaykyfreitas.springfullstack.repository;

import dev.kaykyfreitas.springfullstack.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {}
