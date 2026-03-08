package br.com.ucsal.olimpiadas;

public class AplicarProva extends Acao {
	private long proximaTentativaId = 1;

	@Override
	public void executar(Factory f) {

		if (f.getCadastrar().participantes.isEmpty()) {
			System.out.println("cadastre participantes primeiro");
			return;
		}
		if (f.getCadastraProva().provas.isEmpty()) {
			System.out.println("cadastre provas primeiro");
			return;
		}

		var participanteId = f.getEscolherParticipante().escolherParticipante(f.getIn());
		if (participanteId == null)
			return;

		var provaId = f.getEscolherProva().escolherProva(f.getIn(), f.getCadastraProva());
		if (provaId == null)
			return;

		var questoesDaProva = f.getCadastrarQuestao().questoes.stream().filter(q -> q.getProvaId() == provaId).toList();

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
			f.getTabuleiro().imprimirTabuleiroFen(q.getFenInicial());

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

		f.getTentativas().tentativas.add(tentativa);

		int nota = f.getCalcularNota().calcularNota(tentativa);
		System.out.println("\n--- Fim da Prova ---");
		System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());
	}

}
