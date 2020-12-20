package q1;

import java.util.Scanner;

public class MainQ1
{

    public static void main(String[] args) throws EmptyListException
    {
        Scanner scanner = new Scanner(System.in);
        List <String> myList = new List<>();
        System.out.println("Hello! please insert 6 strings to the list.");
        for (int i=0; i<6; i++)
        {
            System.out.println("Please insert String number "+(i+1)+":");
            myList.add(scanner.nextLine());
        }
        System.out.println("Your q1.List:\n" + myList.toString());

        List <String> inverted = myList.invertedList();
        System.out.println("your list inverted:\n" + inverted.toString());

        List<Person> personList = new List<>();
        personList.add(new Person("Or", 1234, 1993));
        personList.add(new Person("yossi", 4321, 1992));
        personList.add(new Person("moshe", 2233, 2001));
        personList.add(new Person("asher", 3456, 1980));
        personList.add(new Person("jhon", 7675, 1981));
        System.out.println("Oldest person in Persons q1.List: "+max(personList).toString());
    }

    // generic function for comparison between to Comparable objects.
    public static <E extends Comparable> E max(List<E> comparableList)
    {
        Cell cell = comparableList.getHead();
        E max = (E)cell.getData();
        for (; cell != null; cell = cell.getNextCell())
        {
            E temp = (E)cell.getData();
            if (temp.compareTo(max)>0)
                max = temp;
        }
        return max;
    }
}
