package votecounting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Maps voter to candidate
public class Votes {
    Map<Integer, Vote> votes;

    public Votes(){
        votes = new HashMap<Integer, Vote>();
    }

    public void addVote(int voter, int candidate){
        if(votes.containsKey(voter)){
            votes.get(voter).addVote(candidate);
        } else {
            Vote vote = new Vote();
            vote.addVote(candidate);
            votes.put(voter, vote);
        }
    }

    public String toString(){
        String toReturn ="";

        for (Map.Entry<Integer, Vote> entry : votes.entrySet()){
            toReturn = toReturn + entry.getKey() + "-" + entry.getValue().toString() + "\r\n";
        }

        return toReturn;
    }

    public Map<Integer, Integer> getVotes(){
        //Map candidate to their number of votes
        Map<Integer, Integer> results = new HashMap<Integer, Integer>();

        //for each voter
        for (Map.Entry<Integer, Vote> entry : votes.entrySet()){
            List<Integer> validVotes = entry.getValue().getnVotes(3);
            for(int vote : validVotes){
                if(results.containsKey(vote)){
                    results.put(vote, results.get(vote) + 1);
                } else {
                    results.put(vote, 1);
                }
            }
        }
        
        return results;
    }
}
