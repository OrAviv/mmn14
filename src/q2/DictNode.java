package q2;

public class DictNode implements Comparable
{
    private String key;
    private String value;

    public DictNode(String key, String value)
    {
        this.setKey(key);
        this.setValue(value);
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public int compareTo(Object o)
    {
        DictNode temp = (DictNode) o;
        int length = Math.min(this.key.length(), temp.key.length());
        for (int i=0; i < length; i++)
        {
            if (this.key.charAt(i) > temp.key.charAt(i))
                return 1;
            if (this.key.charAt(i) < temp.key.charAt(i))
                return -1;
        }
        if (this.key.length() == temp.key.length())
        {
            return 0;
        }

        return length == this.key.length() ? -1 : 1;
    }

    @Override
    public String toString() {
        return this.getKey() + " : " + this.getValue();
    }
}
