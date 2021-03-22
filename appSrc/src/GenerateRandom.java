import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class GenerateRandom
{
    public String generateRandomName()
    {
        HashMap<Integer, String> names = new HashMap<Integer, String>();
        int count = 0;

        try
        {
            File dict = new File("./appSrc/src/names.txt");
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

    public String generateRandomGenre()
    {
        HashMap<Integer, String> genres = new HashMap<Integer, String>();
        int count = 0;

        try
        {
            File dict = new File("./appSrc/src/genres.txt");
            Scanner readGenres = new Scanner(dict);

            while(readGenres.hasNextLine())
            {
                genres.put(count++, readGenres.nextLine());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found. Make sure file 'genres.txt' is in src folder.");
        }

        int random = (int) (Math.random() * count);

        return genres.get(random);
    }

    public int generateRandomPay()
    {

        return (int) (Math.random() * 100000);
    }

    public String generateRandomDate()
    {
        int month = (int) (Math.random() * 11) + 1;
        int day = (int) (Math.random() * 28) + 1;
        int year = (int) (Math.random() * 2019) + 1;

        return month + "-" + day + "-" + year;
    }

    public String generateRandomRegion()
    {
        HashMap<Integer, String> regions = new HashMap<Integer, String>();
        regions.put(0, "North");
        regions.put(1, "East");
        regions.put(2, "South");
        regions.put(3, "West");

        int random = (int) (Math.random() * 3) + 1;

        return regions.get(random);
    }

    public int generateRandomPrice()
    {

        return (int) (Math.random() * 60);
    }

    public String generateRandomGame()
    {
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        int count = 0;

        try
        {
            File dict = new File("./appSrc/src/words_alpha.txt");
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