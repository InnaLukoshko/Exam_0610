import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class General {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<Auto> autosList = new ArrayList<>();
    public static List <HistoryOfSales> historyOfSalesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Auto auto1 = new Auto(Marks.AUDI,50150,5);
        LocalDate date = LocalDate.of(2015,1,2);
        HistoryOfSales historyAuto1 = new HistoryOfSales(auto1,date);

        autosList.add(auto1);
        historyOfSalesList.add(historyAuto1);

        showMenu();
    }
    public static void showMenu() throws IOException {
        while (true) {
            System.out.println("Введите действие, которое хотите выполнить" +
                    "\n 1 - добавить авто и продажу авто" +
                    "\n 2 - поиск товара по частичному совпадению со словом введенном из консоли " +
                    "\n 3 - получать информацию из истории продаж (последние 3 записи) по паролю (пароль должен храниться в файле)" +
                    "\n 4 - выход из программы");
            int a = Integer.parseInt(reader.readLine());
            switch (a) {
                case 1:
                    addAuto();
                case 2:
                    findAuto();
                case 3:
//                    findHistoryAuto();
                case 4:
                    System.exit(1);
                default:
                    System.out.println("Ошибка ввода действия");
            }
        }
    }

    public static void addAuto() throws IOException {
        System.out.println("Введите данные (через ввод) для новой машины: марка, стоимость, количество на складе");
        Marks markNewAuto = Marks.GEELY;
        try {
            markNewAuto = reader.readLine().equalsIgnoreCase("audi") ? Marks.AUDI :
                         (reader.readLine().equalsIgnoreCase("bmw") ? Marks.BMW : Marks.GEELY);
        } catch (IllegalArgumentException e) {
            System.out.println("Введенной марки авто нет в базе! Обратитесь к администратору для добавления ее в базу");
        }
        double priceNewAuto = Double.parseDouble(reader.readLine());
        int countNewAuto = Integer.parseInt(reader.readLine());

        Auto newAuto = new Auto(markNewAuto,priceNewAuto,countNewAuto);
        autosList.add(newAuto);

        System.out.println("Введите дату (через ввод) продажи авто: год, месяц, число");
        int year = Integer.parseInt(reader.readLine());
        int month = Integer.parseInt(reader.readLine());
        int day = Integer.parseInt(reader.readLine());
        LocalDate newDate = LocalDate.of(year,month,day);

        HistoryOfSales historyNewAuto = new HistoryOfSales(newAuto,newDate);
        historyOfSalesList.add(historyNewAuto);

    }
    public static void findAuto() throws IOException {
        System.out.println("Введите первые 2 буквы названия марки авто");
        String twoLetters = reader.readLine();

        if (twoLetters.equalsIgnoreCase("au")) {
            autosList.stream()
                    .filter(x -> x.getMark().equals(Marks.AUDI))
                    .forEach(x -> System.out.println(x));
        } else if (twoLetters.equalsIgnoreCase("bm")) {
            autosList.stream()
                    .filter(x -> x.getMark().equals(Marks.BMW))
                    .forEach(x -> System.out.println(x));
        } else if (twoLetters.equalsIgnoreCase("ge")) {
            autosList.stream()
                    .filter(x -> x.getMark().equals(Marks.GEELY))
                    .forEach(x -> System.out.println(x));

//        public static void findHistoryAuto () {
//
//        }

    }

}
