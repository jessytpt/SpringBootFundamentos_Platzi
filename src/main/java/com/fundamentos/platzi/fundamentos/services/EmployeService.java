package com.fundamentos.platzi.fundamentos.services;

import com.fundamentos.platzi.fundamentos.entity.Employe;
import com.fundamentos.platzi.fundamentos.repository.EmployeRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeService {
    private final Log LOG = LogFactory.getLog(EmployeService.class);

    @Autowired
    private EmployeRepository employeRepository;

    @Transactional
    public void  saveTransactional(List<Employe> employes){
        employes.stream()
                .peek(employe -> LOG.info("usuario insertado "+employe))
                .forEach(employe -> employeRepository.save(employe));

    }

    public List<Employe> getAllEmployes(){
        return employeRepository.findAll();
    }


}
