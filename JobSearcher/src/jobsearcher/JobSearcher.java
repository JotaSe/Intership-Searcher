/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobsearcher;

import com.jaunt.util.MultiMap;

/**
 *
 * @author JotaSe
 */
public class JobSearcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JobSearcher jobSearcher = new JobSearcher();
        jobSearcher.testParseParams();
    }
    
    public void testParseParams(){
        MultiMap params = new MultiMap();
        params.put("asdasd", "asdasd");
        params.put("34534", "34534");
        System.out.println(params.toString("=","&", false, ""));
    }
}
