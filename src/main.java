/**
 * Created by Dawid on 18.08.2015.
 */
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.WeakHashMap;

public class main {
    public static void main(String[] args){
        System.out.println("[03]Calculate age in seconds");
        System.out.print("Dzisiejsza data to: ");
        //SimpleDateFormat simpleDateHere = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println( simpleDateHere.format(new Date()) );

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        System.out.println("Podaj date urodzenia w formacie DD/MM/RRRR");
        Scanner sc = new Scanner(System.in);
        String zczytaj = sc.next();

        char a1 = zczytaj.charAt(2);
        char a2 = zczytaj.charAt(5);
        String dzien = " ";
        String miesiac = " ";
        String rok = " ";
        int wynikD = 0;
        int wynikM = 0;
        int wynikY = 0;
        String day = dateFormat.format(date).substring(0,2);
        String month = dateFormat.format(date).substring(3,5);
        String year = dateFormat.format(date).substring(6,10);
        int irok=0;
        if(zczytaj.length()!=10){
            System.out.println("Poda³eœ z³¹ datê!");
            System.exit(11);
        } else {
            if(a1 == 47 || a1 == 92){                          //ascii 92 = \, ascii 47 = /
                if(a2 == 47 || a2 == 92){
                    dzien = zczytaj.substring(0,2);
                    miesiac = zczytaj.substring(3,5);
                    rok = zczytaj.substring(6,10);
                    int idzien = Integer.parseInt(dzien);
                    int imiesiac = Integer.parseInt(miesiac);
                    irok = Integer.parseInt(rok);
                    int iday = Integer.parseInt(day);
                    int imonth = Integer.parseInt(month);
                    int iyear = Integer.parseInt(year);
                    if(irok==iyear){
                        if(imiesiac<=imonth){
                            if(idzien<iday){
//TODO
                            }
                        }
                    }
                    if(irok > 0 && irok < iyear){
                        if(imiesiac>0&&imiesiac<=12){
                            if(imiesiac==2){
                                //28
                                if(idzien>0&&idzien<=28){
                                    wynikD = iday - idzien;
                                    wynikD = 28-wynikD;
                                    wynikM = imonth-imiesiac;
                                    wynikY = iyear-irok;
                                } else {
                                    System.out.println("Na pewno dobry dzien?");
                                    System.exit(1);
                                }
                            } else if(imiesiac==1 || imiesiac==3 || imiesiac==5 || imiesiac==7 || imiesiac==8 || imiesiac==10 || imiesiac==12){
                                //31
                                if(idzien>0&&idzien<=31){
                                    wynikD = iday - idzien;
                                    wynikD = 31-wynikD;
                                    wynikM = imonth-imiesiac;
                                    wynikY = iyear-irok;
                                } else {
                                    System.out.println("Na pewno dobry dzien?");
                                    System.exit(1);
                                }
                            } else {
                                //30
                                if(idzien>0&&idzien<=30){
                                    wynikD = iday - idzien;
                                    wynikD = 30-wynikD;
                                    wynikM = imonth-imiesiac;
                                    wynikY = iyear-irok;
                                } else {
                                    System.out.println("Na pewno dobry dzien?");
                                    System.exit(1);
                                }
                            }
                        }
                        else{
                            System.out.println("Na pewno dobry miesi¹c? ");
                            System.exit(2);
                        }
                    } else {
                        System.out.println("Na pewno poda³eœ dobry rok?! :)");
                        System.exit(3);
                    }
                }
            }
        }
        int wynik = 0;
        //System.out.println("Dzieñ: " + wynikD);
        wynik += wynikD;
        //System.out.println("Miesiac: " + wynikM);
        wynik += 30 * (wynikM-1);
        //System.out.println("Rok: " + wynikY);
        wynik += 365 * wynikY;
        int tmp = ((2016-irok)/4)-1; //DO ZMIENIENIA ZA ROK
        wynik+=tmp;
        System.out.println("Od tego czasu minê³o: ");
        System.out.println("Dni: " + wynik);
        wynik = wynik *24;
        System.out.println("Godzin: " + wynik);
        wynik = wynik * 60;
        System.out.println("Minut: " + wynik);
        wynik = wynik * 60;
        System.out.println("Sekund: " + wynik);

    }
}
