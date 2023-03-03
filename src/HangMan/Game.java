package HangMan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * HangMan.Game-klassen hanterar spelet och att relgerna följs på ett korrekt sätt.
 *
 * @version 1.0
 * @author: Habiballah Hezarehee
 */
public class Game
{
    private WordList wordList;
    private Word word;
    private Player player;
    Integer guessRemained = 6;
    private ArrayList<Character> guessedLetters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private boolean playerHasWon = false;


    public Game (ArrayList<String> wordsInArrayList)
    {
        wordList = new WordList(wordsInArrayList);
        System.out.print("Skriv ditt namn: ");
        String name = scanner.next();
        player = new Player(name, 0);
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("Avsluta");
        menuItems.add("Starta spelet");
        menuItems.add("Högst poäng");
        Menu menu = new Menu(menuItems);
        menu.showMenu();
    }

    public StringBuilder replaceLetterWithDash (String word, ArrayList<Character> guessedLetters)
    {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < word.length(); i++)
        {
            Character c = word.charAt(i);
            if (guessedLetters.contains(c))
            {
                this.player.increaseTotalPoints();
                str.append(c);
            } else
            {
                str.append("-");
            }
        }
        return str;
    }

    public void startGame ()
    {
        while (true)
        {
            Word word = new Word(wordList.randomWord());
            System.out.println("Jag tänker på ett ord, gissa vilket: ");
            while (true)
            {
                System.out.println(String.join("", "Du har ", Integer.toString(this.guessRemained), " försök kvar."));

                System.out.println("Hittils du har gissat: ");
                for (Character c : guessedLetters)
                    System.out.print(c + ", ");
                System.out.println();


                this.guess();
                String encryptedWord = String.valueOf(replaceLetterWithDash(word.toString(), guessedLetters));
                System.out.println(encryptedWord);
                if (player.hasWon(encryptedWord, this.guessRemained))
                {
                    this.playerHasWon = true;
                    break;
                }
                if (guessRemained == 0)
                    break;
            }
            System.out.println(this.endGame());
            System.out.print("Vill du spela igen (ja, nej): ");
            String userResponse = scanner.next();
            if (userResponse.equalsIgnoreCase("nej"))
            {
                System.out.println("Bra jobbat, hoppas vi ses igen!");
                System.out.println("Hejdå " + this.player.getName());
                System.out.println("Din totala poäng är: " + this.player.getTotalPoints());
                System.out.println("Din högsta poäng är: " + this.player.getHighestPoints());
                break;
            } else if (userResponse.equalsIgnoreCase("ja"))
            {
                System.out.println("Yesss!");
                this.player.resetTotalPoints();
                this.resetGuessRemained();
                this.resetGuessedLetters();
            } else
            {
                System.out.println("Fel svar, försök igen");
            }

        }
    }

    public void resetGuessedLetters ()
    {
        this.guessedLetters.clear();
    }

    public void resetGuessRemained ()
    {
        this.guessRemained = 6;
    }

    public int findLetterIndex (String letter, String word)
    {
        return word.indexOf(letter);
    }

    public void guess ()
    {
        System.out.print("> ");
        Character letter = scanner.next().charAt(0);
        this.guessedLetters.add(letter);
        this.guessRemained--;
    }

    public String endGame ()
    {
        String correctWord = word.toString();
        String finalResult = "";
        if (this.playerHasWon)
            finalResult += "Grattis " + this.player.getName() + ", du har gissat rätt, din poäng är: " + this.player.getTotalPoints();
        else
            finalResult += "Tyvärr, du vann inte den här gången, försök igen. Ordet jag tänkte på var " + correctWord;
        return finalResult;
    }
}

