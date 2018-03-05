
public abstract class Question {

    String text;
    String answer;
    boolean correct = false;

    public abstract void showQuestion();

    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
        this.correct = false;
    }

    public Question() {
        text = "";
        answer = "";
        correct = false;
    }

    public void markCorrect() {
        correct = true;
    }

    public boolean isCorrect() {
        return correct;
    }

    public boolean checkAnswer(String givenAnswer) {
        String formattedText = givenAnswer.toLowerCase();
        String formattedAnswer = answer.toLowerCase();

        if (formattedText == "true" || formattedText == "t") {
            formattedText = "true";
        } else if (formattedText == "false" || formattedText == "f") {
            formattedText = "false";
        }

        if (formattedText == formattedAnswer) {
            return true;
        } else {
            return false;
        }
    }
}
