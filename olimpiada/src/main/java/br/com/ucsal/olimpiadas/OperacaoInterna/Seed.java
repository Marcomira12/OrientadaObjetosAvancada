package br.com.ucsal.olimpiadas.OperacaoInterna;

import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.Operacao.CadastrarProva;
import br.com.ucsal.olimpiadas.Operacao.Factory;

public class Seed {
	
	private int proximaQuestaoId = 1;
	
	public void seed(Factory f) {

		Prova prova = new Prova();
		
		prova.setId(f.getCadastraProva().getProximaProvaId()+1);
		prova.setTitulo("Olimpíada 2026 • Nível 1 • Prova A");
		
		f.getCadastraProva().getLista().add(prova);
		var q1 = new Questao();
		q1.setId(proximaQuestaoId++);
		q1.setProvaId(prova.getId());

		q1.setEnunciado("""
				Questão 1 — Mate em 1.
				É a vez das brancas.
				Encontre o lance que dá mate imediatamente.
				""");

		q1.setFenInicial("6k1/5ppp/8/8/8/7Q/6PP/6K1 w - - 0 1");

		q1.setAlternativas(new String[] { "A) Qh7#", "B) Qf5#", "C) Qc8#", "D) Qh8#", "E) Qe6#" });

		q1.setAlternativaCorreta('C');

		f.getCadastrarQuestao().getLista().add(q1);
	}
}
