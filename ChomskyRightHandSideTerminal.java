public class ChomskyRightHandSideTerminal implements ChomskyRightHandSide {

    private Terminal content;

    public ChomskyRightHandSideTerminal(Terminal t){
        content=t;
    }

    @Override
    public String toString() {
        return content.toString();
    }

    @Override
    public boolean isTerminal() {
        return true;
    }


    @Override
    public boolean isComposed() {
        return false;
    }

}

