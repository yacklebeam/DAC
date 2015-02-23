package blackdoor.cqbe.test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.NavigableSet;

import blackdoor.cqbe.addressing.Address;
import blackdoor.cqbe.addressing.CASFileAddress;
import blackdoor.cqbe.addressing.L3Address;
import blackdoor.cqbe.node.Node;
import blackdoor.cqbe.node.Node.NodeBuilder;
import blackdoor.cqbe.storage.StorageController;

public class PullTesterCliant {

	public static void main(String[] args) throws Exception, IOException {
		NodeBuilder node = new NodeBuilder();
		//node.setBootstrapNode(new L3Address(InetAddress.getByName("127.0.0.1"), 1778));
		node.setPort(1778);
		node.buildNode();
		Node.getAddressTable().add(new L3Address(InetAddress.getByName("192.168.5.2"), 1775));
		StorageController c = Node.getStorageController();
		for(int i = 0; i<10; i++){
			c.put(new CASFileAddress(new File("NodeStorage/"+new Integer(i).toString()+".boop")));
		}
	}
}