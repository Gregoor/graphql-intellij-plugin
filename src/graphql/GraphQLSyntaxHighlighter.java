package graphql;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil.ImmutableMapBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GraphQLSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final Map<String, TextAttributesKey> KEYS = new HashMap<>();

    static {
        Map<String, TextAttributesKey> highlightKeys =
            new ImmutableMapBuilder<String, TextAttributesKey>()
                .put("OPERATION_TYPE", DefaultLanguageHighlighterColors.KEYWORD)
                .put("OPERATION_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
                .put("FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
                .put("BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
                .build();
        highlightKeys.forEach((s, key) ->
                KEYS.put(s, createTextAttributesKey(s, key)));
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GraphQLLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        String keyString = null;
        if (Arrays.asList(GraphQLTypes.QUERY, GraphQLTypes.MUTATION)
                .contains(tokenType)) {
            keyString = "OPERATION_TYPE";
        } else if (tokenType.equals(GraphQLTypes.FIELD_NAME)) {
            keyString = "FIELD_NAME";
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            keyString = "BAD_CHAR";
        }
        return pack(keyString == null ? null : KEYS.get(keyString));
    }

}
