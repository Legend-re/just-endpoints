package com.example.justendpoints.service;

import com.example.justendpoints.exceptions.InfoException;
import com.example.justendpoints.model.PersonalInfo;
import com.example.justendpoints.repositories.InfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class MyServiceImpl implements MyService {

private final InfoRepository infoRepository;

    @Override
    public List<PersonalInfo> getInformationList() {
        log.info("About getting Owner Information");
        return infoRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteAllInformation(Long id) throws InfoException {
        log.info("About Deleting All Information");
        Optional<PersonalInfo> info = infoRepository.findById(id);
    if(info.isEmpty()){
        log.error("No Information with id {} found", id);
        throw new InfoException("Information missing");
    }
    infoRepository.deleteAll();
        log.info("Successfully Deleted!");
    }
}
