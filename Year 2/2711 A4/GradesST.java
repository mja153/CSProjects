import java.util.NoSuchElementException;

public class GradesST
{
public static void main (String[] args){
BinarySearchST<String, Double> grades;
grades = new BinarySearchST<String, Double>();
private double total;
private double GPA;
private int count;

			count = 0;
			GPA = 0;
			grades.put("A+", 4.33);
			grades.put("A", 4.00);
			grades.put("A-", 3.67);
			grades.put("B+", 3.33);
			grades.put("B", 3.00);
			grades.put("B-", 2.67);
			grades.put("C+", 2.33);
			grades.put("C", 2.00);
			grades.put("C-", 1.67);
			grades.put("D", 1.00);
			grades.put("F", 0.00);

		while(!StdIn.isEmpty()){
		total += grades.get(StdIn.readString())
		count++;
		}
		GPA = total/count;
		StdOut.println("Your GPA is: "+ GPA + "calculated from your "+count+" marks.")
	}
	
}
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N = 0;
	
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   

    private void resize(int capacity) {
        assert capacity >= N;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key); 
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    } 
    public int rank(Key key) {
        int lo = 0, hi = N-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 
    public void put(Key key, Value val)  {
        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (N == keys.length) resize(2*keys.length);

        for (int j = N; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;

        assert check();
    } 
    public void delete(Key key)  {
        if (isEmpty()) return;


        int i = rank(key);

 
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        N--;
        keys[N] = null;  
        vals[N] = null;


        if (N > 0 && N == keys.length/4) resize(keys.length/2);

        assert check();
    } 
	
	 private boolean check() {
        return isSorted();
    }
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }
}
 

