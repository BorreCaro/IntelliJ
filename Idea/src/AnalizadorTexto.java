import java.util.Scanner;
public class AnalizadorTexto {
    public static String reverso(StringBuilder builder){
        return new StringBuilder(builder).reverse().toString();
    }
    public static String palabraGrande(String[] array){
        int max = array[0].length();
        int indexMax = 0;
        int l = array.length;
        for(int i = 0; i < l; i++){
            if(array[i].length()>max) {
                max = array[i].length();
                indexMax = i;
            }
        }
        return array[indexMax];
    }
    public static boolean esPalindromo(String s){
        char[] chars = s.toLowerCase().toCharArray();
        for(int l=0,r=s.length()-1;l<r;l++,r--){
            if(chars[l]!=chars[r]) return false;
        }
        return true;
    }
    public static String tienePalindromo(String[] array){
        for(String s : array){
            if(esPalindromo(s) && s.length()>=3) return s;
        }
        return "";
    }
    public static int caracteres(StringBuilder builder){
        return builder.length();
    }
    public static int cantVocales(StringBuilder builder){
        int vow = 0;
        char[] vowels = {'a','e','i','o','u'};
        char[] st = builder.toString().toCharArray();
        for(char c : st)
            for(char v : vowels){
                if(c==v){
                    vow++;
                    break;
                }
            }

        return vow;
    }
    public static int cantConsonantes(StringBuilder builder){
        int con = 0;
        String cons = "bcdfghjklmnñpqrstvwxyz";
        char[] consonants = cons.toCharArray();
        char[] st = builder.toString().toCharArray();
        for(char c : st)
            for(char v : consonants){
                if(c==v){
                    con++;
                    break;
                }
            }

        return con;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el texto (escriba FIN en una nueva línea para terminar):");
        String str;
        StringBuilder builder = new StringBuilder();
        do {
            str = sc.nextLine();
            builder.append(str);
            builder.append("\n");
        } while (!str.equals("FIN"));
        builder.delete(builder.length()-5,builder.length());
        String[] arrayPalabras = builder.toString().split("\\s+");
        int palabras = arrayPalabras.length;
        System.out.println("========================================");
        System.out.println("           REPORTE DE TEXTO");
        System.out.println("========================================");
        System.out.println("Texto original:");
        System.out.printf("%s%n%n", builder.toString());
        System.out.println("Texto invertido:");
        System.out.printf("%s%n%n", reverso(builder));
        System.out.println("Estadísticas:");
        System.out.printf("- Caracteres totales: %d%n", caracteres(builder));
        System.out.printf("- Palabras: %d%n", palabras);
        System.out.printf("- Vocales: %d%n", cantVocales(builder));
        System.out.printf("- Consonantes: %d%n", cantConsonantes(builder));
        String larga = palabraGrande(arrayPalabras);
        System.out.printf("- Palabra mas larga: \"%s\" (%d letras)%n", larga, larga.length());
        System.out.printf("- Contiene palíndromo: ");
        String palindromo = tienePalindromo(arrayPalabras);
        System.out.printf((palindromo.isEmpty()) ? "No%n" : "Sí (%s)%n", palindromo);
        System.out.println("========================================");
        sc.close();
    }
}