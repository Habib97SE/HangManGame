package HangMan;

public class Word
{
    private String word;

    public Word (String word)
    {
        this.word = word;
    }

    public String getWord ()
    {
        return word;
    }

    public void setWord (String word)
    {
        this.word = word;
    }

    public boolean matchLetter (char letter)
    {
        return this.getWord().indexOf(letter) >= 0;
    }

    public void replaceLetter (char oldLetter, char newLetter)
    {
        String newWord = this.getWord().replace(oldLetter, newLetter);
        this.setWord(newWord);
    }

    @Override
    public String toString ()
    {
        return this.word;
    }
}