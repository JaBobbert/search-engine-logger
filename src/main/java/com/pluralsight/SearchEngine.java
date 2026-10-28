
package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngine {

    public static final String LOG_FILE_NAME = "log.txt";

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        logAction("Launch");

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a search term (X or x to exit)");

        while (true) {
            String searchTerm = scan.nextLine();

            if ("X".equalsIgnoreCase(searchTerm)) {
                logAction("Exit");
                break;
            } else {
                logAction("Search: " + searchTerm);
                System.out.println("Enter another search term (X or x to exit)");
            }
        }

        scan.close();
    }

    private static void logAction(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true));

            writer.write(LocalDateTime.now().format(FORMATTER) + " " + action);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.err.println("Error writing to the log file: " + e.getMessage());
        }
    }
}
