import java.io.*;
import java.net.*;

public class ConvoServer extends Thread {
    private Socket sock;
    private static volatile String portN = "";
    private static volatile String local = "";

    
    public ConvoServer(Socket sock) {
    	this.sock =  sock;
    }
    
    @Override
    public void run() {
        try {
            /* data from client */
            BufferedReader rd  = new BufferedReader(new InputStreamReader( sock.getInputStream()));

            /* data to client */
            PrintWriter  bw = new PrintWriter(sock.getOutputStream(),true);
       
            if (sock.isConnected()){
            	System.out.println("client connected");
            }
            
		    String msg = null;
		    if(portN.compareTo("") == 0){
				bw.println("WAIT");
				while ((msg = rd.readLine()) != null) {
					portN = msg.substring(12, msg.length());
					local = sock.getLocalAddress().getHostName();
				}
		    } else {
				bw.println("PEER_LOC "+portN+":"+local);
				portN = "";
				local = "";
		    }
            System.out.println( "closing" + sock );
            sock.close(); // clean up required
            rd.close();
            bw.close();
        } catch( IOException e ) {
		    System.out.println("error: " + e );
        }
    }

    private static void dumpThreads() {
        Thread[] threads = new Thread[100];
        int num = Thread.enumerate( threads );
        for( int i = 0 ; i < num; i++ ) {
            System.out.println( threads[i] );
        }
    }

    public static void main( String[] args ) {
		try {
		    ServerSocket listen = new ServerSocket( 0 );

			
		    System.out.println("Server port is " + listen.getLocalPort() );
		    while ( true ) {
		    	Socket sock = listen.accept();
	
		    	ConvoServer newls = new ConvoServer(sock);
		    	newls.start();
	            dumpThreads();
		    }
		}catch( IOException e ) {
		    System.out.println("error: " + e );
		}
		
	
    }
}