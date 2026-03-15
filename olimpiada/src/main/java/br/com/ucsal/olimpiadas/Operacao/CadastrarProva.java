package br.com.ucsal.olimpiadas.Operacao;
import br.com.ucsal.olimpiadas.*;


public class CadastrarProva extends Acao<Prova> {

	private int proximaProvaId = 1;

	public int getProximaProvaId() {
		return proximaProvaId;
	}

	@Override
	public void executar(Factory f) {
		System.out.print("Título da prova: ");
		String titulo = f.getIn().nextLine();

		if (titulo == null || titulo.isBlank()) {
			System.out.println("título inválido");
			return;
		}

		Prova prova = new Prova();
		prova.setId(proximaProvaId++);
		prova.setTitulo(titulo);

		lista.add(prova);
		System.out.println("Prova criada: " + prova.getId());
	}
}
