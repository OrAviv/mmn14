package q2;

import java.io.*;
import java.util.ArrayList;

public class MyDictionary extends ArrayList
{
    private ArrayList myDictionary;

    public MyDictionary ()
    {
        myDictionary = new ArrayList<MyDictionary>();
    }

    public void add(DictNode dictNode)
    {
        if (myDictionary.isEmpty())
        {
            this.myDictionary.add(dictNode);
            return;
        }
        DictNode index;
        for (int i=0; i < myDictionary.size(); i++)
        {
            index = (DictNode) myDictionary.get(i);
            if (index.compareTo(dictNode) >= 0)
            {
                myDictionary.add(i, dictNode);
                return;
            }
        }
        myDictionary.add(dictNode);
    }

    public void add(String key, String value)
    {
        DictNode newNode = new DictNode(key,value);
        this.add(newNode);
    }

    public boolean removeByKey (String key)
    {
        if (myDictionary.isEmpty())
        {
            System.out.println("dictionary is empty.");
            return false;
        }

        int toRemove = this.search(key);
        if (toRemove > 0)
        {
            this.myDictionary.remove(toRemove);
            return true;
        }
        else
        {
            System.out.println("Index '"+key+"' is not found in dictionary.");
            return false;
        }
    }

    public boolean remove(DictNode dictNode)
    {
        return this.removeByKey(dictNode.getKey());
    }

    public boolean update (String key, String data)
    {
        if (this.myDictionary.isEmpty())
            return false;

        int indexOfKey = this.search(key);
        if (indexOfKey > 0)
        {
            DictNode temp = (DictNode) this.myDictionary.get(indexOfKey);
            temp.setValue(data);
            return true;
        }
        return false;
    }

    public int search(String key)
    {
        if (myDictionary.isEmpty())
        {
            return -1;
        }

        DictNode index;
        DictNode keyNode = new DictNode(key, null);
        for (int i=0; i < this.myDictionary.size(); i++)
        {
            index = (DictNode) this.myDictionary.get(i);
            if (index.compareTo(keyNode) == 0)
            {
                return i;
            }
        }
        return -1;
    }

    public String getValueByKey(int keyIndex)
    {
        DictNode valueNode = (DictNode) this.myDictionary.get(keyIndex);
        return valueNode.getValue();
    }

    public boolean parser(String filePath) throws IOException
    {

        try
        {
            FileReader input = new FileReader(filePath);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine;
            while ( (myLine = bufRead.readLine()) != null)
            {
                if (myLine.isBlank())
                    continue;
                String[] dictLine = myLine.split(":");
                String keyPart = dictLine[0].trim();
                String valuePart = dictLine[1].trim();
                this.myDictionary.add(new DictNode(keyPart, valuePart));
            }
            return true;
        }
        catch (IOException e)
        {
            return false;
        }

    }

    @Override
    public String toString()
    {
        String myDictString = "";
        for (int i=0; i< this.myDictionary.size(); i++)
        {
            DictNode temp = (DictNode) this.myDictionary.get(i);
            myDictString += temp.toString()+"\n";
        }
        return myDictString;
    }
}