import java.util.ArrayList;

public class QuestionMC extends Question {

    private ArrayList<String> multipleChoices = new ArrayList<String>();

    public QuestionMC() {
        this.answer = "";
        this.text = "";
        this.correct = false;
    }

    public QuestionMC(String answer, String text, String choices) {
        this.answer = answer;
        this.text = text;
        String[] choiceArray = choices.split(":");

        for (int i = 0; i < choiceArray.length; i++) {
            multipleChoices.add(choiceArray[i]);
        }
        this.correct = false;
    }

    @Override
    public void showQuestion() {
        char letter = 'a';
        System.out.println(text + "? (Multiple Choice)");
        for (int i = 0; i < multipleChoices.size(); i++) {
            System.out.println("    " + letter + ". " + multipleChoices.get(i));
        }
    }

}
