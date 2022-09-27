import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a quantidade de atletas: ");
        int quantityOfAthletes = sc.nextInt();

        String athletesName;
        char sex;
        double menSex = 0;
        double womanSex = 0;
        double height;
        double greaterHeight = 0.0;
        String heightAthlete = null;
        double weight;
        double heightWoman = 0.0;
        double weightAthletes = 0.0;

        for (int i = 0; i < quantityOfAthletes; i++) {
            System.out.println("Digite os dados do atleta numero " + (i + 1)+ ":");
            System.out.print("Nome: ");
            athletesName = sc.next();
            sc.next();
            System.out.print("Sexo: ");
            sex = sc.next().toLowerCase().charAt(0);

            while(sex!= 'f' && sex != 'm') {
                System.out.print("Valor inválido! Favor digitar F ou M: ");
                sex = sc.next().toLowerCase().charAt(0);
            }

            if (sex == 'f') {
                womanSex ++;
            } else {
                menSex++;
            }

            System.out.print("Altura: ");
            height = sc.nextDouble();

            while(height < 0 || height == 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                height= sc.nextDouble();
            }

            if (height > greaterHeight) {
                greaterHeight = height;
                heightAthlete = athletesName;
            }

            if (sex == 'f') {
                heightWoman += greaterHeight;
            }

            System.out.print("Peso: ");
            weight = sc.nextDouble();

            while(weight < 0 || weight == 0){
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                weight = sc.nextDouble();
            }

            if (weight > 0) {
                weightAthletes += weight;
            }
        }

        System.out.println();
        System.out.println("RELATÓRIO: ");

        double averageWeight = weightAthletes / quantityOfAthletes;
        System.out.printf("Peso médio dos atletas: %.2f%n",averageWeight);

        System.out.println("Atleta mais alto: " + heightAthlete);

        double percentageMen = (menSex / quantityOfAthletes) * 100;
        System.out.printf("Porcentagem de homens: %.2f%n",percentageMen);

        if (womanSex == 0) {
            System.out.println("Não há mulheres cadastradas");
        } else {
            double averageHeight = heightWoman / womanSex;
            System.out.printf("Altura média das mulheres: %.2f",averageHeight);
        }
    }
}