import javax.swing.*;
import java.util.ArrayList;

public class FortuneTellerViewer
{
    public static void main(String[] args)
    {
        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add("You will get an uncontrollable urge to switch to Android.");
        fortunes.add("You will get 3rd place in Jeopardy.");
        fortunes.add("You will get a new Toyota Prius for 50% off.");
        fortunes.add("You will die on the toilet.");
        fortunes.add("You will go on a journey to kill god with a group of japanese teenagers.");
        fortunes.add("You will win a million euros worth of corn.");
        fortunes.add("You will grow bat wings.");
        fortunes.add("You will get a magnificient degree at clown college");
        fortunes.add("You will delete this useless app.");
        fortunes.add("Your wife will leave you for a pink starfish that lives under a rock.");
        fortunes.add("Your code will inexplicably start working, leaving you happy and confused.");
        fortunes.add("You will develop Stockholm Syndrome and will not be able to stop playing Dark Souls 2.");
        JFrame frame = new FortuneTellerFrame(fortunes);
    }
}
