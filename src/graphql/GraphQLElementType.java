package graphql;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import graphql.GraphQLLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GraphQLElementType extends IElementType {

    public GraphQLElementType(@NotNull @NonNls String debugName) {
        super(debugName, GraphQLLanguage.INSTANCE);
    }

}
