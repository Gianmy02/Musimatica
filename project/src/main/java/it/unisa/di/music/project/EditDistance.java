package it.unisa.di.music.project;

public class EditDistance {

    // Metodo per calcolare la distanza di edit tra due stringhe
    public static int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Creiamo una matrice (m+1) x (n+1) per memorizzare i risultati intermedi
        int[][] dp = new int[m + 1][n + 1];

        // Riempiamo la matrice dp in modo bottom-up
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Se la prima stringa è vuota, l'unica opzione è inserire tutti i caratteri della seconda stringa
                if (i == 0) {
                    dp[i][j] = j;
                }
                // Se la seconda stringa è vuota, l'unica opzione è rimuovere tutti i caratteri della prima stringa
                else if (j == 0) {
                    dp[i][j] = i;
                }
                // Se i caratteri sono uguali, non facciamo nulla e prendiamo il valore diagonale
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Se i caratteri sono diversi, consideriamo le tre operazioni e prendiamo il minimo
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  // Sostituzione
                                  Math.min(dp[i - 1][j],     // Rimozione
                                           dp[i][j - 1]));   // Inserimento
                }
            }
        }

        // Il risultato è nella cella dp[m][n]
        return dp[m][n];
    }
}
