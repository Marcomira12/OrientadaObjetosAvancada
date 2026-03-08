package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factory {
	private Scanner in = new Scanner(System.in);
	private CadastrarParticipante cadastrar = new CadastrarParticipante();
	private CadastrarProva cadastraProva = new CadastrarProva();
	private CadastrarQuestao cadastrarQuestao = new CadastrarQuestao();
	private EscolherProva escolherProva = new EscolherProva();
	private AplicarProva aplicarProva = new AplicarProva();
	private ListarTentativa tentativas = new ListarTentativa();
	private Seed seed;
	private CalcularNota calcularNota = new CalcularNota();
	private EscolherParticipante escolherParticipante;
	private ImprimirTabuleiroFen tabuleiro = new ImprimirTabuleiroFen();

	public Factory() {
		this.seed = new Seed(this);
		this.escolherParticipante = new EscolherParticipante(this);
		if (lista.isEmpty()) {
			lista.add(cadastrar);
			lista.add(cadastraProva);
			lista.add(cadastrarQuestao);
			lista.add(aplicarProva);
			lista.add(tentativas);
		}
	}

	static final List<Acao> lista = new ArrayList<>();

	public static List<Acao> getLista() {
		return lista;
	}

	public ImprimirTabuleiroFen getTabuleiro() {
		return tabuleiro;
	}

	public EscolherParticipante getEscolherParticipante() {
		return escolherParticipante;
	}

	public CalcularNota getCalcularNota() {
		return calcularNota;
	}

	public Scanner getIn() {
		return in;
	}

	public CadastrarParticipante getCadastrar() {
		return cadastrar;
	}

	public CadastrarProva getCadastraProva() {
		return cadastraProva;
	}

	public CadastrarQuestao getCadastrarQuestao() {
		return cadastrarQuestao;
	}

	public EscolherProva getEscolherProva() {
		return escolherProva;
	}

	public AplicarProva getAplicarProva() {
		return aplicarProva;
	}

	public ListarTentativa getTentativas() {
		return tentativas;
	}

	public Seed getSeed() {
		return seed;
	}

	

}
