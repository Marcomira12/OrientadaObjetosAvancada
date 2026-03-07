package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarProva {

	List<Prova> provas = new ArrayList<>();

	private int proximaProvaId = 1;

	public void cadastrarProva(Scanner in) {
		System.out.print("Título da prova: ");
		String titulo = in.nextLine();

		if (titulo == null || titulo.isBlank()) {
			System.out.println("título inválido");
			return;
		}

		Prova prova = new Prova();
		prova.setId(proximaProvaId++);
		prova.setTitulo(titulo);

		provas.add(prova);
		System.out.println("Prova criada: " + prova.getId());
	}
}
