import java.util.ArrayList;

public class List <E>
{
    private Cell head;
    private Cell tail;

    public List()
    {
        head = tail = new Cell(null);
    }

    public Cell getHead()
    {
        return this.head;
    }

    public Cell getTail()
    {
        return this.tail;
    }

    public void add(E data)
    {
        if (isEmpty())
        {
            this.head = this.tail = new Cell(data);
        }
        else
        {
            Cell temp = new Cell(data);
            this.tail.setNextCell(temp);
            this.tail = temp;
        }
    }

    public E remove() throws EmptyListException
    {
        if (this.head == null)
            throw new EmptyListException();
        else
        {
            Cell temp = this.head;
            this.head = this.head.getNextCell();
            return (E)temp.getData();
        }
    }

    private boolean isEmpty()
    {
        return this.getHead() == this.getTail() && this.head.getData() == null;
    }

    @Override
    public String toString()
    {
        String strToReturn = "";
        int i=1;
        for (Cell cell = this.getHead(); cell != null; cell = cell.getNextCell())
        {
            strToReturn += i + " : " + cell.getData() + "\n";
            i++;
        }
        return strToReturn;
    }

    // This Function purpose is to invert a list from a given List - 'origin' until the end of the list.
    // The origin List we be left un-touched, and the inverted List will be returned.
    public List invertedList()
    {
        List toReturn = new List();
        for (Cell cell= this.getHead(); cell != null; cell = cell.getNextCell())
        {
            toReturn.add(cell.getData());
        }
        if (toReturn.isEmpty() || toReturn.head == toReturn.tail)
            return toReturn;

        Cell first = toReturn.getHead();
        Cell second = first.getNextCell();
        Cell third;
        if (second.getNextCell() != null)
            third = second.getNextCell();
        else
        {
            second.setNextCell(toReturn.head);
            toReturn.tail = toReturn.head;
            toReturn.head = second;
            return toReturn;
        }

        first.setNextCell(null);
        toReturn.tail = first;
        for (; third != null; third = third.getNextCell())
        {
            second.setNextCell(first);
            first = second;
            second = third;
        }
        second.setNextCell(first);
        toReturn.head = second;
        return toReturn;
    }
}

