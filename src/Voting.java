import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, HashMap<String, HashSet<Vote>> choices, boolean isAnonymous, ArrayList<Person> voters) {
        this.type = type;
        this.question = question;
        this.choices = choices;
        this.isAnonymous = isAnonymous;
        this.voters = voters;
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

    public void Vote(Person person){
        if (!voters.contains(person))
            voters.add(person);
    }
}
