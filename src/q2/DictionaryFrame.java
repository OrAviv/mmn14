package q2;

import javax.swing.*;

public class DictionaryFrame extends JFrame
{
    JFrame frame;
    DictionaryPanel panel;

    public DictionaryFrame()
    {
        frame = new JFrame("Dictionary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        panel = new DictionaryPanel();
        frame.add(panel);
        frame.setVisible(true);

    }




}
