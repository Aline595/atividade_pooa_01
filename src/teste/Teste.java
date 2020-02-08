package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.Empregado;
import modelo.EmpregadoDois;
import modelo.EmpregadoQuatro;
import modelo.EmpregadoTres;

public class Teste {

    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        Random gerador = new Random();

        //Trecho 1 - Listagem 3
        for (int i = 0; i < 10; i++) {
            int tipo = 1 + gerador.nextInt(4);
            empregados.add(new Empregado(tipo));
            if (tipo == 1) {
                double salario = 1500 + gerador.nextDouble() * 3500;
                empregados.get(i).setSalario(salario);
            } else if (tipo == 2) {
                double salario = 1200 + gerador.nextDouble() * 1000;
                double percentualComissao = gerador.nextDouble();
                empregados.get(i).setSalario(salario);
                empregados.get(i).setPercentualComissao(percentualComissao);
            } else if (tipo == 3) {
                double salario = 1100 + gerador.nextDouble() * 700;
                double percentualComissao = 0.2 + gerador.nextDouble() * 0.5;
                double bonus = 100;
                empregados.get(i).setSalario(salario);
                empregados.get(i).setPercentualComissao(percentualComissao);
                empregados.get(i).setBonus(bonus);
            } else {
                double bonus = 2000 + gerador.nextDouble() * 2500;
                empregados.get(i).setBonus(bonus);
            }
        }

        //Trecho 2 - Listagem 4
        for (Empregado e : empregados) {
            System.out.println("Tipo do empregado" + e.getTipo());
            System.out.println("Salario a receber: ");
            double salarioFinal = 0;
            if (e.getTipo() == 1) {
                salarioFinal = e.getSalario();
            } else if (e.getTipo() == 2) {
                salarioFinal = e.getSalario() + e.getSalario() * e.getPercentualComissao();
            } else if (e.getTipo() == 3) {
                salarioFinal = e.getSalario() + e.getSalario() + e.getPercentualComissao() + e.getBonus();
            } else if (e.getTipo() == 4) {
                salarioFinal = e.getBonus();
            }
            System.out.println(String.format("%.2f", salarioFinal));
        }
    }
}