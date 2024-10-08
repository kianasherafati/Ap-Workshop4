import java.util.*;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getChoices() {
        return new ArrayList<>(choices.keySet());
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void createChoice(String choice){
        choices.put(choice, new HashSet<>());
    }

    public void Vote(Person voter, ArrayList<String> voter_choices){
        if (!voters.contains(voter))
            voters.add(voter);
        for (String vote_choice : voter_choices) {
            choices.get(vote_choice).add(new Vote(voter, "2023/4/9"));
        }
    }

    public void Vote(Person person) {
        if (!voters.contains(person))
            voters.add(person);

        String selectedChoice = getChoices().get(new Random().nextInt() % getChoices().size());
        choices.get(selectedChoice).add(new Vote(person, "2023/4/9"));
    }

    public void printResult(){
        ArrayList<String>_choices = getChoices();
        for (String choice : _choices){
            Iterator<Vote> votes = choices.get(choice).iterator();
            ArrayList<Vote> submittedVotes = new ArrayList<>();
            while (votes.hasNext()){
                submittedVotes.add(votes.next());
            }
            System.out.println("\tChoice "+ choice + "\n" + submittedVotes);
        }
    }
    public  void printVoters(){
        System.out.println(voters);
    }
}
