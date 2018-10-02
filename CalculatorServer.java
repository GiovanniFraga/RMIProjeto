import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements Calculator
{

    protected CalculatorServer() throws RemoteException {
    }

    public static void main(String[] args)
    {
        try
        {
            Calculator c = new CalculatorServer();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi:///CalculatorService", c);
            System.out.println("Ligado no registro");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public Float add(Float a, Float b) throws RemoteException {
        System.out.println(a+" + "+b+"="+(a+b));
        return a + b;
    }

    @Override
    public Float sub(Float a, Float b) throws RemoteException {
        System.out.println(a+" - "+b+"="+(a-b));
        return a - b;
    }

    @Override
    public Float mult(Float a, Float b) throws RemoteException {
        System.out.println(a+" * "+b+"="+(a*b));
        return a * b;
    }

    @Override
    public Float div(Float a, Float b) throws RemoteException {
        System.out.println(a+" / "+b+"="+(a/b));
        return a / b;
    }




}