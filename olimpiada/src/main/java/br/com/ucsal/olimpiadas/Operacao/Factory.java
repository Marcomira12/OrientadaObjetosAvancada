package br.com.ucsal.olimpiadas.Operacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.com.ucsal.olimpiadas.OperacaoInterna.CalcularNota;
import br.com.ucsal.olimpiadas.OperacaoInterna.EscolherParticipante;
import br.com.ucsal.olimpiadas.OperacaoInterna.EscolherProva;
import br.com.ucsal.olimpiadas.OperacaoInterna.ImprimirTabuleiroFen;
import br.com.ucsal.olimpiadas.OperacaoInterna.Seed;

public class Factory {
	private Scanner in = new Scanner(System.in);
	private CadastrarParticipante cadastrar = new CadastrarParticipante();
	private CadastrarProva cadastraProva = new CadastrarProva();
	private CadastrarQuestao cadastrarQuestao = new CadastrarQuestao();
	private EscolherProva escolherProva = new EscolherProva();
	private AplicarProva aplicarProva = new AplicarProva();
	private ListarTentativa tentativas = new ListarTentativa();
	private Seed seed= new Seed();
	private CalcularNota calcularNota = new CalcularNota();
	private EscolherParticipante escolherParticipante = new EscolherParticipante();
	private ImprimirTabuleiroFen tabuleiro = new ImprimirTabuleiroFen();

	private static final List<Acao> lista = new ArrayList<>();

	
	public Factory() {
		if (lista.isEmpty()) {
			lista.add(cadastrar);
			lista.add(cadastraProva);
			lista.add(cadastrarQuestao);
			lista.add(aplicarProva);
			lista.add(tentativas);
		}
	}

	public static List<Acao> getLista() {
        return Collections.unmodifiableList(lista);
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
