package graphql;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class GraphQLPairedBraceMatcher implements PairedBraceMatcher {

    @Override
    public BracePair[] getPairs() {
        return new BracePair[]{
                new BracePair(GraphQLTypes.BRACE1, GraphQLTypes.BRACE2, true),
                new BracePair(GraphQLTypes.PAREN1, GraphQLTypes.PAREN2, false),
                new BracePair(GraphQLTypes.BRACKET1, GraphQLTypes.BRACKET2, false)
        };
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType e1, IElementType e2) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int i) {
        return 0;
    }

}
