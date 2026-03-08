package br.com.ucsal.olimpiadas;

public class App {

	public static void main(String[] args) {
		Factory ope = new Factory();
		ope.getSeed().seed();;

		while (true) {
			System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
			System.out.println("1) Cadastrar participante");
			System.out.println("2) Cadastrar prova");
			System.out.println("3) Cadastrar questão (A–E) em uma prova");
			System.out.println("4) Aplicar prova (selecionar participante + prova)");
			System.out.println("5) Listar tentativas (resumo)");
			System.out.println("0) Sair");
			System.out.print("> ");

			int comandoDigitado = Integer.parseInt(ope.getIn().nextLine());
			
			if (comandoDigitado == 0) {
			    System.out.println("tchau");
			    return;
			}
			
			if (comandoDigitado >= 1 && comandoDigitado <= ope.getLista().size()) {
				ope.getLista().get(comandoDigitado - 1).executar(ope);
			} else {
				System.out.println("opção inválida");
			}
		}

	}
}