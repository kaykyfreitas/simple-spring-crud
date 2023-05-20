package dev.kaykyfreitas.springfullstack.service;

import dev.kaykyfreitas.springfullstack.model.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    void create(MultipartFile file);

    List<FileModel> findAll();

    void update(FileModel file);

    FileModel findById(Long id);

    void delete(Long id);

}
