package votecounting;

import spark.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;
/**
 * Method to count votes
 * Votes are currently simulated in the constructor, however this can be changed.
 */
public class Countmeup {
    Votes votes = new Votes();
    Random rand = new Random();
    int votesCast = 10000000;
    int candidates = 6;
    int voters = 3333333;

    public static void main (String[] args){
        staticFileLocation("/public");
        Countmeup countmeup = new Countmeup();
        countmeup.getVoteCount();

        //home
        get("/", (request, response) -> {
            Map model = new HashMap();
            model.put("template", "templates/count.vtl" );
            Map<Integer, Integer> results = countmeup.getVoteCount();
            model.put("hashmap", results);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

    /* Creates test data */
    public Countmeup(){
        for(int i = 0; i < votesCast; i++){
            int voter = rand.nextInt(voters) + 1;
            int candidate = rand.nextInt(candidates) + 1;
            votes.addVote(voter, candidate);
        }
    }

    /* Prints summarised votes */
    public Map<Integer, Integer> getVoteCount(){
        Map<Integer, Integer> results = votes.getVotes();
        //ArrayList<Integer, Integer> resultsArray = new ArrayList<Integer, Integer>(results.entrySet());
        /*for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/

        return votes.getVotes();
        //System.out.println(votes.toString());
    }
}
