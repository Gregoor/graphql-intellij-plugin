package graphql;

import com.intellij.lang.Language;

public class GraphQLLanguage extends Language {
    public static final GraphQLLanguage INSTANCE = new GraphQLLanguage();

    private GraphQLLanguage() {
        super("GraphQL");
    }
}