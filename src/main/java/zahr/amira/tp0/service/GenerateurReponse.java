package zahr.amira.tp0.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe de service pour les modificateurs de question.
 */
@Dependent
public class GenerateurReponse implements Serializable {
    private boolean roleSystemeAffiche = false;

    /**
     * Génère une réponse à une question.
     * @param question La question à modifier.
     * @param roleSysteme Le rôle système à utiliser.
     * @return Le rôle système en majuscules au début (s'il n'est pas null), puis la question
     * en minuscules, le tout entouré de "||".
     */
    public String genererReponse(String question, String roleSysteme) {
        String resultat = "||";
        if (!this.roleSystemeAffiche && roleSysteme != null) {
            resultat += roleSysteme.toUpperCase(Locale.FRENCH) + "\n";
            this.roleSystemeAffiche = true;
        }
        resultat += question.toLowerCase(Locale.FRENCH) + "||";
        return resultat;
    }
}