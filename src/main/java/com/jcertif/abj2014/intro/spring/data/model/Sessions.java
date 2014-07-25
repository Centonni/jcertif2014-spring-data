/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.abj2014.intro.spring.data.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
@Entity
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @ManyToOne
    private Speaker speaker;

    @Temporal(TemporalType.DATE)
    private Date sessionDate;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Date getSessionDate() {
        return sessionDate;
    }
    
    

}
