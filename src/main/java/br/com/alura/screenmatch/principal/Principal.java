package br.com.alura.screenmatch.principal;

import java.util.Scanner;

import br.com.alura.screenmatch.service.ConsumoApi;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO= "https://www.omdbapi.com/?t=";
    private final String API_KEY= "8b4ac283";

    public void exibeMenu(){
        System.out.println("Digite a série para buscar:");
        var nomeSerie = leitura.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&apikey=" + API_KEY);
    }

    //https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1&apikey=8b4ac283

}
