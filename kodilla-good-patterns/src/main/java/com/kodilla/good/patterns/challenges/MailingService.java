package com.kodilla.good.patterns.challenges;

public class MailingService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("MailingService has sent some spam");
    }
}
