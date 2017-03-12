public class Josephus {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
		int P = Integer.parseInt(args[2]):
		int count = 0;

        // initialize the queue
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 1; i <= N; i++)
            q.enqueue(i);

        while (!q.isEmpty()) {
            for (int i = 0; i < M - 1; i++){
                q.enqueue(q.dequeue());
				}
			if (!count = p){
            System.out.print(q.dequeue() + " ");
			count++;
			}
			else{
			count++;
			q.enqueue(q.dequeue());
			}
        } 
        System.out.println();
    }
}