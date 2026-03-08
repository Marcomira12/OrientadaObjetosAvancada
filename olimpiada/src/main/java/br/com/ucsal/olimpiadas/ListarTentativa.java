package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;

public class ListarTentativa extends Acao{
	static List<Tentativa> tentativas = new ArrayList<>();
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
