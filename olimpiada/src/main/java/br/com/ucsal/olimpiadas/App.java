package br.com.ucsal.olimpiadas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	
	
	

	static long proximaQuestaoId = 1;
	static long proximaTentativaId = 1;

	static final List<Tentativa> tentativas = new ArrayList<>();


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CadastrarParticipante cadastrar= new CadastrarParticipante();
		CadastrarProva cadastraProva = new CadastrarProva();
		CadastrarQuestao cadastrarQuestao = new CadastrarQuestao();
		EscolherProva escolherProva= new EscolherProva();
		AplicarProva aplicarProva= new AplicarProva();
		seed();

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
			case "5" -> listarTentativas();
			case "0" -> {
				System.out.println("tchau");
				return;
			}
			default -> System.out.println("opção inválida");
			}
		}
	}

	

	

	


	

	public static int calcularNota(Tentativa tentativa) {
		int acertos = 0;
		for (var r : tentativa.getRespostas()) {
			if (r.isCorreta())
				acertos++;
		}
		return acertos;
	}

	static void listarTentativas() {
		System.out.println("\n--- Tentativas ---");
		for (var t : tentativas) {
			System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(),
					t.getProvaId(), calcularNota(t), t.getRespostas().size());
		}
	}


	

	static Long escolherProva() {
		System.out.println("\nProvas:");
		for (var p : provas) {
			System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
		}
		System.out.print("Escolha o id da prova: ");

		try {
			long id = Long.parseLong(in.nextLine());
			boolean existe = provas.stream().anyMatch(p -> p.getId() == id);
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

	static void imprimirTabuleiroFen(String fen) {

		String parteTabuleiro = fen.split(" ")[0];
		String[] ranks = parteTabuleiro.split("/");

		System.out.println();
		System.out.println("    a b c d e f g h");
		System.out.println("   -----------------");

		for (int r = 0; r < 8; r++) {

			String rank = ranks[r];
			System.out.print((8 - r) + " | ");

			for (char c : rank.toCharArray()) {

				if (Character.isDigit(c)) {
					int vazios = c - '0';
					for (int i = 0; i < vazios; i++) {
						System.out.print(". ");
					}
				} else {
					System.out.print(c + " ");
				}
			}

			System.out.println("| " + (8 - r));
		}

		System.out.println("   -----------------");
		System.out.println("    a b c d e f g h");
		System.out.println();
	}


	static void seed() {

		var prova = new Prova();
		prova.setId(proximaProvaId++);
		prova.setTitulo("Olimpíada 2026 • Nível 1 • Prova A");
		provas.add(prova);

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

		questoes.add(q1);
	}
}