/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.scrappers;

import com.jaunt.util.MultiMap;
import static com.jotase.jobsearcher.configs.Credentials.PROVERSITY_PASSWORD;
import static com.jotase.jobsearcher.configs.Credentials.PROVERSITY_USERNAME;
import com.jotase.jobsearcher.interfaces.ScrapperInterface;

/**
 *
 * @author JotaSe
 */
public class ProversityScrapper extends Base implements ScrapperInterface{

    public ProversityScrapper() {
        setLoginUrl("http://learn.proversity.org/login");
        setUrl("http://www.proversity.org/es/university/SUP/job-portal/");
        
        // TO DO: login params should be stored or given by client
        MultiMap loginParams = new MultiMap();
        loginParams.put("email", PROVERSITY_USERNAME);
        loginParams.put("password", PROVERSITY_PASSWORD);
        page = login(loginParams);
    }

    @Override
    public void searchJobs(MultiMap params) {
        page = executeAction(POST, url, params, null);
    }

    @Override
    public void extractAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MultiMap getDefaultParams(){
        return null;
    }
    
    public MultiMap getDeveloperOnlyParams(){
        MultiMap params = new MultiMap();
        params.put("tag", "developer");
        
        return params;
    }
            
    
}
