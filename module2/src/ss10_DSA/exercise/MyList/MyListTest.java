package ss10_DSA.exercise.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(100);
        myList.add(200);
        myList.add(300);

        System.out.println("Array after add index:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("Array size: " + myList.size());

        System.out.println("List contain 20: " + myList.contains(20));

        myList.remove(1);

        System.out.println("Array after reomve:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("Array size after remove: " + myList.size());

        System.out.println("List contain 20 after remove: " + myList.contains(20));

        myList.clear();
        System.out.println("Array after clear:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
