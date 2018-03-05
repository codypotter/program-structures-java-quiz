
public class QuizApp {

    public static void main(String[] args) throws Exception {
        boolean quit = false;

        if (args[0] != "") {
            Quiz quiz = new Quiz(args[0]);
            quiz.deliverQuiz();
        } else {
            System.out.println("Invalid argument. Usage: java quiz [datafile] ");
        }

        //while (!quit) {
            //TODO run quiz
        //}

    }
}
