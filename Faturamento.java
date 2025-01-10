import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Faturamento {
    public static void main(String[] args) {
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;
        int diasSuperiorMedia = 0;

        try {
            // Carrega e analisa o XML
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new File("faturamento.xml"));

            NodeList dias = document.getElementsByTagName("dia");

            // Processa os dados de faturamento
            for (int i = 0; i < dias.getLength(); i++) {
                Element dia = (Element) dias.item(i);
                double faturamento = Double.parseDouble(dia.getElementsByTagName("valor").item(0).getTextContent());

                if (faturamento > 0) {
                    somaFaturamento += faturamento;
                    diasComFaturamento++;
                    menorFaturamento = Math.min(menorFaturamento, faturamento);
                    maiorFaturamento = Math.max(maiorFaturamento, faturamento);
                }
            }

            // Calcula a média mensal
            double mediaMensal = somaFaturamento / diasComFaturamento;

            // Conta os dias com faturamento superior à média
            for (int i = 0; i < dias.getLength(); i++) {
                double faturamento = Double.parseDouble(((Element) dias.item(i))
                        .getElementsByTagName("valor").item(0).getTextContent());
                if (faturamento > mediaMensal) diasSuperiorMedia++;
            }

            // Exibe os resultados
            System.out.println("Menor faturamento do mês: " + menorFaturamento);
            System.out.println("Maior faturamento do mês: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento superior à média mensal: " + diasSuperiorMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
