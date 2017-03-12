public class  MaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;             // heap-ordered complete binary tree   
  private int N = 0;
  public MaxPQ(int maxN)
  {  pq = (Key[]) new Comparable[maxN+1];  }
  
  public boolean isEmpty()   {  return N == 0;  }
  
 public int size()   {  
	return N;  }
	 
public void insert(Key v)   {
	  pq[++N] = v;
      swim(N);   
	  }
	  
public Key delMax()   { 
	 Key max = pq[1];           // Retrieve max key from top.      
	exch(1, N--);              // Exchange with last item.      
	pq[N+1] = null;            // Avoid loitering.      
	sink(1);                   // Restore heap property.      
	return max;
		}
		
		//Assignment 3 Question 4 find(Key key) method -- Time complexity in attached Word Document
public boolean find(Key key){
int sz = pq.size();
boolean result = false;
	for(int i=1; i<=sz; i++){
		if(pq[i].compareTo(key) == 0){
		result = true;
		}
	}
	return result;
}


}
		 
	private boolean less(int i, int j)   
	private void exch(int i, int j)   
	private void swim(int k)   
	private void sink(int k)
			}
			