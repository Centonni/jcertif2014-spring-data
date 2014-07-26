/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.abj2014.intro.spring.data.before;

import com.jcertif.abj2014.intro.spring.data.model.Sessions;
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
public class SessionsServiceImpl implements SessionsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Sessions save(Sessions session) {
        if (session.getId() == null) {
            em.persist(session);
            return session;
        } else {
            return em.merge(session);
        }
    }

    @Override
    public List<Sessions> findBySpeaker(Speaker speaker) {
        TypedQuery<Sessions> query = em.createQuery("select s from Sessions s where s.speaker = ?1", Sessions.class);
        query.setParameter(1, speaker);

        return query.getResultList();
    }

}
