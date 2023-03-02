package HangMan;

import HangMan.Word;

import java.util.ArrayList;
import java.util.Random;


public class WordList
{
    private ArrayList<Word> wordsList = new ArrayList<>();

    public WordList (ArrayList<String> words)
    {
        for (String word : words)
            this.wordsList.add(new Word(word));
    }

    public void setWordsList (ArrayList<Word> wordsList)
    {
        this.wordsList = wordsList;
    }

    public ArrayList<Word> getWordsList ()
    {
        return this.wordsList;
    }

    public String randomWord ()
    {
        Random rand = new Random();
        int randomChoice = rand.nextInt(wordsList.size());
        return this.wordsList.get(randomChoice).toString();
    }


    public boolean contains (Word word)
    {
        return this.wordsList.contains(word);
    }

    public boolean contains (String word)
    {
        return this.contains(new Word(word));
    }


    public void addword (Word word)
    {
        this.wordsList.add(word);
    }

    public void addword (String word)
    {
        this.addword(new Word(word));
    }

    public Word removeWord (Word word)
    {
        int index = this.wordsList.indexOf(word);
        return this.wordsList.remove(index);
    }

    public Word removeWord (String word)
    {
        Word newWord = new Word(word);
        return removeWord(word);
    }
}
