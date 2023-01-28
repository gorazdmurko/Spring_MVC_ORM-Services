package org.example.spring.springmvcorm.user.services.impl;

import org.example.spring.springmvcorm.user.dao.IPersonDao;
import org.example.spring.springmvcorm.user.entity.Person;
import org.example.spring.springmvcorm.user.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    public IPersonDao dao;


    @Override
    @Transactional // it is always a good practice to have @Transactional at SERVICES LAYER (we could add it to create method in IUserDao interface)
    public int savePerson(Person person) {
        return dao.create(person);    // invokes the HibernateTemplate method create() which saves the model object into DB table
    }
}
