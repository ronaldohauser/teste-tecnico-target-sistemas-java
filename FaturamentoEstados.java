public class FaturamentoEstados {
    public static void main(String[] args) {
        // Faturamento por estado
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        // Calculando o faturamento total
        double totalFaturamento = sp + rj + mg + es + outros;

        // Calculando e exibindo o percentual de cada estado com 2 casas decimais
        System.out.println("% de representação de cada estado no faturamento mensal:");

        System.out.println("SP: " + String.format("%.2f", (sp / totalFaturamento) * 100) + "%");
        System.out.println("RJ: " + String.format("%.2f", (rj / totalFaturamento) * 100) + "%");
        System.out.println("MG: " + String.format("%.2f", (mg / totalFaturamento) * 100) + "%");
        System.out.println("ES: " + String.format("%.2f", (es / totalFaturamento) * 100) + "%");
        System.out.println("Outros: " + String.format("%.2f", (outros / totalFaturamento) * 100) + "%");
    }
}
