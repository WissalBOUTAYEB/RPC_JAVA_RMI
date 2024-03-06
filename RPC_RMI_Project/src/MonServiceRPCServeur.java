import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MonServiceRPCServeur extends UnicastRemoteObject implements MonServiceRPCInterface {
    protected MonServiceRPCServeur() throws RemoteException {
        super();
    }

    @Override
    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public static void main(String[] args) {
        try {
            MonServiceRPCInterface monService = new MonServiceRPCServeur();
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
            registry.rebind("MonServiceRPC", monService);
            System.out.println("Serveur RPC prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
