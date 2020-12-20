package q1;

// This Class purpose is to act as a generic Node for q1.List Class implementation.
public class Cell <E>
{
    // data parameter
    private E data;
    // next cell parameter.
    private Cell nextCell;

    // Constructor
    public Cell(E data)
    {
        this.setData(data);
    }

    // Constructor #2 - Creates a Node with a data for the new node & the next node to be attached to.
    public Cell(E data, Cell nextCell)
    {
        this.setData(data);
        this.setNextCell(nextCell);
    }

    public void setData(E newData)
    {
        this.data = newData;
    }

    public E getData()
    {
        return this.data;
    }

    public void setNextCell(Cell nextCell)
    {
        this.nextCell = nextCell;
    }

    public Cell getNextCell()
    {
        return this.nextCell;
    }
}