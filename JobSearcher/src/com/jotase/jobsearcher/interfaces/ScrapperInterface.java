/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.interfaces;

import com.jaunt.util.MultiMap;

/**
 *
 * @author JotaSe
 */
public interface ScrapperInterface {
    public void searchJobs(MultiMap params);
    public void extractAttributes();
}
