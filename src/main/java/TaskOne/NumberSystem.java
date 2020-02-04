/*
Класс предоставлен к доп. задание.
Преобразуем полученное число типа int в двоичную систему счисления
 с различным отображением кода.
FIXME: 04.02.2020
 */
package TaskOne;

public class NumberSystem {

    //прямой код
    public static String getDirectCode(int a){
        String local = Integer.toBinaryString(a);
        StringBuilder localBuilder;
        if (a >= 0) {
            localBuilder = new StringBuilder(local);
            for (int i = local.length(); i < 32; i++) {
                localBuilder.insert(0, "0");
            }
        } else {
            localBuilder = new StringBuilder(getDirectCode(-a));
            localBuilder.setCharAt(0, '1');
        }
        return localBuilder.toString();
    }

    //обратный код
    public static String getOnesComplement(int a){
        if (a >= 0) return getDirectCode(a);
        else {
            char[] charArray = getDirectCode(-a).toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '0') charArray[i] = '1';
                else charArray[i] = '0';
            }
            return new String(charArray);
        }
    }

    //дополнительный код
    public static String getTwosComplement(int a){
        if (a >= 0) return getDirectCode(a);
        else return Integer.toBinaryString(a);
    }

    public static void show(int value){
        System.out.println("Число " + value + " типа int , в двоичной системе счисления, прямой код " +
                getDirectCode(value));
        System.out.println("Число " + value + " типа int , в двоичной системе счисления, обратный код " +
                getOnesComplement(value));
        System.out.println("Число " + value + " типа int , в двоичной системе счисления, дополнительный код " +
                getTwosComplement(value));
    }

}

