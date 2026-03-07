package br.com.ucsal.olimpiadas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	
	
	

	static long proximaQuestaoId = 1;



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CadastrarParticipante cadastrar= new CadastrarParticipante();
		CadastrarProva cadastraProva = new CadastrarProva();
		CadastrarQuestao cadastrarQuestao = new CadastrarQuestao();
		EscolherProva escolherProva= new EscolherProva();
		AplicarProva aplicarProva= new AplicarProva();
		ListarTentativa tentativas= new ListarTentativa();
		Seed seed = new Seed();
		seed.seed();

		while (true) {
			System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
			System.out.println("1) Cadastrar participante");
			System.out.println("2) Cadastrar prova");
			System.out.println("3) Cadastrar questão (A–E) em uma prova");
			System.out.println("4) Aplicar prova (selecionar participante + prova)");
			System.out.println("5) Listar tentativas (resumo)");
			System.out.println("0) Sair");
			System.out.print("> ");

			switch (in.nextLine()) {
			case "1" -> cadastrar.cadastrarParticipante(in);
			case "2" -> cadastraProva.cadastrarProva(in);
			case "3" -> cadastrarQuestao.cadastrarQuestao(in,escolherProva );
			case "4" -> aplicarProva.aplicarProva(in);
			case "5" -> tentativas.listarTentativas();
			case "0" -> {
				System.out.println("tchau");
				return;
			}
			default -> System.out.println("opção inválida");
			}
		}
	}

	
	
}