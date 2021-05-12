package com.pranay.springboot.virtusademo.rest;

import java.util.List;
import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.springboot.virtusademo.dao.LogmodelDAO;
import com.pranay.springboot.virtusademo.entity.Logmodel;

@RestController
@RequestMapping("/api")
public class LogmodelRestController {
	private LogmodelDAO logmodelDAO;
	@Autowired
	public LogmodelRestController(LogmodelDAO theLogmodelDAO) {
		logmodelDAO=theLogmodelDAO;
	}
	@GetMapping("/getAllLog")
	public List<Logmodel> findAll(){
		return logmodelDAO.findAll();
	}
	@GetMapping("/checkIn")
	public void getEntryIn(@RequestParam String name) {
		LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        String date="";
        date=date+localDate;
        String time="";
        time=time+localTime;
        String idee="";
        idee=idee+name+" "+time;
        String n=name;
	    Logmodel lm=new Logmodel(n,"IN",date,time);
	    lm.setId(idee);
	    logmodelDAO.saveit(lm);
	    
	}
	@GetMapping("/checkOut")
	public void getEntryOut(@RequestParam String name) {
		LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        String date="";
        date=date+localDate;
        String time="";
        time=time+localTime;
        String idd="";
        idd=idd+name+" "+time;
	     Logmodel lm=new Logmodel(name,"OUT",date,time);
	     lm.setId(idd);
	     logmodelDAO.saveit(lm);
	}
	@GetMapping("/getLog")
	public List<Logmodel> getDatEntry(@RequestParam String date) {
		
        return logmodelDAO.findByDate(date);
	     
	}
}
