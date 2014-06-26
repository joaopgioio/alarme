package com.terremoto.alarme;

import java.rmi.RemoteException;

public interface Rede {

	void enviar(Pacote pacote) throws RemoteException;

	boolean abrirConexao(String ip);

}
