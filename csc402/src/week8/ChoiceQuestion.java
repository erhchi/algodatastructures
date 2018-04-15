package week8;

import java.util.ArrayList;

/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question {
   private ArrayList<Question> choices;

   
   /**
      Constructs a choice question with no choices.
   */
   public ChoiceQuestion() {
      choices = new ArrayList<Question>();
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct) {
	  Question q = new Question(choice, String.valueOf(correct));
      choices.add(q);
      if(correct == true){
    	  this.setAnswer(String.valueOf(choices.indexOf(q)+1));
      }
   }
   
   //overriding the base display()
   public void display() {
	   System.out.println(this.getQuestion());
	   int i = 1;
	   for(Question choice : choices){
		   System.out.print(String.valueOf(i++) + ": ");
		   choice.display();
	   }
   }
}

