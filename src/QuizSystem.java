import java.util.ArrayList;
import java.util.Scanner;

public class QuizSystem {
    static class Question {
        String questionText;
        String[] options;
        int correctAnswer;

        Question(String questionText, String[] options, int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    static ArrayList<Question> questions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        initializeQuestions();
        displayWelcomeMessage();
        runQuiz();
        displayResults();
    }

    static void initializeQuestions() {
        questions.add(new Question(
                "What is the capital of France?",
                new String[]{"1. Paris", "2. London", "3. Berlin", "4. Madrid"},
                1
        ));
        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"1. Jupiter", "2. Mars", "3. Venus", "4. Mercury"},
                2
        ));
        questions.add(new Question(
                "What is 2 + 2?",
                new String[]{"1. 3", "2. 4", "3. 5", "4. 6"},
                2
        ));
        questions.add(new Question(
                "Which language is used to create Android apps?",
                new String[]{"1. Python", "2. Java", "3. C++", "4. PHP"},
                2
        ));
        questions.add(new Question(
                "What is the largest mammal?",
                new String[]{"1. Elephant", "2. Blue Whale", "3. Giraffe", "4. Lion"},
                2
        ));
    }

    static void displayWelcomeMessage() {
        System.out.println("Welcome to the Online Quiz System!");
        System.out.println("Answer the following 5 questions by entering the option number (1-4).");
        System.out.println("Let's get started!\n");
    }

    static void runQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Your answer (1-4): ");
            int userAnswer = getValidInput();
            if (userAnswer == q.correctAnswer) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer was: " + q.correctAnswer + "\n");
            }
        }
    }

    static int getValidInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 4) {
                    return input;
                } else {
                    System.out.print("Please enter a number between 1 and 4: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number between 1 and 4: ");
            }
        }
    }

    static void displayResults() {
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());
        double percentage = (score * 100.0) / questions.size();
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Excellent performance!");
        } else if (percentage >= 60) {
            System.out.println("Good job!");
        } else {
            System.out.println("Keep practicing!");
        }
    }
}