package com.iff.livraria.controller;

import com.iff.livraria.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

public class GraficoController implements Initializable {

    @FXML
    private PieChart graficopizza;
    @FXML
    private Button btnVoltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int n;
        int qtdLivrosLidos = SecaoController.qtdLivrosLidos;
        int qtdLivros = SecaoController.qtdLivros;

        PieChart.Data slice1 = new PieChart.Data("Lidos", qtdLivrosLidos);
        n = qtdLivros - qtdLivrosLidos;
        PieChart.Data slice2 = new PieChart.Data("Não-Lidos", n);

        // Adicionando os dados ao gráfico
        graficopizza.getData().addAll(slice1, slice2);

        // Calculando as porcentagens
        double total = qtdLivros;
        double percLidos = (qtdLivrosLidos / total) * 100;
        double percNaoLidos = (n / total) * 100;

        // Adicionando as porcentagens como labels
        slice1.setName(String.format("Lidos: %.1f%%", percLidos));
        slice2.setName(String.format("Não-Lidos: %.1f%%", percNaoLidos));

        // Estilizando o título do gráfico
        graficopizza.setTitle("Categorias de Livros");
        graficopizza.lookup(".chart-title").setStyle(
                "-fx-font-size: 18px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: white;"); // Estilo para o título do gráfico
    }

    @FXML
    private void OnActionbtnVoltar(ActionEvent event) throws IOException {
        App.setRoot("view/Menu");
    }
}

