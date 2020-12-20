public class Cell <E>
{
    // data parameter
    private E data;
    // next cell parameter.
    private Cell nextCell;

    public Cell(E data)
    {
        this.setData(data);
    }

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
//        nextCell.nextCell = this.nextCell;
        this.nextCell = nextCell;
    }

    public Cell getNextCell()
    {
        return this.nextCell;
    }
}
