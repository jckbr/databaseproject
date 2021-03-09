import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseUI
{
    public static void main(String args[])
    {
        //Creating the Frame
        JFrame frame = new JFrame("Game Rental Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);

        JButton newButton = new JButton("New");
        newButton.setBounds(0,50,50,50);
        JButton delButton = new JButton("Delete");
        delButton.setBounds(0,50,100,50);
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(0,50,100,50);
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(0,50,100,50);
        JButton prevButton = new JButton("Previous");
        prevButton.setBounds(0,50,100,50);
        frame.add(newButton);
        frame.add(delButton);
        frame.add(updateButton);
        frame.add(nextButton);
        frame.add(prevButton);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        String data[][] = {{"01", "Jack", "Action"},
                           {"02", "Kaylee", "Racing"}};
        String column[] = {"ID", "Name", "Interests"};
        JTable table = new JTable(data, column);
        table.setBounds(30,40,300,300);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);

        frame.setVisible(true);

        // -------------------------------------------------------

        newButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){}});
    }
}