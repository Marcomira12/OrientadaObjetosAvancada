package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;

public class CadastrarParticipante extends Acao {
	private int proximoParticipanteId = 1;


	static List<Participante> participantes = new ArrayList<>();


	@Override
	public void executar(Factory f) {
		System.out.print("Nome: ");
		String nome = f.getIn().nextLine();

		System.out.print("Email (opcional): ");
		String email = f.getIn().nextLine();

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
