package thuongnguyen.it78.configs;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Part;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class LibraryMethod {

    public static String filterPrice(int price) {
        if(price == 1) return " and sd.shoes_detail_price > 300000 and sd.shoes_detail_price < 500000 ";
        return " and sd.shoes_detail_price > 500000 ";
    }

    public static String filterSort(String sort) {
        if(sort.equals("asc")) return " order by sd.shoes_detail_price asc ";
        return " order by sd.shoes_detail_price desc ";
    }

    public static String capitalize(String str) {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static String capFirstLetter(String str) {
        String result = "";
        String arrLetter[] = str.split(" ");
        for(String letter : arrLetter) {
            result = result.concat(capitalize(letter)).concat(" ");
        }

        return result.trim();
    }

    public static String priceWithDecimal (Double price) {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("###,###,###.##", symbols);
        return formatter.format(price);
    }

    public static String priceWithoutDecimal (Double price) {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("###,###,###.##", symbols);
        return formatter.format(price);
    }

    public static String priceToString(Double price) {
        String toShow = priceWithoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return priceWithDecimal(price) + " VND";
        } else {
            return priceWithoutDecimal(price) +" VND";
        }
    }

    public static String getNameShoes(String s) {
        String arr[] = s.split("-");

        if(arr.length == 2) return arr[0].trim();

        return arr[0].trim().concat(" ").concat(arr[1].trim());
    }

    public static String getGenderShoes(int i) {
        if(i == 1) return "Nam";
        return "Nữ";
    }

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("123456"));
    }

}
