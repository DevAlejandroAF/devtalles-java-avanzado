package com.devtalles.tu_cv_spring_boot.tuCV.service;

import com.devtalles.tu_cv_spring_boot.tuCV.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CvInitializationServiceImpl implements CvInitializationService{

    @Override
    public CvData initilizeCvData() {
        CvData cvData = new CvData();

        //Datos personales
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName("Gabriel");
        personalDetails.setLastName("Chaldú");
        personalDetails.setEmail("gabriel@gmail.com");
        personalDetails.setProfessionalProfile("Desarrollador Backend");

        cvData.setPersonalDetails(personalDetails);

        //Educación

        Education education1 = new Education();
        education1.setInstitution("University of Example");
        education1.setDescription("Description...");
        education1.setDegree("Bachelor of Science in Computer Science");
        education1.setPeriod("2010 - 2014");

        cvData.setEducations(Collections.singletonList(education1));

        //Experiencia
        Experience experience1 = new Experience();
        experience1.setJobTitle("Senior Developer");
        experience1.setCompany("DevTalles Corp.");
        experience1.setPeriod("2016 - Present");

        cvData.setExperiences(List.of(experience1));

        //Habilidades

        Skill skill1 = new Skill();
        skill1.setName("Java");
        skill1.setLevel("Advanced");

        Skill skill2 = new Skill();
        skill2.setName("Spring Framework");
        skill2.setLevel("Advanced");

        cvData.setSkills(Arrays.asList(skill1, skill2));

        return cvData;
    }
}
