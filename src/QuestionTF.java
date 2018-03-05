
public class QuestionTF extends Question {

    public QuestionTF() {
        this.answer = "";
        this.text = "";
        this.correct = false;
    }

    public QuestionTF(String answer, String text) {
        this.answer = answer;
        this.text = text;
        this.correct = false;
    }

    @Override
    public void showQuestion() {
        System.out.println(text + "? (True/False)");
    }
}
