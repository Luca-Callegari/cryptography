import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.io.FileReader;

public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("stupidotto.txt")); //here select your file.txt to be read

        String testo1 = reader.readLine();
        while (testo1 != null) {
            System.out.println(testo1);

            //String testo1 = JOptionPane.showInputDialog("Inserire testo");

            ArrayList<String> consonanti = new ArrayList<>();
            consonanti.add("B");
            consonanti.add("C");
            consonanti.add("D");
            consonanti.add("F");
            consonanti.add("G");
            consonanti.add("H");
            consonanti.add("J");
            consonanti.add("K");
            consonanti.add("L");
            consonanti.add("M");
            consonanti.add("N");
            consonanti.add("P");
            consonanti.add("Q");
            consonanti.add("R");
            consonanti.add("S");
            consonanti.add("T");
            consonanti.add("V");
            consonanti.add("W");
            consonanti.add("X");
            consonanti.add("Z");


            ArrayList<String> vocali = new ArrayList<>();
            vocali.add("A");
            vocali.add("E");
            vocali.add("I");
            vocali.add("O");
            vocali.add("U");
            vocali.add("Y");


            ArrayList<String> testoVero = new ArrayList<>();

            //IL VERO PROGRAMMA

            for (int t = 0; t < testo1.length(); t++) {
                char c = testo1.charAt(t);
                String testo = String.valueOf(c);

                if (!(c <= 47 || c >= 58 && c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 255)) {
                    if (vocali(testo)) {
                        for (int i = 0; i < 6; i++) {
                            if (testo.equals(testo.toUpperCase())) {
                                if (testo.equals(vocali.get(5))) {
                                    System.out.print("A");
                                    testoVero.add("A");
                                    break;
                                } else {
                                    if (testo.equals(vocali.get(i))) {
                                        System.out.print(vocali.get(i + 1));
                                        testoVero.add(vocali.get(i + 1));
                                    }
                                }
                            } else {
                                if (testo.equalsIgnoreCase(vocali.get(5))) {
                                    System.out.print("a");
                                    testoVero.add("a");
                                    break;
                                } else {
                                    if (testo.equalsIgnoreCase(vocali.get(i))) {
                                        System.out.print(vocali.get(i + 1).toLowerCase());
                                        testoVero.add(vocali.get(i + 1).toLowerCase());
                                    }
                                }
                            }
                        }
                    } else if (consonanti(testo)) {
                        for (int i = 0; i < 20; i++) {
                            if (testo.equals(testo.toUpperCase())) {
                                if (testo.equals(consonanti.get(19))) {
                                    System.out.print("B");
                                    testoVero.add("B");
                                    break;
                                } else {
                                    if (testo.equals(consonanti.get(i))) {
                                        System.out.print(consonanti.get(i + 1));
                                        testoVero.add(consonanti.get(i + 1));
                                    }
                                }
                            } else {
                                if (testo.equalsIgnoreCase(consonanti.get(19))) {
                                    System.out.print("b");
                                    testoVero.add("b");
                                    break;
                                } else {
                                    if (testo.equalsIgnoreCase(consonanti.get(i))) {
                                        System.out.print(consonanti.get(i + 1).toLowerCase());
                                        testoVero.add(consonanti.get(i + 1).toLowerCase());
                                    }
                                }
                            }
                        }

                    } else if (numeri(Integer.parseInt(testo))) {
                        int testo2 = Integer.parseInt(testo);
                        for (int i = 0; i < 10; i++) {
                            if (testo2 == 9) {
                                System.out.print("0");
                                testoVero.add("0");
                                break;
                            } else if (testo2 == i) {
                                System.out.print(i + 1);
                                testoVero.add(String.valueOf(i + 1));
                            }
                        }
                    }
                } else {
                    System.out.print(testo);
                    testoVero.add(testo);
                }

            }
            System.out.println();

            //DALL'ARRAY ALLA STRINGA UNICA
            String TESTOVERO = "";
            for (int i = 0; i < testoVero.size(); i++) {
                TESTOVERO = TESTOVERO + testoVero.get(i);
            }

            //TE LO SCRIVE SU FILE
            Creafile(TESTOVERO);
            testo1 = reader.readLine();

        }
        reader.close();
    }


    public static boolean consonanti(String l) {


        ArrayList<String> consonanti = new ArrayList<>();
        consonanti.add("B");
        consonanti.add("C");
        consonanti.add("D");
        consonanti.add("F");
        consonanti.add("G");
        consonanti.add("H");
        consonanti.add("J");
        consonanti.add("K");
        consonanti.add("L");
        consonanti.add("M");
        consonanti.add("N");
        consonanti.add("P");
        consonanti.add("Q");
        consonanti.add("R");
        consonanti.add("S");
        consonanti.add("T");
        consonanti.add("V");
        consonanti.add("W");
        consonanti.add("X");
        consonanti.add("Z");

        int conta = 0;
        for (int i = 0; i < consonanti.size(); i++) {
            if (l.equalsIgnoreCase(consonanti.get(i))) {
                conta++;
            }
        }
        if (conta == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean vocali(String l) {
        ArrayList<String> vocali = new ArrayList<>();
        vocali.add("A");
        vocali.add("E");
        vocali.add("I");
        vocali.add("O");
        vocali.add("U");
        vocali.add("Y");

        int conta = 0;
        for (int i = 0; i < vocali.size(); i++) {
            if (l.equalsIgnoreCase(vocali.get(i))) {
                conta++;
            }
        }
        if (conta == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numeri(int n) {
        int conta = 0;
        for (int i = 0; i < 10; i++) {
            if (n == i) {
                conta++;
            }
        }
        if (conta == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static void Creafile(String TESTO) {
        try {
            FileOutputStream prova = new FileOutputStream("prova.txt"); //this creates a new txt file which contains the output
            PrintStream scrivi = new PrintStream(prova);
            for (int i = 0; i < 1; i++) {
                scrivi.println(TESTO);
            }
        } catch (IOException e) {
            System.out.println("Errore: " + e);
            System.exit(1);
        }
    }


}
