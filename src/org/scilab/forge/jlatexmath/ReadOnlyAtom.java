package org.scilab.forge.jlatexmath;

/**
 * Atom protexted from being modified. It's important for global atoms which
 * are incorrectly used many times in sourcecode.
 * They are not a solution but only a protection. If any bug situation appear
 * this kind of atom should throw an exception. There are many bugs in
 * JLatexMath where it reuse and modify by adding children or changeing style
 * of atom.
 *
 * @since 2018-09-05, 13:19:39
 * @author Artur Jackowski
 */
public class ReadOnlyAtom extends RowAtom {
    public ReadOnlyAtom(Atom el) {
        super(el);
    }
    
//    @Override
//    public void setPreviousAtom(Dummy prev) {
//        throw new UnsupportedOperationException("Global atoms protection. This is a read only atom.");
//    }

    @Override
    public void add(Atom el) {
        throw new UnsupportedOperationException("Global atoms protection. This is a read only atom.");
    }

    @Override
    public Atom getLastAtom() {
        throw new UnsupportedOperationException("Global atoms protection. This is a read only atom.");
    }
}