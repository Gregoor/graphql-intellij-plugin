package graphql;

import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.BaseFilterLexer;
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer;
import com.intellij.psi.search.UsageSearchContext;

public class GraphQLFilterLexer extends BaseFilterLexer {
    public GraphQLFilterLexer(final Lexer originalLexer, final OccurrenceConsumer table) {
        super(originalLexer, table);
    }

    @Override
    public void advance() {
        scanWordsInToken(UsageSearchContext.IN_COMMENTS, false, false);
        advanceTodoItemCountsInToken();
        myDelegate.advance();
    }
}
