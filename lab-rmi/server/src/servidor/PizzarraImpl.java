package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PizzarraImpl extends UnicastRemoteObject
    implements Pizzarra {
    
    List<String> lista = new ArrayList<String>();
    List<String> ciudadLista = new ArrayList<String>();
    
    public PizzarraImpl() throws RemoteException {
        super();
    }

    @Override
    public String registrarPintor(String codigoPintor) throws RemoteException {

        if(lista.contains(codigoPintor)){
            System.out.println("El pintor "+ codigoPintor+ " ya existe.");
            return "YA_REGISTRADO";            
        }else{
            lista.add(codigoPintor);
            System.out.println("Pintor "+ codigoPintor+ " Registrado.");
            return "OK";
        }
        
    }
    public String registrarCiudad(String codigoCiudad) throws RemoteException {

        if(ciudadLista.contains(codigoCiudad)){
            System.out.println("La ciudad "+ codigoCiudad+ " ya existe.");
            return "YA_REGISTRADO";            
        }else{
            ciudadLista.add(codigoCiudad);
            System.out.println("Ciudad "+ codigoCiudad+ " Registrada.");
            return "OK";
        }
        
    }
    
    public List<String> verPintores() throws RemoteException {
        return lista;
    }
    public List<String> verCiudad() throws RemoteException {
        return ciudadLista;
    }
    
    public Integer cantidadPintores() throws RemoteException {
        if(lista != null) {
        	return lista.size();
        }else{
        	return 0; 
        }
    }

    public Integer cantidadCiudades() throws RemoteException {
        if(ciudadLista != null) {
        	return ciudadLista.size();
        }else{
        	return 0; 
        }
    }
}
