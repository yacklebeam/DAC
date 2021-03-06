package blackdoor.cqbe.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import blackdoor.cqbe.cli.dh256;

public class CLITester {

	public static void main(String[] args) throws Exception, IOException {
		InetAddress address;

			URL whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));
			address = InetAddress.getByName(in.readLine());
		
		addSettings();
		//String[] args2 = {"retrieve", "8E:3F:08:DF:93:E5:0C:50:EB:59:25:58:88:38:8F:00", "-d", "yay.txt", "-b",address.getHostAddress() + ":1776"};
		//String[] args2 = {"insert","file.txt","-b", address.getHostAddress() + ":1776"};
		//String[] args2 = {"join",address.getHostAddress() + ":1776","-s","savefile.txt"};
		//String[] args2 = {"join","-a"};
		String[] args2 = {"join", address.getHostAddress() + ":1776","-p","1779","-dm"};
		//String[] args2 = {"join", address.getHostAddress() + ":1776","-p","1780"};
		//String[] args2 = {"join", address.getHostAddress() + ":1776","-p","1781"};
		//String[] args2 = {"join", address.getHostAddress() + ":1776","-p","1782"};
		//String[] args2 = {"join", address.getHostAddress() + ":1776","-p","1783"};
		//String[] args2 = {"shutdown", "-p", "1776"};
		dh256.main(args2);

	}
	
	public static void addSettings() {
		File theDir = new File("NodeStorage");
		if (!theDir.exists()) {
		    try{
		        theDir.mkdir();
		     } catch(SecurityException se){}        
		  }	
	}

}