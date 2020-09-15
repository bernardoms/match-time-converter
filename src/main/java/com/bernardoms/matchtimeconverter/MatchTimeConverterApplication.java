package com.bernardoms.matchtimeconverter;

import com.bernardoms.matchtimeconverter.exception.InvalidMatchTimeException;
import com.bernardoms.matchtimeconverter.service.MatchTimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
public class MatchTimeConverterApplication  implements CommandLineRunner {

    private final MatchTimeService matchTimeService;

    public MatchTimeConverterApplication(MatchTimeService matchTimeService) {
        this.matchTimeService = matchTimeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MatchTimeConverterApplication.class, args);
    }

    @Override
    @Profile("!test")
    public void run(String... args) throws InvalidMatchTimeException {
        var in = new Scanner(System.in);
        System.out.println("ENTER MATCH TIME IN FORMAT [MT] m:ss.SSS");
        System.out.println("Type Q for quit");
        var params = in.nextLine();
        while (!params.equalsIgnoreCase("q")) {
            System.out.println(matchTimeService.converter(params));
            params = in.nextLine();
        }
    }
}
