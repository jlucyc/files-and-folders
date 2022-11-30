package com.codeclan.files_and_folders.Repositories;

import com.codeclan.files_and_folders.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
