package org.scilab.forge.jlatexmath;

/**
 *
 * @author Karol Pelc
 */
public class CancelAtom extends Atom {
    private TeXFormula textFormula;
    private int styl;
    
    public CancelAtom(TeXFormula textFormula, int styl) {
        this.textFormula = textFormula;
        this.styl = styl;
    }

    @Override
    public Box createBox(TeXEnvironment env) {
        Box orgBox = textFormula.root.createBox(env);
        HorizontalBox hBox = new HorizontalBox();
        hBox.add(orgBox);
        Box cancelBox = new CancelBox(orgBox, styl);
        hBox.add(cancelBox);
        return hBox;
    }
}