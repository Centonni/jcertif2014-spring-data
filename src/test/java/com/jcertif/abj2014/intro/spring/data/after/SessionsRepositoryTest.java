/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.abj2014.intro.spring.data.after;

import com.jcertif.abj2014.intro.spring.data.AbstractTest;
import com.jcertif.abj2014.intro.spring.data.model.Sessions;
import com.jcertif.abj2014.intro.spring.data.model.Speaker;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
public class SessionsRepositoryTest extends AbstractTest {

    @Autowired
    SessionsRepository sessionRepository;
    @Autowired
    SpeakerRepository speakerRepository;

    @Test
    public void savesSessions() {

        Sessions session = sessionRepository.save(new Sessions());
        assertThat(session.getId(), is(notNullValue()));
    }

    @Test
    public void findsSpeakersSessionss() {

        Speaker speaker = speakerRepository.findOne(3L);
        List<Sessions> sessions = sessionRepository.findBySpeaker(speaker);

        assertFalse(sessions.isEmpty());
        assertThat(sessions.get(0).getSpeaker(), is(speaker));
    }

}
