package HangMan;

import java.util.ArrayList;

public class Menu
{
    private ArrayList<String> menuItems;

    public Menu (ArrayList<String> menuItems)
    {
        this.menuItems = menuItems;
    }

    public void showMenu ()
    {
        for (String menuItem : menuItems)
            System.out.println(String.join("", Integer.toString(menuItems.indexOf(menuItem)), "- ", menuItem));
    }

    public ArrayList<String> getMenuItems ()
    {
        return this.menuItems;
    }

    public void setMenuItems (ArrayList<String> menuItems)
    {
        this.menuItems = menuItems;
    }


    public boolean addMenuItem (String menuItem)
    {
        return this.menuItems.add(menuItem);
    }

    public boolean deleteMenuItem (String menuItem)
    {
        return this.menuItems.remove(menuItem);
    }

}


