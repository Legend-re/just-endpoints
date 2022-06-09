package com.example.justendpoints.service;

import com.example.justendpoints.exceptions.InfoException;
import com.example.justendpoints.model.PersonalInfo;

import java.util.List;

public interface MyService {

     List<PersonalInfo> getInformationList();

     void deleteAllInformation(Long id) throws InfoException;
}
