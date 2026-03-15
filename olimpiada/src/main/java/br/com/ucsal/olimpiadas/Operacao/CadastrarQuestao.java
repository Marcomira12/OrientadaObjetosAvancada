package br.com.ucsal.olimpiadas.Operacao;
import br.com.ucsal.olimpiadas.*;


public class CadastrarQuestao extends Acao<Questao>{
	

	private static int proximaQuestaoId = 1;
	public static int getProximaQuestaoId() {
		return proximaQuestaoId;
	}

	@Override
	public void executar(Factory f) {
		if (f.getCadastraProva().lista.isEmpty()) {
			System.out.println("não há provas cadastradas");
			return;
		}

		Long provaId = f.getEscolherProva().escolherProva(f);
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
		
		lista.add(q);
		

		System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
		
	}

}
