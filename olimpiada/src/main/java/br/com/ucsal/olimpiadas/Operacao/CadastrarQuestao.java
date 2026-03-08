package br.com.ucsal.olimpiadas.Operacao;
import br.com.ucsal.olimpiadas.*;

import java.util.ArrayList;
import java.util.List;

public class CadastrarQuestao extends Acao{
	

	private static int proximaQuestaoId = 1;
	private static List<Questao> questoes = new ArrayList<>();

	public static int getProximaQuestaoId() {
		return proximaQuestaoId;
	}

	@Override
	public void executar(Factory f) {
		if (f.getCadastraProva().getProvas().isEmpty()) {
			System.out.println("não há provas cadastradas");
			return;
		}

		Long provaId = f.getEscolherProva().escolherProva(f.getIn(), f.getCadastraProva());
		if (provaId == null)
			return;

		System.out.println("Enunciado:");
		var enunciado = f.getIn().nextLine();

		var alternativas = new String[5];
		for (int i = 0; i < 5; i++) {
			char letra = (char) ('A' + i);
			System.out.print("Alternativa " + letra + ": ");
			alternativas[i] = letra + ") " + f.getIn().nextLine();
		}

		System.out.print("Alternativa correta (A–E): ");
		char correta;
		try {
			correta = Questao.normalizar(f.getIn().nextLine().trim().charAt(0));
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
		
		getQuestoes().add(q);
		

		System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
		
	}

	public static List<Questao> getQuestoes() {
		return questoes;
	}

	public static void setQuestoes(List<Questao> questoes) {
		CadastrarQuestao.questoes = questoes;
	}
}
