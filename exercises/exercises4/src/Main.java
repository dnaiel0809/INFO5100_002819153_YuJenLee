// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String email = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$";
        String http = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String ip =  "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
        String data = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        String time = "^(0?[1-9]|1[0-2]):[0-5][0-9]$";



        Pattern pattern1 = Pattern.compile(email);
        Pattern pattern2 = Pattern.compile(http);
        Pattern pattern3 = Pattern.compile(ip);
        Pattern pattern4 = Pattern.compile(data);
        Pattern pattern5 = Pattern.compile(time);
        String email_good = "aaa@gmail.com";
        String email_bad = "aaa@@gmail.com";
        String http_good = "https://www.google.com";
        String http_bad = "local:8000";
        String ip_good = "198.17.255.255";
        String ip_bad = "faed.eed2.333.222";
        String date_good = "2023-10-10";
        String date_bad = "31-11-2023";
        String time_good = "11:22";
        String time_bad = "24:22";
        Matcher matcher1 = pattern1.matcher(email_good);
        Matcher matcher2 = pattern1.matcher(email_bad);
        Matcher matcher3 = pattern2.matcher(http_good);
        Matcher matcher4 = pattern2.matcher(http_bad);
        Matcher matcher5 = pattern3.matcher(ip_good);
        Matcher matcher6 = pattern3.matcher(ip_bad);
        Matcher matcher7 = pattern4.matcher(date_good);
        Matcher matcher8 = pattern4.matcher(date_bad);
        Matcher matcher9 = pattern5.matcher(time_good);
        Matcher matcher10 = pattern5.matcher(time_bad);

        System.out.println("email: "+email_good);
        if(matcher1.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
        System.out.println("email: "+email_bad);
        if(matcher2.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }


        System.out.println("email: "+http_good);
        if(matcher3.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
        System.out.println("email: "+http_bad);
        if(matcher4.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }


        System.out.println("email: "+ip_good);
        if(matcher5.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
        System.out.println("email: "+ip_bad);
        if(matcher6.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }


        System.out.println("email: "+date_good);
        if(matcher7.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
        System.out.println("email: "+date_bad);
        if(matcher8.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }


        System.out.println("email: "+time_good);
        if(matcher9.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
        System.out.println("email: "+time_bad);
        if(matcher10.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }


    }
}

