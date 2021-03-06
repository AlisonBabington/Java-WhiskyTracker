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



    //TODO:    get all the distilleries for a particular region
    @Transactional
    public List<Distillery> getAllDistileriesFromRegion(String region) {
        List<Distillery> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            System.out.println(cr.list());
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;


    }

    //TODO: get distilliries that have whiskies of certain age

    @Transactional
    public List<Distillery> getDistilleriesThatHaveWhiskyAt(int age) {
        List<Distillery> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whisky");
            cr.add(Restrictions.eq("whisky.age", age));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}


