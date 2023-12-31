public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? second : first;
    }

    public static void printUsers(User user) {
        System.out.println(user);
    }

    // class CAP#1 extends User {}
    // class Instructors extends CAP#1 {}
    public static void printUsers(GenericList<? super User> users) {
        GenericList<Object> temp = new GenericList<>();
        users.add(new Instructor(1));
    }
}
