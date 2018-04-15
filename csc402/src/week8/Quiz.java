package week8;

import java.util.ArrayList;
import java.util.Scanner;

/**
   A quiz contains a list of questions.
*/
public class Quiz {
   private ArrayList<Question> questions;
   
   /**
      Constructs a quiz with no questions.
   */
   public Quiz() {
      questions = new ArrayList<Question>();
   }

   /**
      Adds a question to this quiz.
      @param q the question
   */
   public void addQuestion(Question q) {
      questions.add(q);
   }

   /**
      Presents the questions to the user and checks the response.
   */
   public void presentQuestions() {
       
	   Scanner console = new Scanner(System.in);
	   
	   //loop through each question
	   for(Question q : questions){
		   q.display();
	       System.out.print("Your answer:");
	       String choice = console.nextLine();
	       
	       if(q.checkAnswer(choice) == true){
	    	 System.out.println("True");
	       }
	       else{
	    	 System.out.println("False");
	    	 System.out.println("The correct answer is: " + q.getAnswer());
	       }
	   }
	   
	   System.out.print("Play again (Y/N)?");
	   if(Character.toString(console.nextLine().charAt(0)).compareToIgnoreCase("y") == 0){
		   presentQuestions();
	   }
	   
   }
}

