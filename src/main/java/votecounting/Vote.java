package votecounting;
import java.util.ArrayList;
import java.util.List;

//Stores a list of votes made by particular user
public class Vote {
    List<Integer> candidate;

    public Vote(){
        candidate = new ArrayList<Integer>();
    }

    public List<Integer> getnVotes(int limit){
        if (candidate.size() < limit ) {
            return candidate;
        } else {
            //System.out.println("Limit");
            return candidate.subList(0, limit);
        }

    }

    public void addVote(int candidateVoted){
        candidate.add(candidateVoted);
    }

    public String toString(){
        String toReturn ="";

        for(int i: candidate){
            toReturn = toReturn + i + ",";
        }
        return toReturn;
    }
}
