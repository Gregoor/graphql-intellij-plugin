package graphql;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GraphQLTokenType extends IElementType {


    public GraphQLTokenType(@NotNull @NonNls String debugName) {
        super(debugName, GraphQLLanguage.INSTANCE);
    }
}
