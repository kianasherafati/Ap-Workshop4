import java.util.ArrayList;
import java.util.Objects;

public class VotingSystem {
   private ArrayList<Voting> votingList;

   public VotingSystem(ArrayList<Voting> votingList) {
      this.votingList = votingList;
   }

   ArrayList<Voting> getVotingList() {
      return votingList;
   }

   Voting getVoting(int index){
      return votingList.get(index);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      VotingSystem that = (VotingSystem) o;
      return Objects.equals(votingList, that.votingList);
   }

   @Override
   public int hashCode() {
      return Objects.hash(votingList);
   }

   void vote(int index, Person person){
      votingList.get(index).Vote(person);
   }

   void vote(int index, Person person, ArrayList<String> options){
      votingList.get(index).Vote(person,options);
   }

   void creatVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices){
      votingList.add(new Voting(type, question, isAnonymous));
   }

}
