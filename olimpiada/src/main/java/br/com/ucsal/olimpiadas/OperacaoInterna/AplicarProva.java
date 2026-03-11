package br.com.ucsal.olimpiadas.OperacaoInterna;
import br.com.ucsal.olimpiadas.*;
import br.com.ucsal.olimpiadas.Operacao.Acao;
import br.com.ucsal.olimpiadas.Operacao.Factory;

public class AplicarProva extends Acao {
	private int proximaTentativaId = 1;

	@Override
	public void executar(Factory f) {

		if (f.getCadastrar().getParticipantes().isEmpty()) {
			System.out.println("cadastre participantes primeiro");
			return;
		}
		if (f.getCadastraProva().getProvas().isEmpty()) {
			System.out.println("cadastre provas primeiro");
			return;
		}

		var participanteId = f.getEscolherParticipante().escolherParticipante(f);
		if (participanteId == null)
			return;

		var provaId = f.getEscolherProva().escolherProva(f.getIn(), f.getCadastraProva());
		if (provaId == null)
			return;

		var questoesDaProva = f.getCadastrarQuestao().getQuestoes().stream().filter(q -> q.getProvaId() == provaId).toList();

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

			//System.out.println("Posição inicial:");
			//f.getTabuleiro().imprimirTabuleiroFen(q.getFenInicial());

			for (var alt : q.getAlternativas()) {
				System.out.println(alt);
			}

			System.out.print("Sua resposta (A–E): ");
			char marcada;
			try {
				marcada = Questao.normalizar(f.getIn().nextLine().trim().charAt(0));
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

		f.getTentativas().getTentativas().add(tentativa);

		int nota = f.getCalcularNota().calcularNota(tentativa);
		System.out.println("\n--- Fim da Prova ---");
		System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());
	}

}
