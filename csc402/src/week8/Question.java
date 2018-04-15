package week8;
/**
   A question with a text and an answer.
*/
public class Question {
   private String text;
   private String answer;

   /**
      Constructs a question with empty question and answer.
   */
   public Question() {
      text = "";
      answer = "";
   }
   
   public Question(String questionText, String answerText){
	   text = questionText;
	   answer = answerText;
   }

   /**
      Sets the question text.
      @param questionText the text of this question
   */
   public void setText(String questionText) {
      text = questionText;
   }
   
   public String getQuestion(){
	   return this.text;
   }

   /**
      Sets the answer for this question.
      @param correctResponse the answer
   */
   public void setAnswer(String correctResponse) {
      answer = correctResponse;
   }
   
   public String getAnswer(){
	   return this.answer;
   }

   /**
      Checks a given response for correctness.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response) {
	   if(response.toLowerCase().compareTo(answer.toLowerCase()) == 0){
		   return true;
	   }else{
		   return false;
	   }
   }

   /**
      Displays this question.
   */
   public void display() {
	   System.out.println(text);
   }
   

}
