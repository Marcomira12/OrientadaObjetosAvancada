package br.com.ucsal.olimpiadas.OperacaoInterna;
import br.com.ucsal.olimpiadas.*;
import br.com.ucsal.olimpiadas.Operacao.*;

public class EscolherProva{
	public Long escolherProva(Factory f) {
		System.out.println("\nProvas:");
		for (Prova p : f.getCadastraProva().getLista()) {
			System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
		}
		System.out.print("Escolha o id da prova: ");

		try {
		    Long id = Long.parseLong(f.getIn().nextLine());
			boolean existe = f.getCadastraProva().getLista().stream().anyMatch(p -> p.getId() == id);
			if (!existe) {
				System.out.println("id inválido");
				return null;
			}
			return id;
		} catch (Exception e) {
			System.out.println("entrada inválida");
			return null;
		}
	}


}
