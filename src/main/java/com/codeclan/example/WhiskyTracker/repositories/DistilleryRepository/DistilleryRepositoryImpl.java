package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    @Transactional
//    public List<Pirate> getAllPiratesForShip(Long shipID) {
//
//        List<Pirate> results = null;
//
//        Session session = entityManager.unwrap(Session.class);
//        try {
//            Criteria criteria = session.createCriteria(Pirate.class);
//            //similar to SELECT from pirates
//
//            criteria.add(Restrictions.eq("ship.id", shipID));
//            //similar to WHERE ship = ship
//
//            results = criteria.list();
//            //putting criteria enquiry results into a list to return
//            //cr.uniqueResult(returns one result)
//
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;

    //TODO:   get all the whisky from a particular region
    @Transactional
    public List<Whisky> getAllWhiskiesFromRegion(String region) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "d");
            cr.add(Restrictions.eq("d.region", region));
            System.out.println(cr.list());
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}
