package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    private int size = 0;
    private Node first;
    private Node last;

    @Override
    public boolean add(String value) {
        linkLast(value);
        return true;
    }

    private void linkLast(String e) {
        final Node l = last;
        final Node newNode = new Node(l, e, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, String value) {
        if (index == size) {
            linkLast(value);
            return;
        }
        linkBefore(value, node(index));
    }

    private void linkBefore(String e, Node node) {
        final Node prev = node.prev;
        final Node newNode = new Node(prev, e, node);
        node.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public String set(int index, String value) {
        Node node = node(index);
        String oldValue = node.item;
        node.item = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        String value = first.item;
        Node tmp = first;
        for (int i = 0; i < index; i++) {
            value = tmp.item;
            tmp = tmp.next;
        }
        return value;
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(String value) {
        int index = 0;
        for (Node n = first; n != null; n = n.next) {
            if (value.equals(n.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        for (Node n = first; n != null; n = n.next) {
            if (value.equals(n.item)) {
                unlink(n);
                return true;
            }
        }
        return false;
    }

    String unlink(Node node) {
        final String element = node.item;
        final Node next = node.next;
        final Node prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return element;
    }

    @Override
    public String remove(int index) {
        return unlink(node(index));
    }

    Node node(int index) {
        if (index < (size >> 1)) {
            Node n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            return n;
        }
        Node n = last;
        for (int i = size - 1; i > index; i--) {
            n = n.prev;
        }
        return n;
    }

    @Override
    public void clear() {
        for (Node n = first; n != null; ) {
            Node next = n.next;
            n.item = null;
            n.next = null;
            n.prev = null;
            n = next;
        }
        first = last = null;
        size = 0;
    }

    private static class Node {

        String item;
        SimpleLinkedList.Node next;
        SimpleLinkedList.Node prev;

        Node(SimpleLinkedList.Node prev, String element, SimpleLinkedList.Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
