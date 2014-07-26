/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.abj2014.intro.spring.data.before;

import com.jcertif.abj2014.intro.spring.data.AbstractTest;
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
public class SpeakerServiceTest extends AbstractTest{
     
	@Autowired SpeakerService repository;

	@Test
	public void findsAllSpeakers() throws Exception {

		List<Speaker> result = repository.findAll();

		assertThat(result, is(notNullValue()));
		assertFalse(result.isEmpty());
	}

	@Test
	public void findsPageOfInnocent() throws Exception {

		List<Speaker> speakers = repository.findByLastname("Innocent", 0, 2);

		assertThat(speakers.size(), is(2));
	}

	@Test
	public void findsSpeakerById() throws Exception {

		Speaker speaker = repository.findById(2L);

		assertThat(speaker.getFirstname(), is("Max"));
		assertThat(speaker.getLastname(), is("Bonbhel"));
	}
    
}
