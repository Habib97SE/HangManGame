import HangMan.*;

import java.util.ArrayList;

public class App
{
    public static void main (String[] args)
    {
        ArrayList<String> words= new ArrayList<>();
        words.add("katt");
        words.add("blomma");
        words.add("guld");

        Game game = new Game(words);

        game.startGame();
    }
}
