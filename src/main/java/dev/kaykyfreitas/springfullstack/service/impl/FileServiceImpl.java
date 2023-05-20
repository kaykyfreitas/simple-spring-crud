package dev.kaykyfreitas.springfullstack.service.impl;

import dev.kaykyfreitas.springfullstack.exception.NotFoundException;
import dev.kaykyfreitas.springfullstack.model.FileModel;
import dev.kaykyfreitas.springfullstack.repository.FileRepository;
import dev.kaykyfreitas.springfullstack.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    public void create(MultipartFile file) {
        try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getSize(), file.getContentType(), file.getBytes());
            fileRepository.save(fileModel);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<FileModel> findAll() {
        return fileRepository.findAll();
    }

    @Override
    public void update(FileModel file) {
        final var foundedFile = fileRepository.findById(file.getId()).orElseThrow(() -> new NotFoundException("User not found."));
        foundedFile.setFilename(file.getFilename());
        foundedFile.setFilesize(file.getFilesize());
        foundedFile.setFiletype(file.getFiletype());
        foundedFile.setContent(file.getContent());
        fileRepository.save(foundedFile);
    }

    @Override
    public FileModel findById(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found."));
    }

    @Override
    public void delete(Long id) {
        fileRepository.deleteById(id);
    }
}
