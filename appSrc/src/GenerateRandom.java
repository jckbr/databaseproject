import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class GenerateRandom
{
    public boolean generateRandom()
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

        if(count == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}