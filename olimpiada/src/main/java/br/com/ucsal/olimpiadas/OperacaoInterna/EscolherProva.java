package br.com.ucsal.olimpiadas.OperacaoInterna;
import br.com.ucsal.olimpiadas.*;
import br.com.ucsal.olimpiadas.Operacao.*;

import java.util.Scanner;

public class EscolherProva{
	public Long escolherProva(Scanner in, CadastrarProva provas) {
		System.out.println("\nProvas:");
		for (Prova p : provas.getProvas()) {
			System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
		}
		System.out.print("Escolha o id da prova: ");

		try {
			long id = Integer.parseInt(in.nextLine());
			boolean existe = provas.getProvas().stream().anyMatch(p -> p.getId() == id);
			if (!existe) {
				System.out.println("id inválido");
				return null;
			}
			return id;
		} catch (Exception e) {
			System.out.println("entrada inválida");
			return null;
		}
	}


}
