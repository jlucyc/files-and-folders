package com.codeclan.files_and_folders.Repositories;

import com.codeclan.files_and_folders.Models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder,Long> {
}
