package dev.kaykyfreitas.springfullstack.repository;

import dev.kaykyfreitas.springfullstack.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileModel, Long> {}
