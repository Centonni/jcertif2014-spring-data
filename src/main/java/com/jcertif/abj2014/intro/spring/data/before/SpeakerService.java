/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.abj2014.intro.spring.data.before;

import com.jcertif.abj2014.intro.spring.data.model.Speaker;
import java.util.List;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
public interface SpeakerService {
    /**
	 * Returns the {@link Speaker} with the given id or {@literal null} if no {@link Speaker} with the given id was
	 * found.
	 * 
	 * @param id
	 * @return
	 */
	Speaker findById(Long id);

	/**
	 * Saves the given {@link Speaker}.
	 * 
	 * @param speaker
	 * @return
	 */
	Speaker save(Speaker speaker);

	/**
	 * Returns all speakers.
	 * 
	 * @return
	 */
	List<Speaker> findAll();

	/**
	 * Returns the page of {@link Speaker}s with the given index of the given size.
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Speaker> findAll(int page, int pageSize);

	/**
	 * Returns the page of {@link Speaker}s with the given lastname and the given page index and page size.
	 * 
	 * @param lastname
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Speaker> findByLastname(String lastname, int page, int pageSize);
}
