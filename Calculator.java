import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

     Float add(Float a, Float b) throws RemoteException;

     Float sub(Float a, Float b) throws RemoteException;

     Float mult(Float a, Float b) throws RemoteException;

     Float div(Float a, Float b) throws RemoteException;
}