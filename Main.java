import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Выбери номер задания\n1) Сиракузская последовательность\n" +
                "2) Сумма ряда\n3) Ищем клад\n4) Логистический максимин\n5) Дважды четное число");
        int a = input.nextInt();
        switch (a){
            case 1:
                Syracuse();
                break;
            case 2:
                sum_of_nums();
                break;
            case 3:
                treasure();
                break;
            case 4:
                logistics_maximin();
                break;
            case 5:
                twice_even_number();
                break;
        }
    }
    static void Syracuse(){
        System.out.println("Введите натуральное число");
        int n;
        n = input.nextInt();
        int steps = 0;

        if (n <= 0) {
            System.out.println("Ненатуральное число");
        }

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }

        System.out.println(steps);
    }

    static void sum_of_nums() {
        System.out.print("n > 0: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("error. n <= 0!!!");
        } else {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int num = input.nextInt();

                if (i % 2 == 0) {
                    sum += num;
                } else {
                    sum -= num;
                }
            }
            System.out.println("Результат: " + sum);
        }
    }
    static void treasure(){
        int currentX = 0;
        int currentY = 0;
        System.out.println("Координаты клада:");
        int x = input.nextInt();
        int y = input.nextInt();
        int count = 0;
        int minCount = 0;
        String direction = "";
        while (!direction.equals("стоп")) {
            direction = input.next();
            if ((currentX == x) && (currentY == y)){
                minCount = count;
            }
            else {
                switch (direction) {
                    case "север":
                        currentY += input.nextInt();
                        count += 1;
                        break;
                    case "юг":
                        currentY -= input.nextInt();
                        count += 1;
                        break;
                    case "запад":
                        currentX -= input.nextInt();
                        count += 1;
                        break;
                    case "восток":
                        currentX += input.nextInt();
                        count += 1;
                        break;
                }
            }
        }
        System.out.println(minCount);
    }


    static void logistics_maximin(){
        int n = input.nextInt();
        int num_of_tunnels;
        int h;
        int tunnel = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            num_of_tunnels = input.nextInt();
            min = Integer.MAX_VALUE;
            for (int j = 1; j <= num_of_tunnels; j++) {
                h = input.nextInt();
                if (h < min) {
                    min = h;
                }
            }
            if (max < min){
                max = min;
                tunnel = i;
            }
        }
        System.out.println(tunnel + " " + max);

    }

    static void twice_even_number(){
        int n = input.nextInt();
        if (((n % 10) + (n % 100 / 10) + (n / 100)) % 2 == 0 && ((n % 10) * (n % 100 / 10) * (n / 100)) % 2 == 0){
            System.out.println("Является");
        }
        else{
            System.out.println("Не является");
        }
    }
}