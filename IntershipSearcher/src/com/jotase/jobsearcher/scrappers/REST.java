/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.jobsearcher.scrappers;

import com.jaunt.Document;
import com.jaunt.ResponseException;
import java.util.HashMap;

/**
 *
 * @author JotaSe
 */
public interface REST {
    public Document executeAction(int Action, String url, HashMap params, HashMap headers);
    public Document post(String url, String params, String headers) throws ResponseException;
    public Document get(String url, String headers) throws ResponseException;
    public Document put(String url, String params, String headers) throws ResponseException;
    public Document delete(String url, String headers) throws ResponseException;
}
