/* Mohammad Ali Dosi
 * Dr. Steinberg
 * COP3330 Spring 2022
 * Programming Assignment 2
 */
public class TextAnalysis {
    private String data []; // holds the text
    private int alphabet[]  = new int [26];  // stores the number of times a letter occurs in data
    private int wordsize[]  = new int [15];  // stores the size of each words
    private int wordcount[] = new int [30];  // stores the number of words per sentence
    private int limit; // stores the max number of sentences to observe for the class
    public TextAnalysis(int limit, String[] data )
    {
        this.limit = limit ;
        this.data = data ;
    }
    // accessor method for limit
    public int getlimit()
    {
        return limit;
    }
    // accessor method for string
    public String[] getdata()
    {
        return data;
    }
    // display the text
    public void display()
    {
        for(int i=0; i< data.length ; i++)
            System.out.println(data[i]);

    }
    // display the count result
    public void tableDisplay()
    {
        System.out.println("Letter \t Count");
        for(int i=0; i<26; i++)
        {
            System.out.println( Character.toString((char)(65+i)) + "\t " + String.valueOf(alphabet[i]) );
        }
        System.out.println("---------------------------------");
        System.out.println("Word Length \tOccurances");
        for(int i=0; i<15; i++)
        {
            System.out.println( i+1 + " \t\t" + String.valueOf(wordsize[i]) );
        }
        System.out.println("---------------------------------");
        System.out.println("Sentence Length \tOccurances");
        for(int i=0; i< 30; i++)
        {
            System.out.println( i+1 + " \t\t\t" + String.valueOf(wordcount[i]) );
        }

    }
    public void letterAnalysis()
    {
        int i;
        int j;
        for(i=0; i < data.length; i++)
        {
            for (j = 0; j < data[i].length(); j++) {
                Character Current_char = data[i].charAt(j);
                Current_char= Character.toLowerCase(Current_char);
                if ((int) Current_char > 96 && (int) Current_char < 123) {
                    alphabet[Current_char - 97]++;
                }
            }
        }
    }
    public void wordAnalysis()
    {
        int i;
        int j = 0;
        for(i=0; i < data.length; i++)
        {
            // split the sentence into seprate words
           String[] Current_Word = data[i].split("\\s+|-{2,}");
            for(j=0; j<Current_Word.length; j++){
                // getting rid of everything except the characters
                if(!Current_Word[j].matches("[a-zA-Z]")){
                    Current_Word[j]= Current_Word[j].replaceAll("[^a-zA-Z]","");
                }
                // update the count if we have any characters in the word
                if(Current_Word[j].length() > 0){
                    wordsize[Current_Word[j].length()-1 ]++;
                }
            }
        }
    }
    public void wordAnalysis(int num)
    {
        // return if num is not a valid number
        if(num < 0 || num > limit)
        {
            System.out.println("Exceeded and cannot produce an analysis on this component.");
            return;
        }
        int i=0;
        for(i=0; i < num; i++)
        {
            System.out.println(data[i]);
            // getting rid of everything except the characters
            data[i]= data[i].replaceAll("[^a-zA-Z\\s]", "");
            String[] t = data[i].split("\\s+");
            // update the count accordingly
            wordcount[t.length-1]++ ;
        }

    }

}



