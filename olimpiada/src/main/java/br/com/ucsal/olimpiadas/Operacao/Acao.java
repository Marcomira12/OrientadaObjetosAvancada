package br.com.ucsal.olimpiadas.Operacao;

import java.util.ArrayList;
import java.util.List;


public abstract class Acao <T>{
	public abstract void executar(Factory f);
	List<T> lista = new ArrayList<>();
	public List<T> getLista() {
		return lista;
	}
	
}
