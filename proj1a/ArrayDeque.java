import java.security.PublicKey;

public class ArrayDeque<T> {

    private int size;

    private  T[] items;

    public ArrayDeque() {

        items = (T[]) new Object[8];

        size = 0;

    }

    private void resize(int capacity) {

        T[] a = (T[]) new Object[capacity];

        System.arraycopy(items,0, a, 0, size);

        items = null;

        items = a;

        a = null;

    }

    public boolean isEmpty() {

        boolean result = false;

        if (size == 0) {

            result = true;
        }

        return  result;
    }



    public int size() {

        return size;

    }

    public void addFirst(T x) {

        if (size == items.length) {

            resize(size*2);

        }

        System.arraycopy(items,0,items,1,size);

        items[0] = x;

        size += 1;

    }

    public void addLast(T x) {

        if (size == items.length) {

            resize(size*2);

        }

        items[size] = x;

        size += 1;

    }




    public T get (int index) {

        if (size == 0) {

            return null;

        } else {

            if (index >= size) {

                return  null;
            }

            return items[index];

        }

    }

    public T removeFirst() {

        if (size == 0) {

            return null;

        } else {

            T result = items[0];

            items[0] = null;

            System.arraycopy(items,1,items,0,size-1);

            items[size-1] = null;

            size -= 1;

            if ((float) size / (float) items.length <= 0.25 && size > 8) {

                resize(items.length/2);

            }

            return result;

        }
    }

    public T removeLast() {

        if (size == 0) {

            return null;

        } else {

            T result = items[size-1];

            items[size-1] = null;

            size = size-1;

            if ((float) size / (float) items.length <= 0.25 && size > 8) {

                resize(items.length/2);

            }

            return result;
        }
    }

    public void printDeque() {

        int flag = 0;

        for (int i = 0; i < size; i++) {

            if (flag == 0) {
                System.out.print(items[i]);
                flag = 1;
            } else {
                System.out.print(" ");
                System.out.print(items[i]);
            }
        }
    }




    public static void main(String[] args) {

        ArrayDeque<Integer> L = new ArrayDeque<>();

        for (int i = 0; i < 1; i++) {
            L.addFirst(i);
        }

        for (int i = 0; i < 2; i++) {
            L.removeFirst();
        }

        //L.removeLast();

        System.out.println((float) 10 / (float) 128);

        System.out.println(L.size);



    }





}

