import java.io.*;
import java.net.*;
import java.util.Date;
import java.io.File;
import java.util.Scanner;

public class PWServer {

	//send not found error
    public static void sendNotFound( BufferedWriter out ) {
        PrintWriter pr = new PrintWriter( out );
        pr.println("HTTP/1.0 404 Not Found");
        pr.println("Connection: close");
        pr.println();
        pr.flush();
    }
	
	//send reply (acceptable usrname/PW or incorrect PW page)
    public static void sendReply( String username, String password, String path, BufferedWriter out, int num ) {
		try{
			PrintWriter pr = new PrintWriter( out );
			File authFile = new File("input.txt"); 
			Scanner fileIn = new Scanner(authFile);
			boolean accept = false;
			String checkUsername = "";
			String checkPassword = "";
			while(fileIn.hasNext()){
				checkUsername = fileIn.next();
				checkPassword = fileIn.next();
				if(checkUsername.compareTo(username) == 0 && checkPassword.compareTo(password) == 0){
					accept = true;
					break;
				}
				accept = false;
			}
		if(accept){
			pr.println("HTTP/1.0 200 OK");
			pr.println("Connection: close");
			pr.println("Content-Type: text/html");
			pr.println("Set-Cookie: username="+username+"; path=/;");
			pr.println();
			pr.println("<html>");
			pr.println("<body>");
			pr.println("<pre>" + "User name and Password Authentication Successful." + "</pre>");
			pr.println("</body>");
			pr.println("</html>");
			pr.flush();
			}
		else{
			pr.println("HTTP/1.0 200 OK");
			pr.println("Connection: close");
			pr.println("Content-Type: text/html");
			pr.println();
			pr.println("<html>");
			pr.println("<head>");
			pr.println("<title>Unsuccessful Login Attempt</title>");
			pr.println("</head>");
			pr.println("<style>");
			pr.println("p.one{ font-size: 200%;");
			pr.println("text-align:center;");
			pr.println("border: none;;");
			pr.println("font-family: \"Courier New\";}");
			pr.println("p.two{ font-size: 130%;");
			pr.println("border: none;");
			pr.println("font-family: \"Courier New\";}");
			pr.println("</style>");
			pr.println("<body>");
			pr.println("<table align=center width=\"700\">");
			pr.println("<tr><td  colspan = 3><p class=\"one\">");
			pr.println("<b>Incorrect user name or password</b></p></td></tr>");
			pr.println("<tr><td  colspan = 3><p class=\"one\"><b>Please enter again</b></p></td></tr>");
			pr.println("<form method=\"GET\" action= \"http://localhost:2525/PWServer\">");
			pr.println("<tr><td><p class=\"two\">");
			pr.println("User Name:</p></td>");
			pr.println("<td><input type=\"text\" name=\"username\"></td></tr>");
			pr.println("<tr><td><p class=\"two\">Password:</p></td>");
			pr.println("<td><input type=\"password\" name=\"password\"></td></tr>");
			pr.println("<tr><td><input type=\"submit\" value=\"Submit\"></td></tr>");
			pr.println("</table>");
			pr.println("</form>");
			pr.println("</body>");
			pr.println("</html>");
			pr.flush();
			}
		
    
   
        pr.flush();
		
		}
		//print error messages
		catch (FileNotFoundException e) {
			System.out.printf("Error, no such file name in directory.");
		}
	
	}
	

    

    public static void main( String[] args ) {
        int i = 0; 
        try {
            int port = 2525;
            ServerSocket listen = new ServerSocket( port );
            System.out.println ("Accepting HTTP request from port: " + listen.getLocalPort());
            while ( true ) {
                i++; 
                int num = 0; 
                Socket sock = listen.accept();
                BufferedReader rd = new BufferedReader(
                    new InputStreamReader( sock.getInputStream() ));
                BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter( sock.getOutputStream() ));
                // get request
                String line = rd.readLine();
                if ( line == null ) {
                    sock.close();
                    continue;
                }
                String[] words = line.split("\\s+");
                System.out.println( line );
				//store line
				String PWLine = line;
                do {
                    line = rd.readLine();
                    if ( line == null ) break;
                    if (line.length() > 0) { 
                       String[] fields = line.split("\\s*:\\s*"); 
                        if (fields[0].equals("Cookie")) { 
                            String[] cfields = fields[1].split("=");
                            num = Integer.parseInt(cfields[1]) + 1; 
                        } 
                    } 
                    System.out.println( line );
                } while ( line.length() > 0 && !(rd.readLine().compareTo("")==0));
                if ( words[1].equals("/favicon.ico") ) {
                    sendNotFound( bw );
                }
                else {
					//get username and PW input
					String username = PWLine.substring(PWLine.indexOf("=")+1, PWLine.indexOf("&"));
					String tempPassword = PWLine.substring(PWLine.indexOf("=")+1, PWLine.lastIndexOf(" "));
					String password = tempPassword.substring(tempPassword.indexOf("=")+1, tempPassword.length());
					//authenticate usrname/pw
                    sendReply(username, password, words[1], bw, num );
                }
                rd.close();
                bw.close();
                sock.close();
            }
       }
       catch( IOException e ) {
           System.out.println("error: " + e );
       }
    }
}