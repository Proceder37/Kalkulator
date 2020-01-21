package com.mycompany.implementacja;

import com.mycompany.class_loader.ClassLoaderPow;
import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Math.*;


    
    public class Implementacja extends ClassLoaderPow{

        public Implementacja() {

        }

        public boolean cyfra(char c) {
            return c >= 48 && c <= 57 || c == '.';
        }

        public String operacja(String a, int i) {
            int nawiasy = 0;
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(j) == '(') nawiasy++;
                if (a.charAt(j) == ')') nawiasy--;
                if (nawiasy == 0) {
                    a = a.substring(0, i) + a.substring(i, j + 1) + "^0.5" + a.substring(j + 1);
                    return a;
                }
            }
            return "";
        }

        public ArrayList<String> doONP(String dzial) {
            dzial = dzial.replaceAll(" ", "");
            System.out.println(dzial);
            for (int i = 0; i < dzial.length(); i++) {
                if (dzial.charAt(i) == 'V') {
                    dzial=this.operacja(dzial, i);
                }
            }
            dzial = dzial.replace("V", "");
            dzial += "=";
            ArrayList<String> wyjscie = new ArrayList<>();
            Stack<Character> stos = new Stack<>();
            for (int i = 0; dzial.charAt(i) != '='; i++) {
                if (cyfra(dzial.charAt(i))) {
                    int poczatek = i;
                    //System.out.println("Poczatek:"+poczatek);
                    while (cyfra(dzial.charAt(i))) {
                        i++;
                    }
                    //System.out.println(dzial.substring(poczatek,i));
                    wyjscie.add(dzial.substring(poczatek, i));
                    i--;
                } else {
                    if (dzial.charAt(i) == '(') {
                        stos.add('(');
                    } else if (dzial.charAt(i) == ')') {
                        while (stos.peek() != '(') {
                            wyjscie.add(String.valueOf(stos.pop()));
                        }
                        stos.pop();
                    } else {
                        if (stos.empty() || priorytet(dzial.charAt(i)) > priorytet(stos.peek())) {
                            stos.add(dzial.charAt(i));
                        } else {
                            wyjscie.add(String.valueOf(stos.pop()));
                            stos.add(dzial.charAt(i));
                        }
                    }
                }
            }
            while (stos.empty() == false) {
                wyjscie.add(String.valueOf(stos.pop()));
            }
            return wyjscie;
        }

        public float zONP(ArrayList<String> onp) {
            Stack<Float> stos = new Stack<>();
            for (int i = 0; i < onp.size(); i++) {
                if (cyfra((onp.get(i)).charAt(0))) {
                    stos.add(Float.valueOf(onp.get(i)));
                } else {
                    switch (onp.get(i).charAt(0)) {
                        case '+':
                            stos.add(stos.pop() + stos.pop());
                            break;
                        case '-':
                            stos.add(stos.pop() - stos.pop());
                            break;
                        case '*':
                            stos.add(stos.pop() * stos.pop());
                            break;
                        case '/':
                            stos.add(stos.pop() / stos.pop());
                            break;
                        case '^':
                            float arglist[]= new float[5];
                            arglist[0]=stos.pop();
                            arglist[1]=stos.pop();
                         //   stos.add((float) Math.pow(arglist[1],arglist[0]));
                            stos.add((float) OdpalanieCL(arglist));

                            break;
                    }
                }
            }
            return stos.peek();
        }

        public void oblicz(String zapis) {
            System.out.println(zONP(doONP(zapis)));
        }

        public int priorytet(char c) {
            switch (c) {
                case '+': ;
                case '-':
                    return 1;
                case '*': ;
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return 0;
        }
    }
