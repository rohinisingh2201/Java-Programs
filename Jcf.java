import java.util.LinkedList;
public class Jcf {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addFirst(0);
        ll.addLast(2);
        ll.addLast(3);
        System.err.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
    }
}
