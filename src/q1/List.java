package q1;

// Generic q1.List Class; this Class uses q1.Cell as nodes for the q1.List.
public class List <E>
{
    private Cell head;
    private Cell tail;

    // Constructor.
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

    // adds a q1.Cell node to the end of the q1.List.
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

    // removes a q1.Cell node from the Head of the list.
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

    // checks if the q1.List is empty from q1.Cell nodes with data.
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

    // This Function purpose is to invert a list from a given q1.List - 'origin' until the end of the list.
    // The origin q1.List we be left un-touched, and the inverted q1.List will be returned.
    // logics - one pass to invert the whole q1.List;
    //          second node points to first node,
    //          first is been update to second, second is updated to third;
    //          goes on until third reaches end of the list (null object)
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

