/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.models;

import java.lang.reflect.Array;

/**
 *
 * @author JotaSe
 */
public class Metadata {
    private Array technicalSkills;
    private Array tags;

    public Array getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(Array technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public Array getTags() {
        return tags;
    }

    public void setTags(Array tags) {
        this.tags = tags;
    }
    
    
}
