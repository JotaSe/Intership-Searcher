/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.scrappers;

import com.jotase.jobsearcher.interfaces.REST;
import com.jaunt.Document;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jotase.jobsearcher.models.Job;
import com.jaunt.util.MultiMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JotaSe
 */
public class Base implements REST{
    final int POST = 0;
    final private int GET = 1;
    final private int PUT = 2;
    final private int DELETE = 3;
    final private UserAgent agent = new UserAgent();
    Document page;
    String url;
    private String loginUrl;
    private List<Job> jobs;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
    
    public Document login(MultiMap loginParams){
        return loginParams.size() == 0 ? null : executeAction(POST, loginUrl, loginParams, null);
    }
    
    private String parseParams(MultiMap params){
        StringBuilder paramsString = new StringBuilder();
        paramsString.append('?');
        paramsString.append(params.toString("=", "&", false, ""));
        return paramsString.toString();
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
        page = executeAction(GET, url, null, null);
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
    
    private String hashExist(MultiMap hash){
        return hash.size() == 0 ? "" : parseParams(hash);
    }

    @Override
    public Document executeAction(int Action, String url, MultiMap params, MultiMap headers){
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
