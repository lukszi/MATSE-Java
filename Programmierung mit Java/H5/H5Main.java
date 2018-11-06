/**
 * Created by Lukas Szimtenings on 04.11.2018.
 */
public class H5Main
{
    public static void main(String args[])
    {
        MyArrayList myArrayList = new MyArrayList();
        // fuege die Zahlen 0-9 zur Liste hinzu
        for (int i = 0; i < 10; i++)
        {
            myArrayList.add(i);
        }
        System.out.println(myArrayList);//[0,1,2,3,4,5,6,7,8,9]
        //die Liste hat nun 10 Elemente
        System.out.println(myArrayList.size()); // 10
        //fuege die Zahl 5 an der Position 2 der Liste hinzu
        myArrayList.add(5, 2);
        System.out.println(myArrayList);//[0,1,5,2,3,4,5,6,7,8,9]
        //entferne die Elemente 1-6
        for (int i = 6; i > 0; i--)
        {
            myArrayList.delete(i);
            System.out.print(myArrayList.capacity() + "/");
            System.out.println(myArrayList.size());
        }
        System.out.println(myArrayList);//[0,6,7,8,9]
        //gebe das Element an der Position 2 aus
        System.out.println(myArrayList.get(2));//7
        //erzeugt einen Klon der Liste
        MyArrayList myArrayList2 = myArrayList.clone();
        //Loesche die Liste
        myArrayList.clear();
        System.out.println(myArrayList);//[]
        System.out.println(myArrayList2);//[0,6,7,8,9]
    }
}
