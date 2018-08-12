import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExampleTest {
    public static void main(String... args)
    {
        List<Integer> test = new ArrayList<>();
        for(int i = 0; i < 5; i++)
        {
            test.add(i * i);
        }

        // for loop
//        for(int i = 0; i < 5; i++)
//        {
//            System.out.println(test.get(i));
//        }
//        // foreach
//        for(Integer element: test)
//        {
//            System.out.println(element);
//        }
        //iterator
        System.out.println(test.size());//5
        Iterator<Integer> iit = test.iterator();
        while (iit.hasNext())
        {
            System.out.println(iit.next());
            iit.remove();
        }
        //
        System.out.println(test.size());//0
    }
}
