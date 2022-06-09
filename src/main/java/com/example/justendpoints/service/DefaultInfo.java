package com.example.justendpoints.service;

import com.example.justendpoints.model.PersonalInfo;
import com.example.justendpoints.repositories.InfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;


@AllArgsConstructor
@Service
@Slf4j
public class DefaultInfo implements CommandLineRunner{

    private final InfoRepository infoRepository;

    @Override
    public void run(String... args) throws Exception {
        PersonalInfo mine = infoRepository.findById(1L).orElse(null);
        if(mine == null) {
            PersonalInfo info = new PersonalInfo(
                    1L,
                    "Lagbaja Ajenifuja",
                    234063445219L,
                    LocalDate.of(1999, Month.JUNE, 2),
                    "No 2, Emilokan street, Eleyi Estate, Off Jagaban road.",
                    "Lagos",
                    "Nigeria"
            );
            infoRepository.save(info);

            log.info("ID Created");
        }else{
            log.info("ID already exist");
            }

    }
}
