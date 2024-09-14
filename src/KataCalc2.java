import java.util.Scanner;

public class KataCalc2 {
    static String calc(String s1) throws Exception {
        s1 = s1.trim();
        if (s1.matches("\"[^\"]{1,10}\" \\+ \"[^\"]{1,10}\"")) {
            String[] s = s1.split(" \\+ ");
            String pravo = s[1].substring(1, s[1].length() - 1);
            String levo = s[0].substring(1, s[0].length() - 1);
            return "\"" + levo + pravo + "\"";
        } else if (s1.matches("\"[^\"]{1,10}\" - \"[^\"]{1,10}\"")) {
            String[] s = s1.split(" - ");
            String pravo = s[1].substring(1, s[1].length() - 1);
            String levo = s[0].substring(1, s[0].length() - 1);
            return "\"" + levo.replace(pravo, "") + "\"";
        } else if (s1.matches("\"[^\"]{1,10}\" \\* ([1-9]|10)")) {
            String [] s = s1.split(" \\* ");
            int pravo = Integer.parseInt(s[1]);
            String levo = s[0].substring(1,s[0].length()-1);
            String relut = "";
            for (int i = 0; i < pravo; i ++){
                relut += levo;
            }if(relut.length()>40){
                relut =  relut.substring(0,40) + "...";
            }
            return "\"" + relut  + "\"";
        } else if (s1.matches("\"[^\"]{1,10}\" / ([1-9]|10)")) {
            String [] s = s1.split(" / ");
            int pravo = Integer.parseInt(s[1]);
            String levo = s[0].substring(1,s[0].length()-1);
            int os = levo.length()/pravo;
            return "\"" + levo.substring(0,os) + "\"";
        }else if (s1.matches("([1-9]|10) [/\\*\\+-] \"[^\"]{1,10}\"")){
            throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        }throw new Exception("Некорректный ввод");

    }


    public static void main(String[] args) throws Exception {
        System.out.println("Привет пользователь.");
        Scanner sca = new Scanner(System.in);
        String stroca = sca.nextLine().trim();
        System.out.println(calc(stroca));


    }
}
