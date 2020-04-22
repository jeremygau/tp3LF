public class ChomskyRule {
    private NonTerminal Lhs;
    private ChomskyRightHandSide Rhs;


    public ChomskyRule(NonTerminal l, ChomskyRightHandSide r){
        Lhs = l; Rhs = r;
    }

    @Override
    public String toString() {
        return Lhs+" -> "+Rhs.toString();
    }

    public NonTerminal getLhs(){
        return Lhs;
    }

    public ChomskyRightHandSide getRhs(){
        return Rhs;
    }

}
