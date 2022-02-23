package ru.hogvards.magicschool.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogvards.magicschool.model.Avatar;

import java.io.IOException;

public interface AvatarService {
    Avatar findAvatar(Long id);
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
}
