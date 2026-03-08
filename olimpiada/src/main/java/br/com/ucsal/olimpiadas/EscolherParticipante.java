package br.com.ucsal.olimpiadas;

import java.util.Scanner;

public class EscolherParticipante {
	private Factory f;

	public EscolherParticipante(Factory f) {
		this.f = f;
	}

	public Long escolherParticipante(Scanner in) {
		System.out.println("\nParticipantes:");
		for (var p : f.getCadastrar().participantes) {
			System.out.printf("  %d) %s%n", p.getId(), p.getNome());
		}
		System.out.print("Escolha o id do participante: ");

		try {
			long id = Long.parseLong(in.nextLine());
			boolean existe = f.getCadastrar().participantes.stream().anyMatch(p -> p.getId() == id);
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
