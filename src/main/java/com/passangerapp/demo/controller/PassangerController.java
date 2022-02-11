package com.passangerapp.demo.controller;

import com.passangerapp.demo.entity.Passanger;
import com.passangerapp.demo.service.PassangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/passanger")
@RestController
public class PassangerController {

    @Autowired
    private PassangerService passangerService;
    private Passanger passanger = new Passanger();

    @RequestMapping(method = RequestMethod.POST)
    public String createPassanger(@RequestBody Passanger passanger){
        return passangerService.addPassanger(passanger);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Passanger> readPassangers(){
        return passangerService.readStudents();
    }


    @RequestMapping(value="/{passportId}",method = RequestMethod.GET)
    public Passanger getPassanger(@PathVariable("passportId") int passportId){
        return passangerService.GetOnlyOnePassanger(passportId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updatePassanger(@RequestBody Passanger passanger){
        return passangerService.updatePassanger(passanger);
    }

    @RequestMapping(value="/{passportId}",method = RequestMethod.DELETE)
    public String deletePassanger(@PathVariable("passportId") int passportId){
        return passangerService.deletePassanger(passportId);
    }
}
