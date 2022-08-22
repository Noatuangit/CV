package crud_basic.utils;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DisplayEnum {
    public static <E extends Enum<E>> void displayMenuOption(Class<E> aEnum) {
        EnumSet.allOf(aEnum)
                .forEach(x -> System.out.printf("%d. %s%n", x.ordinal() + 1, formatString(x.name())));
    }

    public static <E extends Enum<E>> E getMenuOptionFromId(Class<E> aEnum, int id) {
        E[] enums = aEnum.getEnumConstants();
        E enumDefault = enums[enums.length - 1];
        return EnumSet.allOf(aEnum)
                .stream()
                .filter(x -> x.ordinal() + 1 == id)
                .findFirst()
                .orElse(enumDefault);
    }
    public static String upperFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static <E extends Enum<E>> E selectMenuOption(Scanner scanner, Class<E> mainEnum) {
        displayMenuOption(mainEnum);
        E selectedOpt;
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                selectedOpt = getMenuOptionFromId(mainEnum, id);
                break;
            } catch (NumberFormatException e) {
                System.out.print("choice MUST NUMBER !!!\nInput Again ");
            }
        }
        return selectedOpt;
    }

    public static String formatString(String str) {
        return Arrays.stream(str.toLowerCase().split("_"))
                .map(DisplayEnum::upperFirstLetter)
                .collect(Collectors.joining(" "));
    }
}
