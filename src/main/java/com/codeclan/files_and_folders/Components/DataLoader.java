package com.codeclan.files_and_folders.Components;

import com.codeclan.files_and_folders.Models.File;
import com.codeclan.files_and_folders.Models.Folder;
import com.codeclan.files_and_folders.Models.Person;
import com.codeclan.files_and_folders.Repositories.FileRepository;
import com.codeclan.files_and_folders.Repositories.FolderRepository;
import com.codeclan.files_and_folders.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Profile("!test") //optional - this file is not a test case it is a production file.
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person gomez = new Person("Gomez Adams");
        personRepository.save(gomez);

        Person wednesday = new Person("Wednesday Adams");
        personRepository.save(wednesday);

        Person pugsley = new Person("Pugsley Adams");
        personRepository.save(pugsley);

        Folder folder1 = new Folder("Documents", pugsley);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Images", wednesday);
        folderRepository.save(folder2);

        File image = new File("Cousin It pic", ".jpeg", 123, folder1);
        fileRepository.save(image);

        File Image2 = new File("Uncle Fester pic", ".jpeg", 231, folder2);
        fileRepository.save(Image2);

        File Word = new File("CV", ".pdf", 13, folder1);
        fileRepository.save(Word);

        gomez.addFolder(folder2);
        personRepository.save(gomez);

        wednesday.addFolder(folder1);
        personRepository.save(wednesday);

//        pugsley.addFolder(folder1);
//        personRepository.save(pugsley);
//
//        folder2.addPerson(gomez);
//        folderRepository.save(folder2);

    }

}
