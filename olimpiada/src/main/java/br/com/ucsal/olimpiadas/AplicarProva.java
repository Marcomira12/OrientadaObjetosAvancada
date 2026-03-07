package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicarProva {
	private long proximaTentativaId = 1;
	CadastrarParticipante participantes= new CadastrarParticipante();
	CadastrarProva provas= new CadastrarProva();
	EscolherProva escolherProva= new EscolherProva();
	CadastrarProva prova = new CadastrarProva();
	CadastrarQuestao questoes = new CadastrarQuestao();
	ImprimirTabuleiroFen imprimirTabuleiroFen = new ImprimirTabuleiroFen();
	CalcularNota calcularNota = new CalcularNota();
	ListarTentativa tentativas= new ListarTentativa();
	EscolherParticipante escolherParticipante= new EscolherParticipante();

	public void aplicarProva(Scanner in) {
		if (participantes.participantes.isEmpty()) {
			System.out.println("cadastre participantes primeiro");
			return;
		}
		if (provas.provas.isEmpty()) {
			System.out.println("cadastre provas primeiro");
			return;
		}

		var participanteId = escolherParticipante.escolherParticipante(in);
		if (participanteId == null)
			return;

		var provaId = escolherProva.escolherProva(in, prova);
		if (provaId == null)
			return;
		
		var questoesDaProva = questoes.questoes.stream().filter(q -> q.getProvaId() == provaId).toList();

		if (questoesDaProva.isEmpty()) {
			System.out.println("esta prova não possui questões cadastradas");
			return;
		}

		Tentativa tentativa = new Tentativa();
		tentativa.setId(proximaTentativaId++);
		tentativa.setParticipanteId(participanteId);
		tentativa.setProvaId(provaId);

		System.out.println("\n--- Início da Prova ---");

		for (var q : questoesDaProva) {
			System.out.println("\nQuestão #" + q.getId());
			System.out.println(q.getEnunciado());

			System.out.println("Posição inicial:");
			imprimirTabuleiroFen.imprimirTabuleiroFen(q.getFenInicial());

			for (var alt : q.getAlternativas()) {
			    System.out.println(alt);
			}

			System.out.print("Sua resposta (A–E): ");
			char marcada;
			try {
				marcada = Questao.normalizar(in.nextLine().trim().charAt(0));
			} catch (Exception e) {
				System.out.println("resposta inválida (marcando como errada)");
				marcada = 'X';
			}

			Resposta r = new Resposta();
			r.setQuestaoId(q.getId());
			r.setAlternativaMarcada(marcada);
			r.setCorreta(q.isRespostaCorreta(marcada));

			tentativa.getRespostas().add(r);
		}

		tentativas.tentativas.add(tentativa);

		int nota = calcularNota.calcularNota(tentativa);
		System.out.println("\n--- Fim da Prova ---");
		System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());
	}

	
}
