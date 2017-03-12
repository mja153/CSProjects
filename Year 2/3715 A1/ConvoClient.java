import java.io.*;
import java.net.*;
import java.util.Scanner;
/*
 * The client program can send text lines to a server program.
 */
public class ConvoClient {
    public static void main( String[] args ) {
		if ( args.length != 2 ) {
			System.out.println("usage: java Conversation Client host port");
		    System.exit(1);
		}
		int port = 0;
		String host = null;
		try {
		    host = args[0];
		    port = Integer.parseInt( args[1] );
		} catch( NumberFormatException e ) {
		    System.out.println("bad port number");
		    System.exit(1);
		}
			String tempLine = null;
			connectToServer(tempLine, port, host);
		
		}
	
	public static void connectToServer(String tempLine, int port, String host){
		try {
			InetAddress serverAdd = InetAddress.getByName( host );
			// connect to server
			Socket srvSock = new Socket( serverAdd, port );
			// create in/out stream
			InputStream inStrm = srvSock.getInputStream();		
			OutputStream outStrm = srvSock.getOutputStream();			
			PrintWriter prtWrite = new PrintWriter( outStrm, true );
			BufferedReader prtRead = new BufferedReader(new InputStreamReader( inStrm ));
			tempLine = null;
			
			while((tempLine=prtRead.readLine()) != null){
				break;
			}
			clientProcess(tempLine, port, host, prtWrite);
			srvSock.close();
		
		}
		catch( UnknownHostException e ) {
		    System.out.println("bad host name");
		    System.exit(0);
		}
		catch( IOException e ) {
		    System.out.println("io error:" + e);
		    System.exit(0);
		}
		
	}
	
	public static void clientProcess(String tempLine, int port, String host, PrintWriter prtWrite){
		try{
		if(tempLine.equalsIgnoreCase("WAIT")){
				// wait for 2nd client. this is first connected client's code.
				
				Scanner c1Scanner = new Scanner(System.in);			
				//initialize server socket while waiting
				
				ServerSocket c1Listen = new ServerSocket(0);
				int listenerPort = c1Listen.getLocalPort();
				prtWrite.println("CLIENT_PORT "+listenerPort);
				System.out.println("Waiting for 2nd Client. Will be listening on Port "+listenerPort);
				
			
				//accept incoming connection from second client				
				Socket c2Sock = c1Listen.accept();
								
				/* data from client */
				BufferedReader c2ReadBuffer = new BufferedReader(new InputStreamReader(c2Sock.getInputStream()));
				/* data to client */
				PrintWriter c2WriteBuffer = new PrintWriter(c2Sock.getOutputStream(), true);
				
				System.out.println("Accepted connection from "
				 + c2Sock.getInetAddress() + " at port " 
				 + c2Sock.getPort() );
				String c1WriteString = "";
				String c2ReadString = "";
				
				// loop while c1 and c2 talk to each other
				while(true){
					System.out.println("<<Waiting for reply>>");
					while((c2ReadString=c2ReadBuffer.readLine()) != null){
						break;
					}
						
					// print message received
					System.out.println("Message Received: "+c2ReadString);
					if(c2ReadString.equalsIgnoreCase("Goodbye")){
							String contAnswer = "";
							System.out.println("Paired client disconnected. Reconnect to server? (Yes/No)");
							contAnswer = c1Scanner.nextLine();
							if(contAnswer.equalsIgnoreCase("Yes")){
								connectToServer(tempLine, port, host);
								break;
							}
							else{
							break;
							}
						
						}
					
					// prompt new string to send
					System.out.print("Please enter your message: ");
					c1WriteString= c1Scanner.nextLine();
					c2WriteBuffer.println(c1WriteString);
					System.out.println("<<Message sent>>");
					if(c1WriteString.equalsIgnoreCase("Goodbye")){
						break;
					}
				}
				c2Sock.close();
				c1Listen.close();
				c1Scanner.close();
			}
			else {
				// client already exists, this is "pairing" 2nd client
				
				String adjServer = tempLine;
				String check =  adjServer.substring(0,8);
				if(check.equalsIgnoreCase("PEER_LOC")){
					Scanner c2Scanner = new Scanner(System.in);
					int delimiterIdx = adjServer.indexOf(":");
					int portnum = Integer.parseInt(adjServer.substring(9, delimiterIdx));
					String hostname = adjServer.substring(delimiterIdx+1, adjServer.length());
					
					Socket c1Sock = new Socket(hostname, portnum);
				
					/* data from client */
					BufferedReader c1ReadBuffer = new BufferedReader(new InputStreamReader(c1Sock.getInputStream()));
				    /* data to client */
					PrintWriter c1WriteBuffer = new PrintWriter(c1Sock.getOutputStream(), true);
					
					String c2WriteString = "";
					String c1ReadString = "";
					while(true){
						System.out.print("Please enter your message: ");
						c2WriteString = c2Scanner.nextLine();
						System.out.println("<<Message sent>>");
						c1WriteBuffer.println(c2WriteString);
						if(c2WriteString.equalsIgnoreCase("Goodbye")){
							break;
						}
						System.out.println("<<Waiting for reply>>");
						while((c1ReadString=c1ReadBuffer.readLine() ) != null){
							break;
						}
						System.out.println("Message Received: "+c1ReadString);
						if(c1ReadString.equalsIgnoreCase("Goodbye")){
							String contAnswer = "";
							System.out.println("Paired client disconnected. Reconnect to server? (Yes/No)");
							contAnswer = c2Scanner.nextLine();
							if(contAnswer.equalsIgnoreCase("Yes")){
								connectToServer(tempLine, port, host);
								break;
							}
							else{
							break;
							}
						
						}
					}
					c1Sock.close();		
					c2Scanner.close();
				}
			}
		}
		catch( UnknownHostException e ) {
		    System.out.println("bad host name");
		    System.exit(0);
		}
		catch( IOException e ) {
		    System.out.println("io error:" + e);
		    System.exit(0);
		}
		
	}
}