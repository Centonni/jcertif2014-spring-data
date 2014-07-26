/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.abj2014.intro.spring.data.after;

import com.jcertif.abj2014.intro.spring.data.model.Speaker;
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
public interface SpeakerRepository extends CrudRepository<Speaker, Long>{
    
    Page<Speaker> findByLastname(String lastname, Pageable pageable);
}
