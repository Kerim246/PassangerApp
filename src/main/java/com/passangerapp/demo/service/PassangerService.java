package com.passangerapp.demo.service;

import com.passangerapp.demo.repository.PassangerRepository;
import com.passangerapp.demo.entity.Passanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassangerService {

    @Autowired
    private PassangerRepository passangerRepository;

    @Transactional
    public String addPassanger(Passanger passanger) {
        try {
            if (!passangerRepository.existsByPassportId(passanger.getPassportId())) {
                passanger.setId(null == passangerRepository.findMaxId() ? 0 : passangerRepository.findMaxId() + 1);
                passangerRepository.save(passanger);
                return "Passanger record created successfully.";
            } else {
                return "Passanger already exists in the database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Passanger> readStudents() {
        return passangerRepository.findAll();
    }

    @Transactional
    public String updatePassanger(Passanger passanger) {
        if (passangerRepository.existsByPassportId(passanger.getPassportId())) {
            try {
                Passanger passanger1 = passangerRepository.findByPassportId(passanger.getPassportId());
                Passanger passangerToBeUpdate = passangerRepository.findById(passanger1.getId()).get();
                if (passanger.getFirstName() != null)
                    passangerToBeUpdate.setFirstName(passanger.getFirstName());
                if (passanger.getLastName() != null)
                    passangerToBeUpdate.setLastName(passanger.getLastName());
                if (passanger.getEmailAdress() != null)
                    passangerToBeUpdate.setEmailAdress(passanger.getEmailAdress());
                passangerToBeUpdate.setPassportId(passanger.getPassportId());

                passangerRepository.save(passangerToBeUpdate);
                return "Passanger record updated.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Passanger does not exists in the database.";
        }
    }

    @Transactional
    public String deletePassanger(int passportId) {
        if (passangerRepository.existsByPassportId(passportId)) {
            try {
                Passanger passanger1 = passangerRepository.findByPassportId(passportId);
            //    System.out.println("Passs " + passanger1.getFirstName());
                passangerRepository.delete(passanger1);
                return "Passanger record deleted successfully.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Passanger does not exist";
        }
    }

    @Transactional
    public Passanger GetOnlyOnePassanger(int passportId) {
        if (passangerRepository.existsByPassportId(passportId)) {
            try {
                Passanger passanger1 = passangerRepository.findByPassportId(passportId);
                return passanger1;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }
}
