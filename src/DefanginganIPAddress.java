
//Example 1:
//
//Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"

public class DefanginganIPAddress {
    public static void main(String[] args) {

        System.out.println("Out ip address: "+ defangIPaddr("255.100.50.0"))  ;
    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder() ;
        for(char c: address.toCharArray()) {
            sb.append(c== '.'?"[.]":c) ;
        }
        return sb.toString() ;
    }
}
