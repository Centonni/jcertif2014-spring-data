/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.abj2014.intro.spring.data.before;

import com.jcertif.abj2014.intro.spring.data.AbstractTest;
import com.jcertif.abj2014.intro.spring.data.model.Sessions;
import com.jcertif.abj2014.intro.spring.data.model.Speaker;
import java.util.List;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
public class SessionsServiceTest extends AbstractTest{

    @Autowired
    SessionsService sessionService;
    @Autowired
    SpeakerService speakerService;

    @Test
    public void savesSessions() {

        Sessions session = sessionService.save(new Sessions());
        assertThat(session.getId(), is(notNullValue()));
    }

    @Test
    public void testName() throws Exception {

        Speaker speaker = speakerService.findById(1L);

        List<Sessions> sessions = sessionService.findBySpeaker(speaker);

        assertThat(sessions, is(not(empty())));
        assertThat(sessions.get(0).getSpeaker(), is(speaker));
    }
}
