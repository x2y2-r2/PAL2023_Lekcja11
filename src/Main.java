import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//      1.  Coś więcej niż array - lista
//        Array jest statyczny. Jak zrobimy tablice na 5 elementów to koniec
        int[] tablica = {1, 2, 3, 4, 5};
//        To spowoduje nam wyjątek, bo jest poza zakresem
//        tablica[6] = 7;

//        Tu nie ma problemu
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(20);
        integerList.add(3);
        integerList.add(4);
        integerList.add(10);
        integerList.add(6);
        integerList.add(7);


        for (Integer liczba : integerList) {
            System.out.println(liczba);
        }

        System.out.println("==============");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }


        ArrayList<String> pola = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            pola.add("| |");
        }

        for (int i = 0; i < 10; i++) {
            pola.add("| |");
        }

        pola.set(2, "|X|");
        pola.set(5, "|O|");
        pola.set(7, "|X|");
//
        for (int i = 0; i < 10; i++) {
            System.out.print(pola.get(i));
        }

//        for (String pole : pola) {
//            System.out.print(pole);
//        }

//
//        System.out.println();
        System.out.println();

        //        2. Używanie klas wbudowanych
//        Przejdziemy przez pakiet Time
        LocalTime localTime = LocalTime.of(1, 1, 1);
        System.out.println(localTime);

        LocalTime localTimePlusTwo = localTime.plusHours(2);
        System.out.println(localTimePlusTwo);

//        3. Spróbuj stworzyć datę swoich urodzin eksplorując pakiet Time
//        https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html

        LocalDate bierzacaData = LocalDate.now();
        LocalDate urodziny = LocalDate.of(2015,03,17);
        LocalDate nastepneUrodziny = urodziny.withYear(bierzacaData.getYear());
        System.out.println(bierzacaData);
        System.out.println(nastepneUrodziny);
//        Co w przypadku kiedy urodziny już minęły?
        System.out.println("Kiedy następne urodziny?");
        if (nastepneUrodziny.isBefore(bierzacaData) || nastepneUrodziny.isEqual(bierzacaData)) {
            nastepneUrodziny = nastepneUrodziny.plusYears(1);
        }
        System.out.println(nastepneUrodziny);
//        Za ile następne urodziny?
        long wiek = ChronoUnit.YEARS.between(urodziny,bierzacaData);
        Period czasDoUrodzin = Period.between(bierzacaData, nastepneUrodziny);
        long iloscDniDoUrodzin = ChronoUnit.DAYS.between(bierzacaData,nastepneUrodziny);
        System.out.println("Mam teraz " + wiek + " lat. " + "Następne urodziny będą za " + czasDoUrodzin.getMonths() + " miesięcy i " + czasDoUrodzin.getDays()
        + " dni. W sumie do urodzin pozostało " + iloscDniDoUrodzin + " dni.");
    }
}

