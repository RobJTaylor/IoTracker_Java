import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.apache.commons.net.util.TrustManagerUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws SocketException, IOException {
		// TODO Auto-generated method stub
		final String URL = "home629779161.1and1-data.host";
		final String username = "u85301453-JAVA";
		final String password = "VCQUHINR";
		
		String hostname = "Unknown";
		
		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
			System.out.println(hostname);
		}
		catch (UnknownHostException ex) {
			System.out.println("Hostname cannot be resolved!");
		}
		
		FTPClient ftp = new FTPClient();
		
		ftp.connect(URL);
		ftp.login(username, password);
		
		int reply = ftp.getReplyCode();
		
		if(!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			System.out.println("FTP Connection failed");
		}
		else {
			System.out.println("FTP Connection established!");
			ftp.mkd(hostname);
			ftp.changeWorkingDirectory(hostname);
		}
	}

}
