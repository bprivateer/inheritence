class Runner {
    public static void main(String[] args) {
        EmailNotification emailNotification = new EmailNotification("subject", "Body", "recipient",
                "stamp Provider");
        System.out.println();

        emailNotification.transport();
        System.out.println();

//        emailNotification.showStatus();
//        System.out.println();
        emailNotification.showText();
        System.out.println();
        Object newEmailNotification = emailNotification.clone();

        System.out.println("Are the two objects the same: " + emailNotification.equals(newEmailNotification));




        TextNotification textNotification = new TextNotification("subjectText", "bodyText",
                "recipientText", "SMS provider");
        System.out.println();

        textNotification.showText();



    }
}
