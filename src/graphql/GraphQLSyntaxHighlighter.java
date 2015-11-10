package graphql;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GraphQLSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey OPERATION_TYPE =
            createTextAttributesKey("OPERATION_TYPE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FIELD_NAME =
            createTextAttributesKey("FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] BAD_CHAR_KEYS =
            new TextAttributesKey[]{createTextAttributesKey("BAD_CHARACTER",
                    HighlighterColors.BAD_CHARACTER)};
    private static final TextAttributesKey[] OPERATION_TYPE_KEYS =
            new TextAttributesKey[]{OPERATION_TYPE};
    private static final TextAttributesKey[] FIELD_NAME_KEYS =
            new TextAttributesKey[]{FIELD_NAME};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GraphQLLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (Arrays.asList(GraphQLTypes.QUERY, GraphQLTypes.MUTATION)
                .contains(tokenType)) {
            return OPERATION_TYPE_KEYS;
        } else if (tokenType.equals(GraphQLTypes.FIELD_NAME)) {
            return FIELD_NAME_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}
