package claude.task108;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface RemoteObject extends Remote {
    int getValue() throws RemoteException;
    void setValue(int value) throws RemoteException;
}

class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObject {
    private int value;

    public RemoteObjectImpl() throws RemoteException {
        super();
        this.value = 0;
    }

    public int getValue() throws RemoteException {
        return value;
    }

    public void setValue(int value) throws RemoteException {
        this.value = value;
    }
}

public class Task108_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        try {
            RemoteObject obj = new RemoteObjectImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteObject", obj);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
