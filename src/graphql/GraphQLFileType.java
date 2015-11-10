package graphql;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GraphQLFileType extends LanguageFileType {
    public static final GraphQLFileType INSTANCE = new GraphQLFileType();

    private GraphQLFileType() {
        super(GraphQLLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GraphQL document";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "GraphQL document";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "graphql";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GraphQLIcons.FILE;
    }
}