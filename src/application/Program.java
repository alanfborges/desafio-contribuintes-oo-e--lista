package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            System.out.println("Digite os dados do " + i + "° contribuinte: ");
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double serviceIncome = sc.nextDouble();
            System.out.print("Renda anula com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            list.add(new TaxPayer(salaryIncome, serviceIncome,
                    capitalIncome, healthSpending, educationSpending));
        }

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Resumo do " + (i + 1) + "° contribuinte: ");
            System.out.println(list.get(i));
        }
    }
}
