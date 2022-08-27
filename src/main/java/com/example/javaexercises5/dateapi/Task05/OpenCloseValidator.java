package com.example.javaexercises5.dateapi.Task05;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class OpenCloseValidator {

    private final HolidayService holidayService;
    private final WorkingDayService workingDayService;
    private boolean doRespectHolidays;
    private boolean isConfigured = false;

    public OpenCloseValidator() {
        this.holidayService = new HolidayService();
        this.workingDayService = new WorkingDayService();
    }

    public void checkOIfOpen(LocalDateTime dateTime) {
        if (!isConfigured) {
            throw new IllegalStateException("Nie skonfigurowano zasad czasu udzielania usług.");
        }
        if (dateTime.getYear() != LocalDate.now().getYear()) {
            System.out.println("Podano zły rok");
            return;
        }
        if (doRespectHolidays) {
            if (holidayService.getHolidayByDate(dateTime.toLocalDate()).isPresent()) {
                System.out.println("Zamknięte z powodu święta.");
                return;
            }
        }
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        LocalTime time = dateTime.toLocalTime();
        if (workingDayService.isOpen(dayOfWeek, time)) {
            Duration durationToClose = workingDayService.timeToClose(dayOfWeek, time);
            System.out.println("Otwarte. Do zamknięcia zostało " + secondsToNativeTimeFormat(durationToClose.getSeconds()));
            return;
        }
        Duration durationToOpen = workingDayService.timeToOpen(dateTime);
        if(durationToOpen.plusHours(time.getHour()).toHours() > 24) {
            long daysToOpen = 1;
            while (holidayService.getHolidayByDate(dateTime.plusDays(daysToOpen).toLocalDate()).isPresent()) {
                daysToOpen++;
            }

//            durationToOpen = durationToOpen.plusDays(daysToOpen - 1);
        }
        System.out.println("Zamknięte. Do otwarcia zostało " + secondsToNativeTimeFormat(durationToOpen.getSeconds()));
    }

    public void configureWork() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Konfiguracja:");
        System.out.print("Instrukcja - Wprowadź 't', 'tak' lub 'n','nie' dla odpowiedzi bezpośrednich.");
        System.out.println("W celu podania godzin otwarcia zastosuj wzór:  gg:mm-gg:mm lub wpisz 'nie', jeśli zamknięte.");
        System.out.println("Wprowadź godziny otwarcia.");
        System.out.print("PONIEDZIAŁEK: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.MONDAY, scanner.nextLine());
        System.out.print("WTOREK: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.TUESDAY, scanner.nextLine());
        System.out.print("ŚRODA: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.WEDNESDAY, scanner.nextLine());
        System.out.print("CZWARTEK: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.THURSDAY, scanner.nextLine());
        System.out.print("PIĄTEK: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.FRIDAY, scanner.nextLine());
        System.out.print("SOBOTA: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.SATURDAY, scanner.nextLine());
        System.out.print("NIEDZIELA: ");
        workingDayService.setWorkingDayOpenHours(DayOfWeek.SUNDAY, scanner.nextLine());
        System.out.print("Przestrzegasz (święta) dni wolne od pracy?: ");
        String respectHolidays = scanner.nextLine().substring(0, 1);
        if ("t".equals(respectHolidays)) {
            doRespectHolidays = true;
        }
        if ("n".equals(respectHolidays)) {
            doRespectHolidays = false;
        }
        isConfigured = true;
        System.out.println("Konfiguracja zakończona.");
    }

    public void configureWork(Path path) {
        List<DayOfWeek> daysOfWeek = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

        try (Stream<String> lines = Files.lines(path)) {
            List<String> strings = lines.toList();
            String respectHolidays = strings.get(strings.size() - 1).substring(0, 1);
            if ("t".equals(respectHolidays)) {
                doRespectHolidays = true;
            }
            if ("n".equals(respectHolidays)) {
                doRespectHolidays = false;
            }
            strings = strings.subList(0, strings.size() - 1);
            for (int i = 0; i < strings.size(); i++) {
                workingDayService.setWorkingDayOpenHours(daysOfWeek.get(i), strings.get(i));
            }
            isConfigured = true;
            System.out.println("Konfiguracja zakończona.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
