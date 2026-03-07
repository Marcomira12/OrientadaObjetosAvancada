package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarParticipante {
	private int proximoParticipanteId = 1;


	static List<Participante> participantes = new ArrayList<>();

	public void cadastrarParticipante(Scanner in) {
		System.out.print("Nome: ");
		var nome = in.nextLine();

		System.out.print("Email (opcional): ");
		var email = in.nextLine();

		if (nome == null || nome.isBlank()) {
			System.out.println("nome inválido");
			return;
		}
		Participante p = new Participante();
		p.setId(proximoParticipanteId++);
		p.setNome(nome);
		p.setEmail(email);
		participantes.add(p);

		System.out.println("Participante cadastrado: " + p);
	}
}
