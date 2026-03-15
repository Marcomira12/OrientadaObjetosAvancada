package br.com.ucsal.olimpiadas.Operacao;
import br.com.ucsal.olimpiadas.*;

public class CadastrarParticipante extends Acao<Participante> {
	private int proximoParticipanteId = 1;


	@Override
	public void executar(Factory f) {
		System.out.print("Nome: ");
		String nome = f.getIn().nextLine();

		System.out.print("Email (opcional): ");
		String email = f.getIn().nextLine();

		if (nome == null || nome.isBlank()) {
			System.out.println("nome inválido");
			return;
		}
		Participante p = new Participante();
		p.setId(proximoParticipanteId++);
		p.setNome(nome);
		p.setEmail(email);
		lista.add(p);

		System.out.println("Participante cadastrado: " + p);
		
	}


	
}
