/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.abj2014.intro.spring.data.before;

import com.jcertif.abj2014.intro.spring.data.model.Sessions;
import com.jcertif.abj2014.intro.spring.data.model.Speaker;
import java.util.List;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
public interface SessionsService {
    /**
	 * Saves the given {@link Sessions}.
	 * 
	 * @param session
	 * @return
	 */
	Sessions save(Sessions session);

	/**
	 * Returns all {@link Sessions}s of the given {@link Speaker}.
	 * 
	 * @param speaker
	 * @return
	 */
	List<Sessions> findBySpeaker(Speaker speaker);
}
