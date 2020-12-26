package q2;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

// Main Panel class; different panels & theirs components are separated by new lines.
public class DictionaryPanel extends JPanel
{
    JPanel panel;
    MyDictionary myDictionary;

    JLabel mainLabel;
    JButton loaderButton;
    JLabel resultLabel;
    JFileChooser fileChooser;

    JButton searchButton;
    JTextField searchKey;
    JLabel searchResult;

    JButton addButton;
    JTextField addKeyField;
    JTextField addValueField;
    JLabel addResult;

    JButton updateButton;
    JTextField updateKeyField;
    JTextField updateValueField;
    JLabel updateResult;

    JButton removeButton;
    JTextField removeKeyField;
    JLabel removeResult;

    JButton export;
    JTextField exportFolder;
    JLabel exportResult;

    // Constructor.
    public DictionaryPanel()
    {
        myDictionary = new MyDictionary();
        panel = new JPanel();
        FlowLayout myLayout = new FlowLayout();
        setLayout(myLayout);

        // Main Panel initials.
        mainLabel = new JLabel("Press Load to insert a path to '.txt' Dictionary");
        resultLabel = new JLabel();
        loaderButton = new JButton("Load Dictionary");
        loaderButton.addActionListener(new DictionaryLoader());
        JPanel loaderPanel = new JPanel();
        loaderPanel.setPreferredSize(new Dimension(670,70));
        loaderPanel.setBackground(Color.lightGray);
        loaderPanel.add(mainLabel);
        loaderPanel.add(loaderButton);
        loaderPanel.add(resultLabel);

        // Search Panel initials.
        searchButton = new JButton("Search");
        searchKey = new JTextField(10);
        searchResult = new JLabel();
        searchButton.addActionListener(new SearchListener());
        JPanel searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(670, 70));
        searchPanel.setBackground(Color.lightGray);
        searchPanel.add(searchButton);
        searchPanel.add(searchKey);
        searchPanel.add(searchResult);

        // Add Panel initials.
        addButton = new JButton("Add");
        addKeyField = new JTextField("//Enter Key Here", 20);
        addValueField = new JTextField("//Enter Value Here", 20);
        addResult = new JLabel();
        addButton.addActionListener(new AddButtonListener());
        JPanel addPanel = new JPanel();
        addPanel.setPreferredSize(new Dimension(670, 70));
        addPanel.setBackground(Color.lightGray);
        addPanel.add(addButton);
        addPanel.add(addKeyField);
        addPanel.add(addValueField);
        addPanel.add(addResult);

        // Update Panel initials.
        updateButton = new JButton("Update");
        updateKeyField = new JTextField("//Enter Key Here", 20);
        updateValueField = new JTextField("//Enter Value Here", 20);
        updateResult = new JLabel();
        updateButton.addActionListener(new UpdateListener());
        JPanel updatePanel = new JPanel();
        updatePanel.setPreferredSize(new Dimension(670, 70));
        updatePanel.setBackground(Color.lightGray);
        updatePanel.add(updateButton);
        updatePanel.add(updateKeyField);
        updatePanel.add(updateValueField);
        updatePanel.add(updateResult);

        // Remove Panel initials.
        removeButton = new JButton("Remove");
        removeKeyField = new JTextField("//Enter Key Here", 20);
        removeResult = new JLabel();
        removeButton.addActionListener(new RemoveListener());
        JPanel removePanel = new JPanel();
        removePanel.setPreferredSize(new Dimension(670, 70));
        removePanel.setBackground(Color.lightGray);
        removePanel.add(removeButton);
        removePanel.add(removeKeyField);
        removePanel.add(removeResult);

        // Export Panel initials.
        export = new JButton("Export Dictionary");
        exportFolder = new JTextField("//Export file path", 20);
        exportResult = new JLabel();
        export.addActionListener(new ExportListener());
        JPanel exportPanel = new JPanel();
        exportPanel.setPreferredSize(new Dimension(670, 70));
        exportPanel.setBackground(Color.lightGray);
        exportPanel.add(export);
        exportPanel.add(exportFolder);
        exportPanel.add(exportResult);

        add(loaderPanel);
        add(searchPanel);
        add(addPanel);
        add(updatePanel);
        add(removePanel);
        add(exportPanel);
    }

    public class DictionaryLoader implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileFilter()
            {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".txt");
                }
                @Override
                public String getDescription() {
                    return "'.txt' file";
                }
            });

            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            try {
                if (myDictionary.parser(filePath))
                    resultLabel.setText("Load Succeeded");
                } catch (IOException ioException)
                {
                   resultLabel.setText("invalid path! Please try to insert another '.txt' file path.");
                }
        }
    }

    public class SearchListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String key = searchKey.getText();
            int index = myDictionary.search(key);
            if (index < 0)
                searchResult.setText("Item is not found on Dictionary");
            else
                searchResult.setText("Value : " + myDictionary.getValueByKey(index));
        }
    }

    public class AddButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            while (addKeyField.getText() == "" || addValueField.getText() == "")
                addResult.setText("Please enter your key & his value.");

            myDictionary.add(new DictNode(addKeyField.getText(), addValueField.getText()));
            addResult.setText("Successfully added to Dictionary!");
        }
    }

    public class ExportListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            while (exportFolder.getText() == "")
                exportResult.setText("Please enter valid path to a '.txt' file");

            String filePath = exportFolder.getText();
            try
            {
                PrintWriter outputFile = new PrintWriter(filePath);
                outputFile.println(myDictionary.toString());
                outputFile.close();
                exportResult.setText("Successfully Exported Dictionary!");
            } catch (FileNotFoundException fileNotFoundException)
            {
                exportResult.setText("Please enter valid path to a '.txt' file");
            }
        }
    }

    public class UpdateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (myDictionary.update(updateKeyField.getText(), updateValueField.getText()))
                updateResult.setText("Successfully updated");
            else
                updateResult.setText("Key not found! please try again.");
        }
    }

    public class RemoveListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (myDictionary.removeByKey(removeKeyField.getText()))
                removeResult.setText("Successfully Removed!");
            else
                removeResult.setText("Key not Found! Please try again.");
        }
    }
}
