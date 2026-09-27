public class LinkedList
{
    private class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList()
    {
        this.head = null;
        this.size = 0;
    }

    public void add(int x)
    {
        Node newNode = new Node(x);

        if(head==null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int get(int index)
    {
        if(index<0 || index>=size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for(int i=0;i<index;i++)
        {
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(int x)
    {
        Node current = head;
        while(current.next != null)
        {
            if(current.next.data == x)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int index)
    {
        if(index<0 || index>=size)
            {
            throw new IndexOutOfBoundsException("Index out of bounds");
            }
        if(index==0)
        {
            head = head.next;
        }
        else
        {
            Node current = head;
            for(int i=0;i<index-1;i++)
            {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void add(int index,int x)
    {
        if(index<0 || index>size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node newNode = new Node(x);

        if(index==0)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            Node current = head;
            for(int i=0;i<index-1;i++)
            {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
}
