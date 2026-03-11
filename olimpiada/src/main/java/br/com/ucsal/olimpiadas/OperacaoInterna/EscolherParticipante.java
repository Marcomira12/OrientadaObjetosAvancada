package br.com.ucsal.olimpiadas.OperacaoInterna;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.Operacao.Factory;

public class EscolherParticipante {

	public Integer escolherParticipante(Factory f) {
		System.out.println("\nParticipantes:");
		for (var p : f.getCadastrar().getLista()) {
			System.out.printf("  %d) %s%n", p.getId(), p.getNome());
		}
		System.out.print("Escolha o id do participante: ");

		try {
			int id = f.getIn().nextInt();
			boolean existe = f.getCadastrar().getParticipantes().stream().anyMatch(p -> p.getId() == id);
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
