package com.example.javaexercises5.dateapi.Task05;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class OpenCloseValidator {

    private final WorkingDayService workingDayService;

    private OpenCloseValidator(HolidayService.HolidaysMode mode) {
        HolidayService holidayService = new HolidayService(mode);
        this.workingDayService = new WorkingDayService(holidayService);
    }

    public void checkOIfOpen(LocalDateTime dateTime) {
        if (workingDayService.isOpen(dateTime)) {
            Duration durationToClose = workingDayService.timeToClose(dateTime);
            System.out.println("Otwarte. Do zamknięcia zostało " + secondsToNativeTimeFormat(durationToClose.getSeconds()));
            return;
        }
        Duration durationToOpen = workingDayService.timeToOpen(dateTime);
        LocalDateTime openDateTime = workingDayService.getClosestWorkingDay(dateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Zamknięte. Otwarte będzie dnia "
                + openDateTime.toLocalDate() + " o godz. "
                + dateTimeFormatter.format(openDateTime.toLocalTime()) + ". Do otwarcia zostało "
                + secondsToNativeTimeFormat(durationToOpen.getSeconds()));
    }

    public static OpenCloseValidator builder() {
        boolean doRespectHolidays = false;
        boolean doRespectTradeSundays = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Konfiguracja:");
        System.out.print("Instrukcja - Wprowadź 't', 'tak' lub 'n','nie' dla odpowiedzi bezpośrednich.");
        System.out.println("W celu podania godzin otwarcia zastosuj wzór:  gg:mm-gg:mm lub wpisz 'nie', jeśli zamknięte.");
        System.out.print("Czy przestrzegasz (święta) dni wolne od pracy?: ");
        String respectHolidays = scanner.nextLine().substring(0, 1);
        if ("t".equals(respectHolidays)) {
            doRespectHolidays = true;
        }
        System.out.print("Czy przestrzegasz system niedziel handlowych?: ");
        String respectTradeSundays = scanner.nextLine().substring(0, 1);
        if ("t".equals(respectTradeSundays)) {
            doRespectTradeSundays = true;
        }
        OpenCloseValidator openCloseValidator = getInstance(doRespectHolidays, doRespectTradeSundays);
        System.out.println("Wprowadź godziny otwarcia.");
        System.out.print("PONIEDZIAŁEK: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.MONDAY, scanner.nextLine());
        System.out.print("WTOREK: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.TUESDAY, scanner.nextLine());
        System.out.print("ŚRODA: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.WEDNESDAY, scanner.nextLine());
        System.out.print("CZWARTEK: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.THURSDAY, scanner.nextLine());
        System.out.print("PIĄTEK: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.FRIDAY, scanner.nextLine());
        System.out.print("SOBOTA: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.SATURDAY, scanner.nextLine());
        System.out.print("NIEDZIELA: ");
        openCloseValidator.workingDayService.setWorkingDayOpenHours(DayOfWeek.SUNDAY, scanner.nextLine());

        System.out.println("Konfiguracja zakończona.");
        return openCloseValidator;
    }

    public static OpenCloseValidator builder(Path path) {
        List<DayOfWeek> daysOfWeek = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

        try (Stream<String> lines = Files.lines(path)) {
            List<String> strings = lines.toList();
            String respectHolidays = strings.get(0).substring(0, 1);
            String respectTradeSundays = strings.get(1).substring(0, 1);
            boolean doRespectHolidays = false;
            boolean doRespectTradeSundays = false;
            if ("t".startsWith(respectHolidays)) {
                doRespectHolidays = true;
            }
            if ("t".equals(respectTradeSundays)) {
                doRespectTradeSundays = true;
            }
            OpenCloseValidator openCloseValidator = getInstance(doRespectHolidays, doRespectTradeSundays);
            strings = strings.subList(2, strings.size());
            for (int i = 0; i < strings.size(); i++) {
                openCloseValidator.workingDayService.setWorkingDayOpenHours(daysOfWeek.get(i), strings.get(i));
            }
            System.out.println("Konfiguracja zakończona.");
            return openCloseValidator;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static OpenCloseValidator getInstance(boolean doRespectHolidays, boolean doRespectTradeSundays) {
        if (!doRespectHolidays) {
            return new OpenCloseValidator(HolidayService.HolidaysMode.ABSENCE);
        }
        if (doRespectTradeSundays) {
            return new OpenCloseValidator(HolidayService.HolidaysMode.HOLIDAYS_TRADE_SUNDAYS);
        }
        return new OpenCloseValidator(HolidayService.HolidaysMode.HOLIDAYS);

    }

    private String secondsToNativeTimeFormat(long seconds) {
        long hours = seconds / 3600;
        long remainder = seconds - hours * 3600;
        long mins = remainder / 60;
        remainder = remainder - mins * 60;
        long secs = remainder;
        return hours + " godz. " + mins + " min. " + secs + " sek";
    }

}
