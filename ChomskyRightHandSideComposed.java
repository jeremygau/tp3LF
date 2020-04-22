public class ChomskyRightHandSideComposed implements ChomskyRightHandSide {

    private NonTerminal first;
    private NonTerminal second;


    public ChomskyRightHandSideComposed(NonTerminal n, NonTerminal m){
        first = n;
        second = m;
    }

    @Override
    public String toString() {
        return first.toString()+second.toString();
    }

    @Override
    public boolean isTerminal() {
        return false;
    }


    @Override
    public boolean isComposed() {
        return true;
    }


    public NonTerminal getFirst() {
        return first;
    }

    public NonTerminal getSecond() {
        return second;
    }
}
