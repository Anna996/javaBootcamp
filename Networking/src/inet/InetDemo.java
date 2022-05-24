package inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {
	public static void main(String[] args) throws UnknownHostException {
		// obtain the ip of your own 
		InetAddress myAddress = InetAddress.getLocalHost();
		System.out.println(myAddress);
		
		String myIp = myAddress.getHostAddress();
		String myHostName = myAddress.getHostName();
		System.out.println("my ip: %s , my host name: %s".formatted(myIp, myHostName));
		
		// get InetAddress from name
		InetAddress queryByHostNameAddress = InetAddress.getByName(myHostName);
		System.out.println(queryByHostNameAddress);
		
		InetAddress queryByHostIPAddress = InetAddress.getByName(myIp);
		System.out.println(queryByHostIPAddress);
		
		InetAddress queryByWebsiteAddress = InetAddress.getByName("google.com");
		System.out.println(queryByWebsiteAddress);
		
		// get all addreses of server
		
		InetAddress[] addresses = InetAddress.getAllByName("google.com");
		System.out.println(Arrays.toString(addresses));
		
		// loopback address
		InetAddress myLoop = InetAddress.getLoopbackAddress();
		System.out.println(myLoop);
		
		findHitAddress();
		findFacebookAddress();
	}
	
	public static void findHitAddress() throws UnknownHostException {
		 InetAddress hit= InetAddress.getByName("hit.ac.il");
		 String ip = hit.getHostAddress();
		 String name = hit.getHostName();
		 System.out.println("Hit ip: %s , address: %s".formatted(ip, name));
	}
	
	public static void findFacebookAddress() throws UnknownHostException {
		InetAddress facebook = InetAddress.getByName("facebook.com");
		String ip = facebook.getHostAddress();
		String name = facebook.getHostName();
		System.out.println("Facebook ip: %s , address: %s".formatted(ip, name));
	}
}
