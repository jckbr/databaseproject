import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class GenerateRandom
{
    public static GenerateRandom instance;

    public GenerateRandom()
    {
        instance = this;
    }

    public String generateRandomName()
    {
        HashMap<Integer, String> names = new HashMap<Integer, String>();
        int count = 0;

        try
        {
            File dict = new File("names.txt");
            Scanner readNames = new Scanner(dict);

            while(readNames.hasNextLine())
            {
                names.put(count++, readNames.nextLine());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found. Make sure file 'names.txt' is in src folder.");
        }

        int random1 = (int) (Math.random() * count);
        int random2 = (int) (Math.random() * count);

        return names.get(random1) + " " + names.get(random2);
    }

    public String generateRandomGame()
    {
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        int count = 0;

        try
        {
            File dict = new File("words_alpha.txt");
            Scanner readDict = new Scanner(dict);

            while(readDict.hasNextLine())
            {
                dictionary.put(count++, readDict.nextLine());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found. Make sure file 'words-alpha.txt' is in src folder.");
        }

        int random1 = (int) (Math.random() * count);
        int random2 = (int) (Math.random() * count);

        return dictionary.get(random1) + " " + dictionary.get(random2);
    }
}