package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarQuestao {
	CadastrarProva provas= new CadastrarProva();

	private static int proximaQuestaoId = 1;
	List<Questao> questoes = new ArrayList<>();
	
	public void cadastrarQuestao(Scanner in, EscolherProva escolherProva) {

		
		if (provas.provas.isEmpty()) {
			System.out.println("não há provas cadastradas");
			return;
		}

		Long provaId = escolherProva.escolherProva(in, provas);
		if (provaId == null)
			return;

		System.out.println("Enunciado:");
		var enunciado = in.nextLine();

		var alternativas = new String[5];
		for (int i = 0; i < 5; i++) {
			char letra = (char) ('A' + i);
			System.out.print("Alternativa " + letra + ": ");
			alternativas[i] = letra + ") " + in.nextLine();
		}

		System.out.print("Alternativa correta (A–E): ");
		char correta;
		try {
			correta = Questao.normalizar(in.nextLine().trim().charAt(0));
		} catch (Exception e) {
			System.out.println("alternativa inválida");
			return;
		}

		Questao q = new Questao();
		q.setId(proximaQuestaoId++);
		q.setProvaId(provaId);
		q.setEnunciado(enunciado);
		q.setAlternativas(alternativas);
		q.setAlternativaCorreta(correta);
		
		questoes.add(q);
		

		System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
	}
}
