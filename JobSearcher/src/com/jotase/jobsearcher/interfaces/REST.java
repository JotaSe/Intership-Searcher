/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.interfaces;

import com.jaunt.Document;
import com.jaunt.ResponseException;
import com.jaunt.util.MultiMap;

/**
 *
 * @author JotaSe
 */
public interface REST {
    public Document executeAction(int Action, String url, MultiMap params, MultiMap headers);
    public Document post(String url, String params, String headers) throws ResponseException;
    public Document get(String url, String headers) throws ResponseException;
    public Document put(String url, String params, String headers) throws ResponseException;
    public Document delete(String url, String headers) throws ResponseException;
}
