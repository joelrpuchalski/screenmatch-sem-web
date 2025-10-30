package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    private final String ENDERECO= "https://www.omdbapi.com/?t=";
    private final String API_KEY= "8b4ac283";
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() throws Exception{
        System.out.println("Digite a série para buscar:");
        var nomeSerie = leitura.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&apikey=" + API_KEY);
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas =  new ArrayList<>();

            for (int temporada = 1; temporada <= dadosSerie.totalTemporadas(); temporada++) {
                json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + temporada + "&apikey=" + API_KEY);
                var dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
	}

        temporadas.forEach(System.out::println);
    }

}
