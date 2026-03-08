package br.com.ucsal.olimpiadas.Operacao;

import br.com.ucsal.olimpiadas.*;
import br.com.ucsal.olimpiadas.OperacaoInterna.CalcularNota;

import java.util.ArrayList;
import java.util.List;

public class ListarTentativa extends Acao {
	private static List<Tentativa> tentativas = new ArrayList<>();

	public static List<Tentativa> getTentativas() {
		return tentativas;
	}

	CalcularNota calcularNota = new CalcularNota();

	@Override
	public void executar(Factory f) {
		System.out.println("\n--- Tentativas ---");
		for (var t : tentativas) {
			System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(),
					t.getProvaId(), f.getCalcularNota().calcularNota(t), t.getRespostas().size());
		}

	}

}
