package project5.application;

import project5.entities.LegalPerson;
import project5.entities.NaturalPerson;
import project5.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        System.out.print("Insira o número de contribuintes: ");
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            System.out.print("Pessoa Física ou Pessoa Jurídica? (f/j))");
            char ans = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Rendimento anual: ");
            double annualIncome = sc.nextDouble();
            if (ans == 'f') {
                System.out.print("Despesas com saúde: ");
                double heathSpents = sc.nextDouble();
                persons.add(new NaturalPerson(name, annualIncome, heathSpents));
            } else if (ans == 'j') {
                System.out.print("Número de empregados: ");
                int nmbEmp = sc.nextInt();
                persons.add(new LegalPerson(name, annualIncome, nmbEmp));
            } else {
                System.out.println("Resposta incorreta");
                return;
            }
        }
        System.out.println();
        System.out.println("IMPOSTOS PAGOS:");

        for (Person p :
                persons) {
            System.out.print(p.toString());
        }



        double sum = 0.0;
        System.out.println();
        System.out.println("TOTAL DE IMPOSTOS: ");
        for (Person c :
                persons) {
            sum += c.taxes();
        }
        System.out.println("R$" + sum);

        sc.close();
    }
}