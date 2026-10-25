package zahr.amira.tp0.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe de service qui génère la réponse à une question.
 * Traitement personnel : "Le Miroir d'Amira". Le serveur cherche des mots-clés
 * dans la question et répond avec un petit conseil adapté (mode, beauté, humeur).
 */
@Dependent
public class GenerateurReponse implements Serializable {

    private boolean roleSystemeAffiche = false;

    /**
     * Génère la réponse à une question.
     *
     * @param question    la question posée par l'utilisateur.
     * @param roleSysteme le rôle système choisi (affiché seulement la première fois).
     * @return un conseil choisi selon les mots-clés trouvés dans la question.
     */
    public String genererReponse(String question, String roleSysteme) {
        String resultat = "";

        if (!this.roleSystemeAffiche && roleSysteme != null) {
            resultat += "Rôle : " + roleSysteme.trim() + "\n\n";
            this.roleSystemeAffiche = true;
        }

        String texte = question.trim();
        String minuscules = texte.toLowerCase(Locale.FRENCH);

        if (minuscules.contains("bonjour") || minuscules.contains("salut")) {
            resultat += "Salam ma belle ! Comment tu te sens aujourd'hui ?";
        } else if (minuscules.contains("robe") || minuscules.contains("tenue")) {
            resultat += "Une robe fluide et des accessoires dorés, tu vas briller !";
        } else if (minuscules.contains("maquillage")) {
            resultat += "Un teint naturel, un peu de blush et un gloss : simple et chic.";
        } else if (minuscules.contains("triste") || minuscules.contains("stress")) {
            resultat += "Respire, prends un thé à la menthe et mets ta chanson préférée.";
        } else if (minuscules.contains("examen")) {
            resultat += "Tu as travaillé, tu vas réussir, ma go !";
        } else {
            resultat += "Hmm, je n'ai pas compris \"" + texte + "\", mais le Miroir d'Amira apprend vite !";
        }
        return resultat;
    }
}