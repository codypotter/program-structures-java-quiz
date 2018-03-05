
public class QuestionSA extends Question {

    public QuestionSA() {
        this.answer = "";
        this.text = "";
        this.correct = false;
    }

    public QuestionSA(String answer, String text) {
        this.answer = answer;
        this.text = text;
        this.correct = false;
    }

    @Override
    public void showQuestion() {
        System.out.println(this.text + "? (Short Answer)");
    }
}

