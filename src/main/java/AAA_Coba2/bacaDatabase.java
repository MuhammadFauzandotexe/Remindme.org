package AAA_Coba2;

import Email.SendEmail;

public class bacaDatabase {
    public static void main(String[] args) {
        SendEmail remd = new SendEmail("ariniahlasalsabila@gmail.com","remindme","cepat kasih makan kucing pet feeder","pet feeder");
        remd.emailSend();
    }
}
