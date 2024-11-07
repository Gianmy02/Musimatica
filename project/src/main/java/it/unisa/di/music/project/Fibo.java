package it.unisa.di.music.project;

public class Fibo {
	static int SIZE = 20;
	static int fib[] = new int[SIZE];
	
	static String[] note = new String[] {"B3", "C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5", "D5"};
	static String[][] chords = new String[][] { 
		{"Emin", "Gmaj", "Bdim"},  //B, Si
		{"Cmaj", "Amin", "Fmaj"},  //C, Do
		{"Dmin", "Bdim", "Gmaj"},  //D, Re
		{"Emin", "Cmaj", "Amin"},  //E, Mi
		{"Fmaj", "Dmin", "Bdim"},  //F, Fa
		{"Gmaj", "Emin", "Cmaj"},  //G, Sol
		{"Amin", "Fmaj", "Ddim"},  //A, La
		{"Emin", "Gmaj", "Bdim"},  //B, Si
		{"Cmaj", "Amin", "Fmaj"},  //C, Do
		{"Dmin", "Bdim", "Gmaj"}  //D, Re
		};

	public static String fib(int a) {

                fib[0]=0;
		fib[1]=a%10;
		String digits = "0"+a;
		for (int i=2; i<SIZE; i++) {
			fib[i]=fib[i-2]+fib[i-1];
			digits = digits + fib[i];
		}
		System.out.format("digits=%s\n",digits);
		
		String music = "";
		int chord_index = 0;
		for (int i=0; i<digits.length(); i++) {
			//prendo l'index e lo trasformo in intero
                        int index = Integer.parseInt(""+digits.charAt(i));
			music = music + " " + note[index];  //creo la stringa 
			if (index==1 || index==8) music += "w";
                        //ogni 4 note aggiungo un accordo dei 3 della nota
			if (i%4==0) {
				music = music + "+" + chords[index][chord_index];
				chord_index = (chord_index+1)%3;
			}
		}
                return music;
        }     
        

}