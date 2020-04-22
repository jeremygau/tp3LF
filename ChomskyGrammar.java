import java.util.ArrayList;
import java.lang.Exception;
import java.util.Arrays;

public class ChomskyGrammar {
    private NonTerminal axiom;
    private boolean axiomToEpsilon;
    private ArrayList<ChomskyRule> Rules;


    public ChomskyGrammar(NonTerminal a, boolean b){
        axiom = a;
        axiomToEpsilon = b;
        Rules = new ArrayList<ChomskyRule>();
    }


    public void addRule(ChomskyRule r){
        Rules.add(r);
    }


    public void setAxiom (NonTerminal a){
        axiom = a;
    }

    public NonTerminal getAxiom(){
        return axiom;
    }

    public void setAxiomToEpsilon(boolean b){
        axiomToEpsilon = b;
    }

    public boolean getAxiomToEpsilon(){
        return axiomToEpsilon;
    }


    /**
     * retourne pour un non-terminal en membre gauche l'ensemble des membres droits
     * des règles de la grammaire
     * @return l'ensemble sous la forme d'une ArrayList des membres droits pour un non-terminal à gauche
     */
    public ArrayList<ChomskyRightHandSide> SetOfRightHandSides(NonTerminal lhs){
        ArrayList<ChomskyRightHandSide> set = new ArrayList<>();
        for (ChomskyRule rule : Rules) {
            if (rule.getLhs().equals(lhs)) {
                set.add(rule.getRhs());
            }
        }
        return set;
    }



    /**
     * retourne pour un non-terminal et une chaine le fait que le non-terminal engendre la chaine
     * @return vrai si pour la grammaire, la chaine se dérive depuis le non-terminal
     */
    public boolean parse(String s, NonTerminal n){
        if (s.isEmpty()) {
            return n.equals(axiom) && axiomToEpsilon;
        }
        if (s.length() == 1) {
            for (ChomskyRightHandSide crhs : SetOfRightHandSides(n)) {
                if (crhs.toString().equals(s)) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            String w1 = s.substring(0, i);
            String w2 = s.substring(i);
            for (ChomskyRightHandSide crhs : SetOfRightHandSides(n)) {
                if (crhs.isComposed()) {
                    ChomskyRightHandSideComposed crhsc = (ChomskyRightHandSideComposed) crhs;
                    if (parse(w1, crhsc.getFirst()) && parse(w2, crhsc.getSecond())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
