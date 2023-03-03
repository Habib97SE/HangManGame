package HangMan;

import java.util.ArrayList;

public class Player
{
    private String name;
    private Integer totalPoints;

    private ArrayList<Integer> allPlayersPoints = new ArrayList<>();

    public Player (String name, int totalPoints)
    {
        this.name = name;
        this.totalPoints = totalPoints;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Integer getTotalPoints ()
    {
        return totalPoints;
    }

    public void setTotalPoints (Integer totalPoints)
    {
        this.totalPoints = totalPoints;
    }

    public void increaseTotalPoints ()
    {
        this.setTotalPoints(this.totalPoints + 1);
    }

    public void resetTotalPoints ()
    {
        this.allPlayersPoints.add(totalPoints);
        this.totalPoints = 0;
    }

    public boolean hasWon(String word, Integer remainedGuess)
    {
        return remainedGuess >= 0 && !word.contains("-");
    }

    public Integer getHighestPoints()
    {
        Integer highestPoints = this.allPlayersPoints.get(0);
        for (Integer playerPoints : allPlayersPoints)
        {
            if (playerPoints > highestPoints)
                highestPoints = playerPoints;
        }
        return highestPoints;
    }

    @Override
    public String toString ()
    {
        return String.join("", "Name: ", this.getName(), "\n", "Total points: ",
                Integer.toString(this.getTotalPoints()));
    }


}
