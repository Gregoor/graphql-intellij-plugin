package graphql;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class GraphQLLexerAdapter extends FlexAdapter {
    public GraphQLLexerAdapter() {
        super(new _GraphQLLexer((Reader) null));
    }
}
