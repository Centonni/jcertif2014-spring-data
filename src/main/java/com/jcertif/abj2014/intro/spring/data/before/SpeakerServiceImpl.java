/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.abj2014.intro.spring.data.before;

import com.jcertif.abj2014.intro.spring.data.model.Speaker;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
@Repository
@Transactional(readOnly = true)
public class SpeakerServiceImpl implements SpeakerService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Speaker findById(Long id) {
        return em.find(Speaker.class, id);
    }

    @Override
    @Transactional
    public Speaker save(Speaker speaker) {
        // un nouveau?
        if (speaker.getId() == null) {
            em.persist(speaker);
            return speaker;
        } else {
            return em.merge(speaker);
        }
    }

    @Override
    public List<Speaker> findAll() {
        return em.createQuery("select s from Speaker s", Speaker.class).getResultList();
    }

    @Override
    public List<Speaker> findAll(int page, int pageSize) {
        TypedQuery<Speaker> query = em.createQuery("select s from Speaker s", Speaker.class);

        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public List<Speaker> findByLastname(String lastname, int page, int pageSize) {
        TypedQuery<Speaker> query = em.createQuery("select s from Speaker s where s.lastname = ?1", Speaker.class);

        query.setParameter(1, lastname);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

}
