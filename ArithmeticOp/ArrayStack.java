import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>
    {
        public static final int CAPACITY = 100;
        private E[] data;
        private int t = -1;
        public ArrayStack()
        {
            this(CAPACITY);
        }
        public ArrayStack(int capacity){
            
            data = (E[]) new Object[capacity];
        }
        }

        public int size()
        {
            return (t + 1);
        }

        public boolean isEmpty()
        {
            return (t == -1);
        }

        public void push(E e) throws IllegalStateException
        {
    
            if (size() == data.length) data = Arrays.copyOf(data, (data.length*2)); // doubling strategy
            data[++t] = e;
        }

        public E top()
        {
            if (isEmpty()) return null;
            return data[t];
        }

        public E pop()
        {
            if (isEmpty()) return null;
            E answer = data[t];
            data[t] = null;
            t--;
            return answer;
        }
}
