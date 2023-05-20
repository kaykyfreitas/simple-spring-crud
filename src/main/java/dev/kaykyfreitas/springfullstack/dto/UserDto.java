package dev.kaykyfreitas.springfullstack.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record UserDto(Long id, String name, String email, String phone, @DateTimeFormat(pattern = "dd/MM/yyyy") Date birth, MultipartFile photo) {}
