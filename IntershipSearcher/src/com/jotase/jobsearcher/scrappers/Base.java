/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.scrappers;

import com.jaunt.Document;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jotase.jobsearcher.models.Job;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JotaSe
 */
public class Base implements REST{
    final private int POST = 0;
    final private int GET = 1;
    final private int PUT = 2;
    final private int DELETE = 3;
    final private UserAgent agent = new UserAgent();
    private Document page;
    private String url;
    private String loginUrl;
    private List<Job> jobs;
    
    public Document login(HashMap loginParams){
        return executeAction(POST, loginUrl, loginParams, null);
    }

    private String parseParams(HashMap params){
        return "";
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Document getPage() {
        return page;
    }

    public void setPage(Document page) {
        this.page = page;
    }

    @Override
    public Document post(String url, String params, String headers) throws ResponseException{
        return headers.isEmpty() ? agent.sendPOST(url, params) : agent.sendPOST(url, headers, headers);
    }

    @Override
    public Document get(String url, String headers) throws ResponseException {
        return headers.isEmpty() ? agent.sendGET(url) : agent.sendGET(url, headers);
    }

    @Override
    public Document put(String url, String params, String headers) throws ResponseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Document delete(String url, String headers) throws ResponseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String hashExist(HashMap hash){
        return hash.isEmpty() ? "" : parseParams(hash);
    }

    @Override
    public Document executeAction(int Action, String url, HashMap params, HashMap headers){
        try {
            String paramsString = hashExist(params);
            String headersString = hashExist(headers);
            
            switch(Action){
                case POST: return post(url, paramsString, headersString);
                case PUT: return put(url, paramsString, headersString);
                case GET: return get(url, headersString);
                case DELETE: return delete(url, headersString);
            }
        } catch (ResponseException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}
